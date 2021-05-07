package br.ufes.pss.weather_data_display_final.decorator;

import org.jfree.chart.JFreeChart;

public class TituloEixoX extends GraficoDecorator {

    private String descricao;

    public TituloEixoX(Grafico elementoDecorado, String descricao) {
        super(elementoDecorado);
        this.descricao = descricao;
    }

    @Override
    public JFreeChart plotar() {
        JFreeChart grafico = this.elementoDecorado.plotar();
        grafico.getCategoryPlot().getDomainAxis().setLabel(descricao);

        return grafico;
    }

}
