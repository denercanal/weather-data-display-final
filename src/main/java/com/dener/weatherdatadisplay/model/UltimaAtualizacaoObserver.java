package com.dener.weatherdatadisplay.model;

import com.dener.weatherdatadisplay.interfaces.IModelObserver;
import com.dener.weatherdatadisplay.presenter.Atualizar;
import java.util.ArrayList;

public class UltimaAtualizacaoObserver implements IModelObserver {

    private String data;
    private float temperatura;
    private float umidade;
    private float pressao;

    @Override
    public void update(ArrayList<Tempo> tempo) {
        if (tempo.size() > 0) {
            data = tempo.get(tempo.size()-1).getData();
            temperatura = tempo.get(tempo.size()-1).getTemperatura();
            umidade = tempo.get(tempo.size()-1).getUmidade();
            pressao = tempo.get(tempo.size()-1).getPressao();

            Atualizar.atualizarUltima(data, temperatura, umidade, pressao);
        }

    }
}
