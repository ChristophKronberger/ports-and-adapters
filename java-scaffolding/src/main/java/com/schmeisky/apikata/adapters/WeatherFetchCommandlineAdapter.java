package com.schmeisky.apikata.adapters;

import com.schmeisky.apikata.business.WeatherApp;
import com.schmeisky.apikata.ports.WeatherFetchTriggerPort;

public class WeatherFetchCommandlineAdapter implements WeatherFetchTriggerPort {

    private WeatherApp weatherApp = null;

    public WeatherFetchCommandlineAdapter() {
    }

    @Override
    public void fetch() {
        weatherApp.downloadTheWeather();
    }

    @Override
    public void setApp(WeatherApp weatherApp) {
        this.weatherApp = weatherApp;
    }

}
