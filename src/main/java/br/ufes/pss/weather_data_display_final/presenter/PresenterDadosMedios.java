package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.calculator.CalculadorMediaDia;
import br.ufes.pss.weather_data_display_final.calculator.CalculadorMediaMes;
import br.ufes.pss.weather_data_display_final.calculator.CalculadorMediaSemana;
import br.ufes.pss.weather_data_display_final.calculator.CalculadorMediaTempo;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;

public class PresenterDadosMedios implements ITempoObservador {

    private ViewTelaPrincipal viewTelaPrincipal;
    private static ViewDadosMedios viewDadosMedios;
    private CalculadorMediaTempo calculador;

    public PresenterDadosMedios(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewDadosMedios = getViewDadosMedios();
        this.calculador = new CalculadorMediaDia();
        this.viewTelaPrincipal.getDesktop().add(this.viewDadosMedios);
        this.viewDadosMediosCalcular();
    }

    public void viewDadosMediosVisible() {
        this.viewDadosMedios.setVisible(true);
    }

    public static ViewDadosMedios getViewDadosMedios() {
        if (viewDadosMedios == null) {
            return viewDadosMedios = new ViewDadosMedios();
        } else {
            return viewDadosMedios;
        }
    }

    private void viewDadosMediosCalcular() {
        this.viewDadosMedios.getCbbPeriodo().addActionListener((ActionEvent arg0) -> {
            viewDadosMediosOptions();
        });
    }

    private void viewDadosMediosOptions() {
        String opcao = viewDadosMedios.getCbbPeriodo().getSelectedItem().toString();

        if (opcao.equalsIgnoreCase("diária")) {
            calculador = new CalculadorMediaDia();
            calcularMedia();
        }
        if (opcao.equalsIgnoreCase("semanal")) {
            calculador = new CalculadorMediaSemana();
            calcularMedia();
        }
        if (opcao.equalsIgnoreCase("mensal")) {
            calculador = new CalculadorMediaMes();
            calcularMedia();
        }
    }

    private void atualizarCampos(TempoMedia tempoMedia) {

        viewDadosMedios.getTemperaturaMedia().setText(String.format("%.2f", tempoMedia.getTemperaturaTempo()));
        viewDadosMedios.getUmidadeMedia().setText(String.format("%.2f", tempoMedia.getUmidadeTempo()));
        viewDadosMedios.getPressaoMedia().setText(String.format("%.2f", tempoMedia.getPressaoTempo()));
        viewDadosMedios.getTotalRegistrosMedia().setText(String.valueOf(tempoMedia.getQuantidadeTempo()));
    }

    private void limparCampos() {

        viewDadosMedios.getTemperaturaMedia().setText("Not Found.");
        viewDadosMedios.getUmidadeMedia().setText("Not Found.");
        viewDadosMedios.getPressaoMedia().setText("Not Found.");
        viewDadosMedios.getTotalRegistrosMedia().setText("Not Found.");
    }

    private void calcularMedia() {
        try {
            TempoMedia tempo = calculador.calcular(TempoCollection.getTempoCollection());
            atualizarCampos(tempo);
        } catch (RuntimeException re) {
            limparCampos();
        }
    }

    @Override
    public void update(TempoCollection registrosTempo) {
        calcularMedia();
    }
}
