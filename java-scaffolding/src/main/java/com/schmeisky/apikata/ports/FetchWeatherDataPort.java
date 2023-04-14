package com.schmeisky.apikata.ports;

import java.util.List;

public interface FetchWeatherDataPort {

    List<WeatherData> getData();
}
