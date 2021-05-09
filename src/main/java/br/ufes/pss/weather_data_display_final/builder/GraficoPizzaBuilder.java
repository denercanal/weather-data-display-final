package br.ufes.pss.weather_data_display_final.builder;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.decorator.GraficoPizza;
import br.ufes.pss.weather_data_display_final.decorator.TituloEixoX;
import br.ufes.pss.weather_data_display_final.decorator.TituloEixoY;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.presenter.grafico.GraficoPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import java.awt.Frame;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoPizzaBuilder extends GraficoGenericoBuilder {    
    
     @Override
    public void createGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions) {
        
        var datasetPie = this.getDatasetPie(viewDadosMedios);
        var graficoMontado = this.graficoOptions(grafico, graficoOptions, datasetPie, null);
        GraficoPresenter graficoPresenter = new GraficoPresenter(new Frame(), true, graficoMontado);
        graficoPresenter.viewGraficoModalVisible();
    }


    
    private DefaultPieDataset getDatasetPie(ViewDadosMedios viewDadosMedios) {
        DefaultPieDataset dataset = new DefaultPieDataset();

        var temperaturaMedia = Double.parseDouble(viewDadosMedios.getTemperaturaMedia().getText().replace(",", "."));
        var umidadeMedia = Double.parseDouble(viewDadosMedios.getUmidadeMedia().getText().replace(",", "."));
        var pressoMedia = Double.parseDouble(viewDadosMedios.getPressaoMedia().getText().replace(",", "."));

        dataset.setValue("Temperatura Média", temperaturaMedia);
        dataset.setValue("Umidade Média", umidadeMedia);
        dataset.setValue("Pressão Média", pressoMedia);

        return dataset;
    }
    
    private Grafico graficoOptions(Grafico grafico, GraficoOptions graficoOptions, DefaultPieDataset datasetPie, DefaultCategoryDataset datasetNormal) {

        if (graficoOptions.getSelected()) {
            if (graficoOptions.getTipo().equalsIgnoreCase("pizza")) {
                grafico = new GraficoPizza(datasetPie);
                grafico = new TituloEixoX(grafico, graficoOptions.getTituloEixoX());
                grafico = new TituloEixoY(grafico, graficoOptions.getTituloEixoY());
            }
        } else {
            if (graficoOptions.getTipo().equalsIgnoreCase("pizza")) {
                grafico = new GraficoPizza(datasetPie);
            } else {
                grafico = new TituloEixoX(grafico, "");
                grafico = new TituloEixoY(grafico, "");
            }
        }
        return grafico;
    }
}
