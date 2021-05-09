package br.ufes.pss.weather_data_display_final.log;

import br.ufes.pss.weather_data_display_final.model.Tempo;
import com.github.underscore.lodash.U;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Logger {

    public static void salvarLog(Tempo tempo) {
        Gson json = new Gson();
        var arquivo = json.toJson(tempo);

        String xml = U.jsonToXml(arquivo);

        LogConfig.getJsonArray().put(arquivo);
        LogConfig.getXmlArray().append(xml);

        try {
            Path currentRelativePath = Paths.get("");
            String path = currentRelativePath.toAbsolutePath().toString();

            FileWriter fileJson = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/log/storage/log.json");
            fileJson.write(LogConfig.getJsonArray().toString());
            fileJson.close();

            FileWriter fileXml = new FileWriter(path + "/src/main/java/br/ufes/pss/weather_data_display_final/log/storage/log.xml");
            fileXml.write(LogConfig.getXmlArray().toString());
            fileXml.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
