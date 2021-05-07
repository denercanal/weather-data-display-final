package br.ufes.pss.weather_data_display_final.business;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CalculadorMediaDia extends CalculadorMediaTempo{

    @Override
    protected ArrayList<Tempo> filtrarPorPeriodo(TempoCollection registros) {
        return (ArrayList<Tempo>) registros.getAllTempos().stream().filter((tempo) -> {
            return tempo.getDataTempo().isEqual(LocalDate.now());
        }).collect(Collectors.toList());
    }

}
