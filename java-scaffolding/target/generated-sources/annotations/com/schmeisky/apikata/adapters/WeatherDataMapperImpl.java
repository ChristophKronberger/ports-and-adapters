package com.schmeisky.apikata.adapters;

import com.schmeisky.apikata.ports.WeatherData;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-14T13:24:32+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class WeatherDataMapperImpl implements WeatherDataMapper {

    @Override
    public WeatherData apiToBusiness(ApiWeatherData adapterWeatherData) {
        if ( adapterWeatherData == null ) {
            return null;
        }

        int id = 0;
        String name = null;
        String temperature = null;
        String pressure = null;
        String windDirection = null;

        id = adapterWeatherData.id();
        name = adapterWeatherData.name();
        temperature = adapterWeatherData.temperature();
        pressure = adapterWeatherData.pressure();
        windDirection = adapterWeatherData.windDirection();

        String time = TimestampParsingUtil.parseTimeStamp(adapterWeatherData.timeStamp())[1];
        String date = TimestampParsingUtil.parseTimeStamp(adapterWeatherData.timeStamp())[0];

        WeatherData weatherData = new WeatherData( id, name, date, time, temperature, pressure, windDirection );

        return weatherData;
    }
}
