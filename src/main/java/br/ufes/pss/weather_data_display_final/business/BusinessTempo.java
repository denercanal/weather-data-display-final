package br.ufes.pss.weather_data_display_final.business;

import br.ufes.pss.weather_data_display_final.command.TempoInserirCommand;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTabelaTempo;

public class BusinessTempo {

    
    public void inserir(ViewDadosTempo viewDadosTempo) throws Exception {
        try {
            validacaoInserir(viewDadosTempo);
            new TempoInserirCommand().executarInserir(viewDadosTempo);
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void validacaoInserir(ViewDadosTempo viewDadosTempo) throws Exception {
        if ((viewDadosTempo.getDataTempo().getText().isBlank()) || viewDadosTempo.getDataTempo().getText().equalsIgnoreCase("  /  /    ")) {
            throw new Exception("Favor preencher o campo data!");
        }

        if (viewDadosTempo.getTemperaturaTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo temperatura!");
        }

        if (viewDadosTempo.getUmidadeTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo umidade!");
        }

        if (viewDadosTempo.getPressaoTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo pressão!");
        }
    }

    public void remover(ViewTabelaTempo viewTabelaTempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
