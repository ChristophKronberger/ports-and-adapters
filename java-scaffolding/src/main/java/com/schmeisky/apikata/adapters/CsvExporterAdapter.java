package com.schmeisky.apikata.adapters;

import com.schmeisky.apikata.ports.ExporterPort;
import com.schmeisky.apikata.ports.WeatherData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvExporterAdapter implements ExporterPort {

    private static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT
            .builder()
            .setHeader("id", "name", "date", "time", "temperature", "pressure", "wind_direction")
            .setRecordSeparator("\n")
            .build();

    @Override
    public void export(List<WeatherData> data, File dest) {
        try {
            exportThrowing(data, dest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void exportThrowing(List<WeatherData> data, File dest) throws IOException {
        StringWriter writer = new StringWriter();
        try (final CSVPrinter printer = new CSVPrinter(writer, CSV_FORMAT)) {
            data.forEach(entity -> print(printer, entity));
        }

        try (FileOutputStream outputStream = new FileOutputStream(dest)) {
            IOUtils.write(writer.toString(), outputStream, StandardCharsets.UTF_8);
        }
    }

    private static void print(CSVPrinter printer, WeatherData entity) {
        try {
            printer.printRecord(entity.id(), entity.name(), entity.date(), entity.time(), entity.temperature(), entity.pressure(), entity.windDirection());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
