package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public abstract class TempoCommand {

    public void executarInserir(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
    }

    public void executarAtualizar(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
    }

    public void executarRemover(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
    }

    public void executarGerarLog(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
    }

    public void executarGerarGrafico(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
    }
}
