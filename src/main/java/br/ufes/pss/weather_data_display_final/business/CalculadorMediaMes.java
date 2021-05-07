package br.ufes.pss.weather_data_display_final.business;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CalculadorMediaMes extends CalculadorMediaTempo {

    @Override
    protected ArrayList<Tempo> filtrarPorPeriodo(TempoCollection registros) {
        
        var hoje = LocalDate.now();
        var primeiroDiaMes = hoje.plusDays( 1 - hoje.getDayOfMonth() );
        var listStream = registros.getAllTempos().stream();
        
        // Menor ou igual a data atual && Menor ou igual ao dia 01/mesAtual
        var streamFilter = listStream.filter((tempo) -> tempo.getDataTempo().isBefore(hoje.plusDays(1)) && tempo.getDataTempo().isAfter(primeiroDiaMes.plusDays(-1)) );
       
        return (ArrayList<Tempo>) streamFilter.collect(Collectors.toList());
    }

}
