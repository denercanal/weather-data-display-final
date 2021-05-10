package br.ufes.pss.weather_data_display_final.builder;

import br.ufes.pss.weather_data_display_final.adapter.AdapterJson;
import br.ufes.pss.weather_data_display_final.adapter.AdapterXml;
import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.decorator.GraficoAreaEmpilhada;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraHorizontal;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraVertical;
import br.ufes.pss.weather_data_display_final.decorator.TituloEixoX;
import br.ufes.pss.weather_data_display_final.decorator.TituloEixoY;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.presenter.PresenterConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.presenter.grafico.GraficoPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import java.awt.Frame;
import java.io.IOException;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoGenericoBuilder extends GraficoBuilder {

    @Override
    public void createGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions) {
        var datasetNormal = this.getDataset(viewDadosMedios);
        var graficoMontado = this.graficoOptions(grafico, graficoOptions, null, datasetNormal);
        try {
            gerarLog(graficoOptions);
        } catch (IOException ex) {
        }
        GraficoPresenter graficoPresenter = new GraficoPresenter(new Frame(), true, graficoMontado);
        graficoPresenter.viewGraficoModalVisible();
    }

    private DefaultCategoryDataset getDataset(ViewDadosMedios viewDadosMedios) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        var temperaturaMedia = Double.parseDouble(viewDadosMedios.getTemperaturaMedia().getText().replace(",", "."));
        var umidadeMedia = Double.parseDouble(viewDadosMedios.getUmidadeMedia().getText().replace(",", "."));
        var pressoMedia = Double.parseDouble(viewDadosMedios.getPressaoMedia().getText().replace(",", "."));

        dataset.addValue(temperaturaMedia, "Temperatura Média", "");
        dataset.addValue(umidadeMedia, "Umidade Média", "");
        dataset.addValue(pressoMedia, "Pressão Média", "");

        return dataset;
    }

    private Grafico graficoOptions(Grafico grafico, GraficoOptions graficoOptions, DefaultPieDataset datasetPie, DefaultCategoryDataset datasetNormal) {

        if (graficoOptions.getSelected()) {
            if (graficoOptions.getTipo().equalsIgnoreCase("horizontal")) {
                grafico = new GraficoBarraHorizontal(datasetNormal);
                grafico = new TituloEixoX(grafico, graficoOptions.getTituloEixoY());
                grafico = new TituloEixoY(grafico, graficoOptions.getTituloEixoX());
            } else if (graficoOptions.getTipo().equalsIgnoreCase("vertical")) {
                grafico = new GraficoBarraVertical(datasetNormal);
                grafico = new TituloEixoX(grafico, graficoOptions.getTituloEixoX());
                grafico = new TituloEixoY(grafico, graficoOptions.getTituloEixoY());
            } else if (graficoOptions.getTipo().equalsIgnoreCase("area empilhada")) {
                grafico = new GraficoAreaEmpilhada(datasetNormal);
                grafico = new TituloEixoX(grafico, graficoOptions.getTituloEixoX());
                grafico = new TituloEixoY(grafico, graficoOptions.getTituloEixoY());
            }
        } else {
            if (graficoOptions.getTipo().equalsIgnoreCase("horizontal")) {
                grafico = new GraficoBarraHorizontal(datasetNormal);
            } else if (graficoOptions.getTipo().equalsIgnoreCase("vertical")) {
                grafico = new GraficoBarraVertical(datasetNormal);
            } else if (graficoOptions.getTipo().equalsIgnoreCase("area empilhada")) {
                grafico = new GraficoAreaEmpilhada(datasetNormal);
            } else {
                grafico = new TituloEixoX(grafico, "");
                grafico = new TituloEixoY(grafico, "");
            }
        }
        return grafico;
    }

    private void gerarLog(GraficoOptions graficoOptions) throws IOException {
        var viewLog = PresenterConfiguracaoLog.getViewConfiguracaoLog();
        graficoOptions.setTipoLog("gerarGrafico");
        if (viewLog.getLogOptions().getSelectedItem().equals("JSON")) {
            new AdapterJson().adaptar(graficoOptions);
        } else {
            new AdapterXml().adaptar(graficoOptions);
        }
    }
}
