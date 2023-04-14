package com.schmeisky.apikata.adapters;

import com.schmeisky.apikata.ports.ExporterPort;
import com.schmeisky.apikata.ports.WeatherData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CsvExporterAdapterTest {

    @Test
    public void export_writesDataAsCsv(@TempDir File exportedDir) throws Exception {
        List<WeatherData> inputData = aWeatherDataList();
        ExporterPort csvExporter = new CsvExporterAdapter();
        File file = new File(exportedDir, "testFile.csv");
        file.createNewFile();

        csvExporter.export(inputData, file);

        assertThat(file).exists();
        assertThat(file).content().isEqualTo(
                "id,name,date,time,temperature,pressure,wind_direction\n" +
                        "1,Vienna,2023-04-14,13:37:00,20,1000,N\n" +
                        "2,Potsdam,2023-04-13,00:23:42,\"-11,7\",999,S\n" +
                        "3,Prague,2023-04-13,00:23:42,\"-11,7\",999,\n");
    }

    private List<WeatherData> aWeatherDataList() {
        WeatherData item1 = new WeatherData(1, "Vienna", "2023-04-14", "13:37:00", "20", "1000", "N");
        WeatherData item2 = new WeatherData(2, "Potsdam", "2023-04-13", "00:23:42", "-11,7","999", "S");
        WeatherData item3 = new WeatherData(3, "Prague", "2023-04-13", "00:23:42", "-11,7","999", null);
        return List.of(item1, item2, item3);
    }
}
