package com.schmeisky.apikata.ports;


public record WeatherData(int id, String name, String date, String time, String temperature, String pressure, String windDirection) {

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", temperature='" + temperature + '\'' +
                ", pressure='" + pressure + '\'' +
                ", windDirection='" + windDirection + '\'' +
                '}';
    }
}
