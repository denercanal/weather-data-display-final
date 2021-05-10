package br.ufes.pss.weather_data_display_final.adapter;

import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

public class AdapterJson extends Adapter {

    private PrintJson printJson;

    public AdapterJson() {
        this.printJson = new PrintJson();
    }

    @Override
    public void adaptar(Tempo tempo) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        var arquivo = json.toJson(tempo);
        printJson.printTempoToJson(arquivo);
    }

    @Override
    public void adaptar(TempoMedia tempoMedia) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        var arquivo = json.toJson(tempoMedia);
        printJson.printTempoMediaToJson(arquivo);
    }

    @Override
    public void adaptar(GraficoOptions graficoOptions) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        var arquivo = json.toJson(graficoOptions);
        printJson.printGraficoToJson(arquivo);
    }
}
