package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.observer.ITempoObserver;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class PresenterTelaPrincipal implements ITempoObserver {

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

    private void viewTelaPrincipalVisible() {
        this.viewTelaPrincipal.setVisible(true);
    }

    public ViewTelaPrincipal getViewTelaPrincipal() {
        return this.viewTelaPrincipal;
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
    }

    private void viewDadosTempo() {
        PresenterDadosTempo presenterDadosTempo = new PresenterDadosTempo(this.viewTelaPrincipal);
        presenterDadosTempo.viewDadosTempoVisible();
    }

    private void viewTabelaTempo() {
        PresenterTabelaTempo presenterTabelaTempo = new PresenterTabelaTempo(this.viewTelaPrincipal);
        presenterTabelaTempo.viewTabelaTempoVisible();
    }

    private void viewUltimaAtualizacao() {
        PresenterUltimaAtualizacao presenterUltimaAtualizacao = new PresenterUltimaAtualizacao(this.viewTelaPrincipal);
        presenterUltimaAtualizacao.viewUltimaAtualizacaoVisible();
    }

    @Override
    public void update(TempoCollection tempoCollection) {
        var totalRegistros = tempoCollection.getTotalRegistros();
        this.viewTelaPrincipal.getTotalRegistros().setText(String.valueOf(totalRegistros));
    }
}
