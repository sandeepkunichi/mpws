package controllers;

import models.DeviceData;
import static play.data.Form.*;

import play.Play;
import play.data.Form;
import play.mvc.*;
import models.Cassandra;

/**
 * Created by Sandeep.K on 1/23/2016.
 */
public class Application extends Controller {

    String keyspace = Play.application().configuration().getString("cassandra.keyspace");
    String host = Play.application().configuration().getString("cassandra.host");
    Cassandra cassandraDB = new Cassandra(this.keyspace, this.host);

    public Result index() {
        return ok("Web service is active");
    }

    //TODO: Add authorization and authentication to the put and get methods
    public Result putDeviceData(){
        Form<DeviceData> deviceData = form(DeviceData.class).bindFromRequest();
        if(deviceData.hasErrors()) {
            return badRequest(deviceData.errorsAsJson());
        } else {
            return ok(cassandraDB.putDeviceData(deviceData));
        }
    }

    public Result getDeviceData(){
        return ok(cassandraDB.getDeviceData());
    }

    public Result getDeviceDataById(String id){
        return ok(cassandraDB.getDeviceDataById(id));
    }

}
