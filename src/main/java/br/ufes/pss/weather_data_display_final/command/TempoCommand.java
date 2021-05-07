package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoGrafico;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;

public abstract class TempoCommand {

    public void executarInserir(ViewDadosTempo viewDadosTempo) throws Exception {
    }

    public void executarRemover(Tempo tempo) throws Exception {
    }

    public void executarGerarLog(ViewConfiguracaoLog viewConfiguracaoLog) throws Exception {
    }

    public void executarGerarGrafico(ViewConfiguracaoGrafico viewConfiguracaoGrafico) throws Exception {
    }
}
