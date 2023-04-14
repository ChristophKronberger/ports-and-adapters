package com.schmeisky.apikata.adapters;

import com.schmeisky.apikata.ports.WeatherData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WeatherDataMapper {

    @Mapping(target = "time", expression = "java(TimestampParsingUtil.parseTimeStamp(adapterWeatherData.timeStamp())[1])")
    @Mapping(target = "date", expression = "java(TimestampParsingUtil.parseTimeStamp(adapterWeatherData.timeStamp())[0])")
    WeatherData apiToBusiness(ApiWeatherData adapterWeatherData);
}
