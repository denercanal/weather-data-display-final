package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;

public abstract class TempoCommand {

    public void executarInserir(ViewDadosTempo viewDadosTempo) throws Exception {
    }

    public void executarRemover(Tempo tempo) throws Exception {
    }

    public void executarGerarLog(ViewConfiguracaoLog viewConfiguracaoLog) throws Exception {
    }

    public void executarGerarGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, String vertical) throws Exception{
    }
}
