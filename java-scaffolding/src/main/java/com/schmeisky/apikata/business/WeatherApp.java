package com.schmeisky.apikata.business;

import com.schmeisky.apikata.ports.ExporterPort;
import com.schmeisky.apikata.ports.FetchWeatherDataPort;
import com.schmeisky.apikata.ports.WeatherData;
import com.schmeisky.apikata.ports.WeatherFetchTriggerPort;

import java.io.File;
import java.util.List;

public class WeatherApp {
    private ExporterPort exporterPort;
    private FetchWeatherDataPort fetchWeatherDataPort;
    private WeatherFetchTriggerPort weatherFetchTriggerPort;

     public WeatherApp(FetchWeatherDataPort dataPort, ExporterPort exporterPort, WeatherFetchTriggerPort drivingPort) {
        this.fetchWeatherDataPort = dataPort;
        this.exporterPort = exporterPort;
        this.weatherFetchTriggerPort = drivingPort;
         drivingPort.setApp(this);
     }

     public void downloadTheWeather() {
         List<WeatherData> data = fetchWeatherDataPort.getData();
         File dir = new File("src/test/resources/");
         File outputFile = new File(dir, "weather.csv");
         exporterPort.export(data, outputFile);
     }

}
