package com.schmeisky.apikata;

import com.schmeisky.apikata.adapters.ApiFetchWeatherDataAdapter;
import com.schmeisky.apikata.adapters.CsvExporterAdapter;
import com.schmeisky.apikata.adapters.WeatherFetchCommandlineAdapter;
import com.schmeisky.apikata.business.WeatherApp;
import com.schmeisky.apikata.ports.ExporterPort;
import com.schmeisky.apikata.ports.FetchWeatherDataPort;
import com.schmeisky.apikata.ports.WeatherFetchTriggerPort;

import java.net.MalformedURLException;
import java.net.URL;

public class APIAccess {

    private static final String STATIONS_LIST= "1,422";

    public static void main(final String[] args) throws MalformedURLException {
        FetchWeatherDataPort dataPort = new ApiFetchWeatherDataAdapter(new URL("https://apis.is/weather/observations/en?stations=" + STATIONS_LIST));
        ExporterPort exporterPort = new CsvExporterAdapter();
        WeatherFetchTriggerPort fetchTriggerPort = new WeatherFetchCommandlineAdapter();
        WeatherApp app = new WeatherApp(dataPort, exporterPort, fetchTriggerPort);
        fetchTriggerPort.fetch();
    }

}
