package br.ufes.pss.weather_data_display_final.adapter;

import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import com.github.underscore.lodash.U;
import com.google.gson.Gson;
import java.io.IOException;

public class AdapterXml extends Adapter {

    private PrintXml printXml;

    public AdapterXml() {
        printXml = new PrintXml();
    }

    @Override
    public void adaptar(Tempo tempo) throws IOException {
        Gson json = new Gson();
        var arquivo = json.toJson(tempo);

        String xml = U.jsonToXml(arquivo);

        printXml.printTempoToXml(xml);
    }

    @Override
    public void adaptar(TempoMedia tempoMedia) throws IOException {
        Gson json = new Gson();
        var arquivo = json.toJson(tempoMedia);

        String xml = U.jsonToXml(arquivo);

        printXml.printTempoMediaToXml(xml);
    }

    @Override
    public void adaptar(GraficoOptions graficoOptions) throws IOException {
        Gson json = new Gson();
        var arquivo = json.toJson(graficoOptions);

        String xml = U.jsonToXml(arquivo);

        printXml.printGraficoToXml(xml);
    }

}
