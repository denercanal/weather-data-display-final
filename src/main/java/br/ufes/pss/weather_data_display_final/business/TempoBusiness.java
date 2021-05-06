package br.ufes.pss.weather_data_display_final.business;

import br.ufes.pss.weather_data_display_final.command.TempoInserirCommand;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class TempoBusiness {

    
    public void inserir(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
        try {
            validacaoInserir(viewTelaPrincipal);
            new TempoInserirCommand().executarInserir(viewTelaPrincipal);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void validacaoInserir(ViewTelaPrincipal viewTelaPrincipal) throws Exception {
        if ((viewTelaPrincipal.getDataTempo().getText().isBlank()) || viewTelaPrincipal.getDataTempo().getText().equalsIgnoreCase("  /  /    ")) {
            throw new Exception("Favor preencher o campo data!");
        }

        if (viewTelaPrincipal.getTemperaturaTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo temperatura!");
        }

        if (viewTelaPrincipal.getUmidadeTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo umidade!");
        }

        if (viewTelaPrincipal.getPressaoTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo pressão!");
        }
    }
}
