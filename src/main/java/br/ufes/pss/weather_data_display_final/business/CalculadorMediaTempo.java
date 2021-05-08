package br.ufes.pss.weather_data_display_final.business;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import java.util.ArrayList;

public abstract class CalculadorMediaTempo implements ICalculadorMediaTempo {
    
    protected abstract ArrayList<Tempo> filtrarPorPeriodo(TempoCollection registros);
    
    @Override
    public TempoMedia calcular(TempoCollection tempoCollection) {
        ArrayList<Tempo> registrosDoDia = filtrarPorPeriodo(tempoCollection);
        
        int qtdRegistros = registrosDoDia.size();
        
        if(qtdRegistros == 0){
            throw new RuntimeException("Não há nenhum registro a ser calculado");
        }
        
        Double temperatura = 0D;
        Double humidade = 0D;
        Double pressao = 0D;
        
        for(Tempo t: registrosDoDia){
            temperatura += t.getTemperaturaTempo();
            humidade += t.getUmidadeTempo();
            pressao += t.getPressaoTempo();
        }
        
        var tempo = new TempoMedia();
        tempo.setTemperaturaTempo(temperatura/qtdRegistros);
        tempo.setUmidadeTempo(humidade/qtdRegistros);
        tempo.setPressaoTempo(pressao/qtdRegistros);
        tempo.setQuantidadeTempo(qtdRegistros);
        
        return tempo;
        
    }

}
