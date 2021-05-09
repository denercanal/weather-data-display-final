package br.ufes.pss.weather_data_display_final.calculator;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;

public class CalculadorMediaSemana extends CalculadorMediaTempo {

    @Override
    protected ArrayList<Tempo> filtrarPorPeriodo(TempoCollection tempoCollection) {

        LocalDate date = LocalDate.now();
        int semanaAno = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);

        var tempos = tempoCollection.getAllTempos();
        var periodo = new ArrayList<Tempo>();

        for (Tempo tempo : tempos) {
            var localDate = tempo.getDataTempo();
            var semana = localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
            if (semanaAno == semana) {
                periodo.add(tempo);
            }
        }
        return periodo;
    }
}
