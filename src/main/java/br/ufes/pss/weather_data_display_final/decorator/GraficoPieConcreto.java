package br.ufes.pss.weather_data_display_final.decorator;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public abstract class GraficoPieConcreto extends Grafico {

    protected DefaultPieDataset dataset;

    public GraficoPieConcreto(DefaultPieDataset dataset) {
        this.dataset = dataset;
    }

    @Override
    public abstract JFreeChart plotar();

}