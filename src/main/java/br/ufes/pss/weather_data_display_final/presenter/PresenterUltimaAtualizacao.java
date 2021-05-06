package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.observer.ITempoObserver;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import br.ufes.pss.weather_data_display_final.view.ViewUltimaAtualizacao;
import java.time.format.DateTimeFormatter;

public class PresenterUltimaAtualizacao implements ITempoObserver {

    private final ViewTelaPrincipal viewTelaPrincipal;
    private final ViewUltimaAtualizacao viewUltimaAtualizacao;

    public PresenterUltimaAtualizacao(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewUltimaAtualizacao = new ViewUltimaAtualizacao();
    }

    public void viewUltimaAtualizacaoVisible() {
        this.viewTelaPrincipal.getDesktop().add(this.viewUltimaAtualizacao);
        this.viewUltimaAtualizacao.setVisible(true);
    }

    @Override
    public void update(TempoCollection tempoCollection) {

        var ultimoRegistro = tempoCollection.getUltimoRegistro();
        this.viewUltimaAtualizacao.getUltimaDataTempo().setText(String.valueOf(ultimoRegistro.getDataTempo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        this.viewUltimaAtualizacao.getUltimaTemperaturaTempo().setText(String.valueOf(ultimoRegistro.getTemperaturaTempo()).replace(".", ","));
        this.viewUltimaAtualizacao.getUltimaUmidadeTempo().setText(String.valueOf(ultimoRegistro.getUmidadeTempo()).replace(".", ","));
        this.viewUltimaAtualizacao.getUltimaPressaoTempo().setText(String.valueOf(ultimoRegistro.getPressaoTempo()).replace(".", ","));
    }
}
