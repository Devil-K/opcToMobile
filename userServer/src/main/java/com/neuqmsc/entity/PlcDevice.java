package com.neuqmsc.entity;
public class PlcDevice {
    private String deviceName;

    private Float deviceValue;

    private String deviceTime;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Float getDeviceValue() {
        return deviceValue;
    }

    public void setDeviceValue(Float deviceValue) {
        this.deviceValue = deviceValue;
    }

    public String getDeviceTime() {
        return deviceTime;
    }

    public void setDeviceTime(String deviceTime) {
        this.deviceTime = deviceTime == null ? null : deviceTime.trim();
    }

    @Override
    public String toString() {
        return "PlcDevice{" +
                "deviceName='" + deviceName + '\'' +
                ", deviceValue=" + deviceValue +
                ", deviceTime='" + deviceTime + '\'' +
                '}';
    }
}