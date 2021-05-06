package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TempoInserirCommand extends TempoCommand {

    @Override
    public void executarInserir(ViewTelaPrincipal viewTelaPrincipal) throws Exception {

        try {
            Tempo tempo = new Tempo();
            
            tempo.setDataTempo(LocalDate.parse(viewTelaPrincipal.getDataTempo().getText().toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            tempo.setTemperaturaTempo(Double.parseDouble(viewTelaPrincipal.getTemperaturaTempo().getText()));
            tempo.setUmidadeTempo(Double.parseDouble(viewTelaPrincipal.getUmidadeTempo().getText()));
            tempo.setPressaoTempo(Double.parseDouble(viewTelaPrincipal.getPressaoTempo().getText()));
            
            TempoCollection.getTempoCollection().inserir(tempo);
        } catch (Exception e) {
            throw e;
        }
    }
}
