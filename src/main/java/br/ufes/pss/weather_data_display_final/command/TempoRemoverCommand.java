package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.adapter.AdapterJson;
import br.ufes.pss.weather_data_display_final.adapter.AdapterXml;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.presenter.PresenterConfiguracaoLog;
import java.io.IOException;

public class TempoRemoverCommand extends TempoCommand {

    @Override
    public void executarRemover(Tempo tempo) throws Exception {

        gerarLog(tempo);
        TempoCollection.getTempoCollection().remover(tempo);
    }

    private void gerarLog(Tempo tempo) throws IOException {
        var viewLog = PresenterConfiguracaoLog.getViewConfiguracaoLog();
        tempo.setTipoLog("remover");
        if (viewLog.getLogOptions().getSelectedItem().equals("JSON")) {
            new AdapterJson().adaptar(tempo);
        } else {
            new AdapterXml().adaptar(tempo);
        }
    }

}
