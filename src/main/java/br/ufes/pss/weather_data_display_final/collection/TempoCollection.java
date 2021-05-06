package br.ufes.pss.weather_data_display_final.collection;

import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.observer.TempoObservado;
import java.util.ArrayList;

public class TempoCollection extends TempoObservado {

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

        tempo.setId(tempos.size());
        this.tempos.add(tempo);
        notifica();
    }

    public void remover(Tempo tempo) {

        if (tempos.isEmpty()) {
            
        } else {
            this.tempos.remove(tempo);
            notifica();
        }
    }

    public int getTotalRegistros() {

        if (this.tempos != null) {
            return this.tempos.size();
        }
        return 0;
    }

    public Tempo getUltimoRegistro() {

        if (!this.tempos.isEmpty()) {
            return this.tempos.get(tempos.size() - 1);
        }
        return null;
    }

    public ArrayList<Tempo> getAllTempos() {

        if (!this.tempos.isEmpty()) {
            return this.tempos;
        }
        return null;
    }

    public Tempo getTempoById(int id) {

        for (Tempo tempo : tempos) {
            if (tempo.getId() == id) {
                return tempo;
            }
        }
        return null;
    }
}
