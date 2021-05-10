package br.ufes.pss.weather_data_display_final.calculator;

import br.ufes.pss.weather_data_display_final.adapter.AdapterJson;
import br.ufes.pss.weather_data_display_final.adapter.AdapterXml;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import br.ufes.pss.weather_data_display_final.presenter.PresenterConfiguracaoLog;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CalculadorMediaTempo implements ICalculadorMediaTempo {

    protected abstract ArrayList<Tempo> filtrarPorPeriodo(TempoCollection tempoCollection);

    @Override
    public TempoMedia calcular(TempoCollection tempoCollection) {
        ArrayList<Tempo> registrosTempo = filtrarPorPeriodo(tempoCollection);

        int quantidadeRegistros = registrosTempo.size();

        if (quantidadeRegistros == 0) {
            throw new RuntimeException("Não há nenhum registro a ser calculado");
        }

        Double temperatura = 0D;
        Double umidade = 0D;
        Double pressao = 0D;

        for (Tempo tempo : registrosTempo) {
            temperatura += tempo.getTemperaturaTempo();
            umidade += tempo.getUmidadeTempo();
            pressao += tempo.getPressaoTempo();
        }

        var tempo = tempoCalculado(temperatura, umidade, pressao, quantidadeRegistros);
        try {
            gerarLog(tempo);
        } catch (IOException ex) {
        }
        return tempo;

    }

    private TempoMedia tempoCalculado(Double temperatura, Double umidade, Double pressao, int quantidadeRegistros) {
        var tempo = new TempoMedia();
        tempo.setTemperaturaTempo(temperatura / quantidadeRegistros);
        tempo.setUmidadeTempo(umidade / quantidadeRegistros);
        tempo.setPressaoTempo(pressao / quantidadeRegistros);
        tempo.setQuantidadeTempo(quantidadeRegistros);
        return tempo;
    }

    private void gerarLog(TempoMedia tempoMedia) throws IOException {
        var viewConfiguracaoLog = PresenterConfiguracaoLog.getViewConfiguracaoLog();
        if (viewConfiguracaoLog.getLogOptions().getSelectedItem().equals("JSON")) {
            tempoMedia.setTipoLog("calcular");
            tempoMedia.setDataTempo(LocalDate.now());
            new AdapterJson().adaptar(tempoMedia);
        } else {
            tempoMedia.setTipoLog("calcular");
            tempoMedia.setDataTempo(LocalDate.now());
            new AdapterXml().adaptar(tempoMedia);
        }
    }
}
