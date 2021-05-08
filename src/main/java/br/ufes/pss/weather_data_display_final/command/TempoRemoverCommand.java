package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.log.Logger;
import br.ufes.pss.weather_data_display_final.model.Tempo;

public class TempoRemoverCommand extends TempoCommand {

    @Override
    public void executarRemover(Tempo tempo) throws Exception {
        try {
            tempo.setTipoLog("remover");
            Logger.salvarLog(tempo);
            TempoCollection.getTempoCollection().remover(tempo);
        } catch (Exception e) {
            throw new Exception("Tabela vazia!");
        }
    }

}
