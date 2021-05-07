package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class PresenterTelaPrincipal implements ITempoObservador {

    private final ViewTelaPrincipal viewTelaPrincipal;

    public PresenterTelaPrincipal() {
        this.viewTelaPrincipal = new ViewTelaPrincipal();

        this.viewConfiguracaoGrafico();
        this.viewConfiguracaoLog();
        this.viewDadosMedios();
        this.viewDadosTempo();
        this.viewTabelaTempo();
        this.viewUltimaAtualizacao();
        this.viewTelaPrincipalVisible();
        TempoCollection.getTempoCollection().add(this);
    }

    @Override
    public void update(TempoCollection tempoCollection) {
        var totalRegistros = tempoCollection.getTotalRegistros();
        if (totalRegistros == 0) {
            this.viewTelaPrincipal.getTotalRegistros().setText("0");
        }
        this.viewTelaPrincipal.getTotalRegistros().setText(String.valueOf(totalRegistros));
    }

    private void viewTelaPrincipalVisible() {
        this.viewTelaPrincipal.setVisible(true);
    }

    private void viewConfiguracaoGrafico() {
        PresenterConfiguracaoGrafico presenterConfiguracaoGrafico = new PresenterConfiguracaoGrafico(this.viewTelaPrincipal);
        presenterConfiguracaoGrafico.viewConfiguracaoGraficoVisible();
    }

    private void viewConfiguracaoLog() {
        PresenterConfiguracaoLog presenterConfiguracaoLog = new PresenterConfiguracaoLog(this.viewTelaPrincipal);
        presenterConfiguracaoLog.viewConfiguracaoLogVisible();
    }

    private void viewDadosMedios() {
        PresenterDadosMedios presenterDadosMedios = new PresenterDadosMedios(this.viewTelaPrincipal);
        presenterDadosMedios.viewDadosMediosVisible();
        TempoCollection.getTempoCollection().add(presenterDadosMedios);
    }

    private void viewDadosTempo() {
        PresenterDadosTempo presenterDadosTempo = new PresenterDadosTempo(this.viewTelaPrincipal);
        presenterDadosTempo.viewDadosTempoVisible();
        TempoCollection.getTempoCollection().add(presenterDadosTempo);
    }

    private void viewTabelaTempo() {
        PresenterTabelaTempo presenterTabelaTempo = new PresenterTabelaTempo(this.viewTelaPrincipal);
        presenterTabelaTempo.viewTabelaTempoVisible();
        TempoCollection.getTempoCollection().add(presenterTabelaTempo);
    }

    private void viewUltimaAtualizacao() {
        PresenterUltimaAtualizacao presenterUltimaAtualizacao = new PresenterUltimaAtualizacao(this.viewTelaPrincipal);
        presenterUltimaAtualizacao.viewUltimaAtualizacaoVisible();
        TempoCollection.getTempoCollection().add(presenterUltimaAtualizacao);
    }
}
