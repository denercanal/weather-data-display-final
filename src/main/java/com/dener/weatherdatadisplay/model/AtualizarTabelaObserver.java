package com.dener.weatherdatadisplay.model;

import com.dener.weatherdatadisplay.interfaces.IModelObserver;
import com.dener.weatherdatadisplay.presenter.Atualizar;
import java.util.ArrayList;

public class AtualizarTabelaObserver implements IModelObserver {

    private static int antes;
    private int atual;

    public AtualizarTabelaObserver() {
        antes = 0;
    }

    @Override
    public void update(ArrayList<Tempo> tempos) {

        atual = tempos.size();
        if (antes < atual && tempos.size() > 0) {
            Atualizar.atualizarTabela(tempos.get(tempos.size() - 1));
        }

    }
}
