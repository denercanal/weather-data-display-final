package br.ufes.pss.weather_data_display_final.calculator;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;

public interface ICalculadorMediaTempo {
    public TempoMedia calcular(TempoCollection tempoCollection);
}
