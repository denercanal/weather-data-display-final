package br.ufes.pss.weather_data_display_final.observer;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import java.util.ArrayList;

public abstract class TempoObserver {

    private ArrayList<ITempoObserver> observers = new ArrayList<>();

    public void add(ITempoObserver iTempoObserver) {
        this.observers.add(iTempoObserver);
    }

    public void notifica() {
        for (var observer : this.observers) {
            observer.update(TempoCollection.getTempoCollection());
        }
    }
}
