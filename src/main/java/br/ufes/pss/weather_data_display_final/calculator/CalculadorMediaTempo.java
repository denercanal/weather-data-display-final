package br.ufes.pss.weather_data_display_final.calculator;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.log.Logger;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import java.util.ArrayList;

public abstract class CalculadorMediaTempo implements ICalculadorMediaTempo {
    
    protected abstract ArrayList<Tempo> filtrarPorPeriodo(TempoCollection tempoCollection);
    
    @Override
    public TempoMedia calcular(TempoCollection tempoCollection) {
        ArrayList<Tempo> registrosTempo = filtrarPorPeriodo(tempoCollection);
        
        int quantidadeRegistros = registrosTempo.size();
        
        if(quantidadeRegistros == 0){
            throw new RuntimeException("Não há nenhum registro a ser calculado");
        }
        
        Double temperatura = 0D;
        Double humidade = 0D;
        Double pressao = 0D;
        
        for(Tempo tempo: registrosTempo){
            temperatura += tempo.getTemperaturaTempo();
            humidade += tempo.getUmidadeTempo();
            pressao += tempo.getPressaoTempo();
        }
        
        var tempo = new TempoMedia();
        tempo.setTemperaturaTempo(temperatura/quantidadeRegistros);
        tempo.setUmidadeTempo(humidade/quantidadeRegistros);
        tempo.setPressaoTempo(pressao/quantidadeRegistros);
        tempo.setQuantidadeTempo(quantidadeRegistros);

        tempo.setTipoLog("calcular");
        Logger.salvarLog(tempo);
        return tempo;
        
    }

}
