package models;

import com.datastax.driver.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.data.Form;
import play.libs.Json;

import java.util.List;
import java.util.UUID;

/**
 * Created by Sandeep.K on 1/23/2016.
 */
public class Cassandra {

    private static String keyspace;
    private static String host;
    private static Cluster cluster;
    private static Session session;

    public Cassandra(){

    }

    public Cassandra(String keyspace, String host){
        this.keyspace = keyspace;
        this.host = host;
        this.cluster = Cluster.builder().addContactPoints(this.host).build();
        this.session = cluster.connect(this.keyspace);
    }

    public JsonNode putDeviceData(Form<DeviceData> deviceData){
        ObjectNode response = JsonNodeFactory.instance.objectNode();
        String id = UUID.randomUUID().toString();
        deviceData.data().put("id", id);
        JsonNode node = Json.toJson(deviceData.data());
        try{
            PreparedStatement statement = session.prepare("INSERT INTO DeviceData JSON ?");
            BoundStatement boundStatement = new BoundStatement(statement);
            session.execute(boundStatement.bind(node.toString()));
            response.put("message", "Record created successfully");
            response.put("id", id);
        }catch(Exception ex){
            response.put("error", ex.getMessage());
        }
        return response;
    }

    public JsonNode getDeviceData(){
        ObjectNode response = JsonNodeFactory.instance.objectNode();
        ArrayNode allDevices = JsonNodeFactory.instance.arrayNode();
        ObjectMapper jsonMapper = new ObjectMapper();
        try{
            List<Row> rows = session.execute("SELECT JSON * FROM DeviceData").all();
            for (Row row : rows){
                allDevices.add(jsonMapper.readTree(row.getString(0)));
            }
            response.put("totalSize", rows.size());
            response.put("records", allDevices);
        }catch (Exception ex){
            response.put("error", ex.getMessage());
        }
        return response;
    }

    public JsonNode getDeviceDataById(String id){
        ObjectNode response = JsonNodeFactory.instance.objectNode();
        ArrayNode allDevices = JsonNodeFactory.instance.arrayNode();
        ObjectMapper jsonMapper = new ObjectMapper();
        try{
            List<Row> rows = session.execute("SELECT JSON * FROM DeviceData WHERE ID = "+id).all();
            for (Row row : rows){
                allDevices.add(jsonMapper.readTree(row.getString(0)));
            }
            response.put("totalSize", rows.size());
            response.put("records", allDevices);
        }catch (Exception ex){
            response.put("error", ex.getMessage());
        }
        return response;
    }

}
