package br.ufes.pss.weather_data_display_final.calculator;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalculadorMediaMes extends CalculadorMediaTempo {

    @Override
    protected ArrayList<Tempo> filtrarPorPeriodo(TempoCollection tempoCollection) {

        var mes = LocalDate.now().getMonth().getValue();
        var tempos = tempoCollection.getAllTempos();
        var periodo = new ArrayList<Tempo>();
        for (Tempo tempo : tempos) {
            if (tempo.getDataTempo().getMonthValue() == mes) {
                periodo.add(tempo);
            }
        }
        return periodo;
    }

}
