package br.ufes.pss.weather_data_display_final.adapter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintXml {

    public void printTempoToXml(String printToXml) throws IOException {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        FileWriter fileWriter = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/logs/log_tempo.xml", true);
        fileWriter.write(printToXml);
        fileWriter.close();
    }

    public void printTempoMediaToXml(String printToXml) throws IOException {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        FileWriter fileWriter = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/logs/log_tempo_media.xml", true);
        fileWriter.write(printToXml);
        fileWriter.close();
    }

    public void printGraficoToXml(String printToXml) throws IOException {

        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();

        FileWriter fileWriter = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/logs/log_grafico.xml", true);
        fileWriter.write(printToXml);
        fileWriter.close();
    }

}
