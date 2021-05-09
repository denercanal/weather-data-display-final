package br.ufes.pss.weather_data_display_final.decorator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoPizza extends GraficoPieConcreto {

    public GraficoPizza(DefaultPieDataset dataset) {
        super(dataset);
    }

    @Override
    public JFreeChart plotar() {
        JFreeChart grafico = ChartFactory.createPieChart("", dataset, true, false, false);
        return grafico;
    }

}
