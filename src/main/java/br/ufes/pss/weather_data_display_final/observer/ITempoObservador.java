package br.ufes.pss.weather_data_display_final.observer;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;

public interface ITempoObservador {

    public void update(TempoCollection tempoCollection);
}
