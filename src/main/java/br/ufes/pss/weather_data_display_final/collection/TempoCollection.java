package br.ufes.pss.weather_data_display_final.collection;

import br.ufes.pss.weather_data_display_final.model.Tempo;
import java.util.ArrayList;

public class TempoCollection {

    private ArrayList<Tempo> tempos;
    private static TempoCollection tempoCollection;

    public TempoCollection(ArrayList<Tempo> tempos) {
        if (tempos != null) {
            this.tempos = tempos;
        }
    }

    public static TempoCollection getTempoCollection() {
        if (tempoCollection == null) {
            return tempoCollection = new TempoCollection();
        } else {
            return tempoCollection;
        }
    }

    private TempoCollection() {
        this.tempos = new ArrayList<>();
    }

    public void inserir(Tempo tempo) {
        tempos.add(tempo);
    }
}
