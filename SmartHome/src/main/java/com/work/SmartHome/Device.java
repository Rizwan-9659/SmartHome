package com.work.SmartHome;

public class Device {
    private int id;
    private String type;
    private String name;
    private String status;

    public Device(int id, String type, String name, String status) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.status = status;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getName() { return name; }
    public String getStatus() { return status; }

    public void turnOn() { status = "ON"; }
    public void turnOff() { status = "OFF"; }
}
