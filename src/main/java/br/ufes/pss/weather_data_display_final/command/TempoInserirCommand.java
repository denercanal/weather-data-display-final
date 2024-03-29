package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.adapter.AdapterJson;
import br.ufes.pss.weather_data_display_final.adapter.AdapterXml;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.presenter.PresenterConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TempoInserirCommand extends TempoCommand {

    @Override
    public void executarInserir(ViewDadosTempo viewDadosTempo) throws Exception {

        try {
            Tempo tempo = new Tempo();

            this.getDadosTempo(viewDadosTempo, tempo);
            gerarLog(tempo);
            TempoCollection.getTempoCollection().inserir(tempo);
        } catch (Exception e) {
            throw e;
        }
    }

    private Tempo getDadosTempo(ViewDadosTempo viewDadosTempo, Tempo tempo) {
        tempo.setDataTempo(LocalDate.parse(viewDadosTempo.getDataTempo().getText().toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        tempo.setTemperaturaTempo(Double.parseDouble(viewDadosTempo.getTemperaturaTempo().getText()));
        tempo.setUmidadeTempo(Double.parseDouble(viewDadosTempo.getUmidadeTempo().getText()));
        tempo.setPressaoTempo(Double.parseDouble(viewDadosTempo.getPressaoTempo().getText()));
        return tempo;
    }

    private void gerarLog(Tempo tempo) throws IOException {
        var viewLog = PresenterConfiguracaoLog.getViewConfiguracaoLog();
        tempo.setTipoLog("inserir");
        if (viewLog.getLogOptions().getSelectedItem().equals("JSON")) {
            new AdapterJson().adaptar(tempo);
        } else {
            new AdapterXml().adaptar(tempo);
        }
    }
}
