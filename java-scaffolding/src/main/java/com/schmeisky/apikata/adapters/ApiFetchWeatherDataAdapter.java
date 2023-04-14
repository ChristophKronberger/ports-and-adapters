package com.schmeisky.apikata.adapters;

import com.google.gson.Gson;
import com.schmeisky.apikata.ports.WeatherData;
import com.schmeisky.apikata.ports.FetchWeatherDataPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ApiFetchWeatherDataAdapter implements FetchWeatherDataPort {

    private static final WeatherDataMapperImpl WEATHER_DATA_MAPPER = new WeatherDataMapperImpl();
    private final URL location;

    public ApiFetchWeatherDataAdapter(URL location) {
        this.location = location;
    }

    public List<WeatherData> getData() {
        try {
            try (InputStream inputStream = location.openStream();
            ) {
                return parseWeatherDataFromStream(inputStream);
            }
        } catch (Exception e) {
            throw new RuntimeException("unable to readData", e);
        }
    }


    private List<WeatherData> parseWeatherDataFromStream(InputStream inputStream) throws IOException {
        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            final Gson gson = new Gson();
            ApiWeatherDataResult adapterWeatherData = gson.fromJson(inputStreamReader, ApiWeatherDataResult.class);
            return toWeatherData(adapterWeatherData.results());
        }
    }

    private List<WeatherData> toWeatherData(List<ApiWeatherData> results) {
      return results.stream()
                .map(WEATHER_DATA_MAPPER::apiToBusiness)
                .toList();
    }

}




