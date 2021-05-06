package br.ufes.pss.weather_data_display_final.observer;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import java.util.ArrayList;

public abstract class TempoObservado {

    private ArrayList<ITempoObservador> observadores = new ArrayList<>();

    public void add(ITempoObservador iTempoObservador) {
        this.observadores.add(iTempoObservador);
    }

    public void notifica() {
        for (var observer : this.observadores) {
            observer.update(TempoCollection.getTempoCollection());
        }
    }
}
