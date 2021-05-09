package br.ufes.pss.weather_data_display_final.decorator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


public class GraficoAreaEmpilhada extends GraficoConcreto {

    public GraficoAreaEmpilhada(DefaultCategoryDataset dataset) {
        super(dataset);
    }

    @Override
    public JFreeChart plotar() {
        JFreeChart grafico = ChartFactory.createStackedAreaChart("", "", "", dataset);
        return grafico;
    }

}