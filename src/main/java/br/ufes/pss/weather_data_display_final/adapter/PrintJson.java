package br.ufes.pss.weather_data_display_final.adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintJson {

    public void printTempoToJson(String printToJson) throws IOException {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        FileWriter fileWriter = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/logs/log_tempo.json", true);
        fileWriter.write(printToJson);
        fileWriter.close();
    }

    public void printTempoMediaToJson(String printToJson) throws IOException {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        FileWriter fileWriter = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/logs/log_tempo_media.json", true);
        fileWriter.write(printToJson);
        fileWriter.close();
    }

    public void printGraficoToJson(String printToJson) throws IOException {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        FileWriter fileWriter = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/logs/log_grafico.json", true);
        fileWriter.write(printToJson);
        fileWriter.close();
    }
}
