package br.ufes.pss.weather_data_display_final.decorator;

import org.jfree.chart.JFreeChart;

public abstract class GraficoDecorator extends Grafico {

    protected Grafico elementoDecorado;

    public GraficoDecorator(Grafico elementoDecorado) {
        this.elementoDecorado = elementoDecorado;
    }

    @Override
    public abstract JFreeChart plotar();

}
