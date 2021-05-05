package com.dener.weatherdatadisplay.presenter;

import com.dener.weatherdatadisplay.model.Tempo;
import com.dener.weatherdatadisplay.view.Display;

public class Inserir {

    public void inserir(Display display) {
        Tempo tempo = new Tempo();
        String tempos[] = new String[4];
        tempos[0] = display.getDadosTempoData().getText();
        tempos[1] = display.getDadosTempoTemperatura().getText();
        tempos[2] = display.getDadosTempoUmidade().getText();
        tempos[3] = display.getDadosTempoPressao().getText();
        tempo.setInformacoes(tempos);

        display.getDadosTempoData().setText("");
        display.getDadosTempoUmidade().setText("");
        display.getDadosTempoPressao().setText("");
        display.getDadosTempoTemperatura().setText("");
    }
}
