package com.dener.weatherdatadisplay.model;

import com.dener.weatherdatadisplay.interfaces.IModelObserver;
import com.dener.weatherdatadisplay.presenter.Atualizar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AtualizarMediaObserver implements IModelObserver {

    private ArrayList<Tempo> tempoObservers;
    private int count;
    private float mediaTemperatura;
    private float mediaUmidade;
    private float mediaPressao;
    private LocalDate date = LocalDate.now();
    private String dataAtual = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public AtualizarMediaObserver() {
        tempoObservers = new ArrayList<Tempo>();
    }

    @Override
    public void update(ArrayList<Tempo> tempos) {
        if (tempos.size() > 0) {
            mediaTemperatura = 0;
            mediaUmidade = 0;
            mediaPressao = 0;
            count = 0;
            for (int i = 0; i < tempos.size(); i++) {
                mediaTemperatura = ((tempos.get(i).getTemperatura() + mediaTemperatura ));
                mediaUmidade = (tempos.get(i).getUmidade() + mediaUmidade );
                mediaPressao = (tempos.get(i).getPressao() + mediaPressao );
                count++;
            }
            mediaTemperatura = mediaTemperatura / count;
            mediaUmidade = mediaUmidade / count;
            mediaPressao = mediaPressao / count;
            
            Atualizar.atualizarMedia(mediaTemperatura, mediaUmidade, mediaPressao, count);
        } else {
            Atualizar.atualizarMedia(0, 0, 0, 0);
        }

    }
}
