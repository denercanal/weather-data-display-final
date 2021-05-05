package com.dener.weatherdatadisplay.model;

import com.dener.weatherdatadisplay.interfaces.IModelObserver;
import com.dener.weatherdatadisplay.interfaces.IRecebeTempos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TempoCollection implements IRecebeTempos {

    private ArrayList<IModelObserver> observers;
    private ArrayList<Tempo> tempoObservers;

    private static TempoCollection instances;

    UltimaAtualizacaoObserver ob1 = new UltimaAtualizacaoObserver();
    AtualizarMediaObserver ob2 = new AtualizarMediaObserver();
    AtualizarTabelaObserver ob3 = new AtualizarTabelaObserver();

    private TempoCollection() {
        observers = new ArrayList<IModelObserver>();
        tempoObservers = new ArrayList<Tempo>();
        registrar(ob1);
        registrar(ob2);
        registrar(ob3);
    }

    @Override
    public void notificar() {
        for (int i = 0; i < observers.size(); i++) {
            IModelObserver ob = observers.get(i);
            ob.update(tempoObservers);
        }
        JOptionPane.showConfirmDialog(null, "notificou!");
    }

    @Override
    public void registrar(IModelObserver ob) {
        observers.add(ob);
    }

    public void inserir(Tempo tempo) {
        tempoObservers.add(tempo);
        notificar();
    }

    public void remover(Tempo tempo) {
        for (int i = 0; i < tempoObservers.size(); i++) {
            if (tempoObservers.get(i).getData().equals(tempo.getData())) {
                tempoObservers.remove(i);
                notificar();
            }
        }

    }

    public static TempoCollection getIntances() {
        if (instances == null) {
            instances = new TempoCollection();
        }

        return instances;
    }
}
