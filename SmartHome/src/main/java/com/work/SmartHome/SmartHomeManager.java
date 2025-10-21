package com.work.SmartHome;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeManager {
    private final List<Device> devices = new ArrayList<>();

    public SmartHomeManager() {
        // Hardcoded devices
        devices.add(new Device(1, "Light", "Living Room Light", "OFF"));
        devices.add(new Device(2, "Fan", "Bedroom Fan", "OFF"));
        devices.add(new Device(3, "AC", "Hall Air Conditioner", "OFF"));
        devices.add(new Device(4, "Heater", "Bathroom Heater", "OFF"));
    }

    public List<Device> getDevices() { return devices; }

    public Device getDevice(int id) {
        for (Device d : devices) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    public void controlDevice(int id, boolean turnOn) {
        Device d = getDevice(id);
        if (d != null) {
            if (turnOn) d.turnOn();
            else d.turnOff();
            System.out.println((turnOn ? "✅ Turned ON: " : "🔴 Turned OFF: ") + d.getName());
        } else {
            System.out.println("⚠️ Device not found for ID: " + id);
        }
    }
}
