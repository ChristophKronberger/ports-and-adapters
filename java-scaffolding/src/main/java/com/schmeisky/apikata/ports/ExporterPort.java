package com.schmeisky.apikata.ports;

import java.io.File;
import java.util.List;

public interface ExporterPort {

    void export(List<WeatherData> data, File dest);
}
