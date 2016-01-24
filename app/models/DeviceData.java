package models;

import play.data.validation.Constraints;

/**
 * Created by Sandeep.K on 1/23/2016.
 */
public class DeviceData {

    private String id;
    @Constraints.Required(message = "GatewayType cannot be empty")
    private String GatewayType;
    @Constraints.Required(message = "GatewayID cannot be empty")
    private double GatewayID;
    @Constraints.Required(message = "DeviceType cannot be empty")
    private int DeviceType;
    @Constraints.Required(message = "DeviceID cannot be empty")
    private double DeviceID;
    @Constraints.Required(message = "ExtensionID cannot be empty")
    private int ExtensionID;
    @Constraints.Required(message = "FunctionName cannot be empty")
    private String FunctionName;
    @Constraints.Required(message = "Year cannot be empty")
    private int Year;
    @Constraints.Required(message = "Month cannot be empty")
    private int Month;
    @Constraints.Required(message = "Day cannot be empty")
    private int Day;
    @Constraints.Required(message = "Hour cannot be empty")
    private int Hour;
    @Constraints.Required(message = "Minute cannot be empty")
    private int Minute;
    @Constraints.Required(message = "Second cannot be empty")
    private int Second;
    @Constraints.Required(message = "DataType cannot be empty")
    private int DataType;
    @Constraints.Required(message = "Value1 cannot be empty")
    private double Value1;
    @Constraints.Required(message = "Value3 cannot be empty")
    private double Value3;


    public String validate() {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGatewayType() {
        return GatewayType;
    }

    public void setGatewayType(String gatewayType) {
        GatewayType = gatewayType;
    }

    public double getGatewayID() {
        return GatewayID;
    }

    public void setGatewayID(double gatewayID) {
        GatewayID = gatewayID;
    }

    public int getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(int deviceType) {
        DeviceType = deviceType;
    }

    public double getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(double deviceID) {
        DeviceID = deviceID;
    }

    public int getExtensionID() {
        return ExtensionID;
    }

    public void setExtensionID(int extensionID) {
        ExtensionID = extensionID;
    }

    public String getFunctionName() {
        return FunctionName;
    }

    public void setFunctionName(String functionName) {
        FunctionName = functionName;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public int getMinute() {
        return Minute;
    }

    public void setMinute(int minute) {
        Minute = minute;
    }

    public int getSecond() {
        return Second;
    }

    public void setSecond(int second) {
        Second = second;
    }

    public int getDataType() {
        return DataType;
    }

    public void setDataType(int dataType) {
        DataType = dataType;
    }

    public double getValue1() {
        return Value1;
    }

    public void setValue1(double value1) {
        Value1 = value1;
    }

    public double getValue3() {
        return Value3;
    }

    public void setValue3(double value3) {
        Value3 = value3;
    }

}
