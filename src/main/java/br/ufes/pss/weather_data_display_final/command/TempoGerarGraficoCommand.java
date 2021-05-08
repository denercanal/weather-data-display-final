package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraHorizontal;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraVertical;
import br.ufes.pss.weather_data_display_final.decorator.TituloEixoX;
import br.ufes.pss.weather_data_display_final.decorator.TituloEixoY;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.presenter.grafico.GraficoPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import java.awt.Frame;
import org.jfree.data.category.DefaultCategoryDataset;

public class TempoGerarGraficoCommand extends TempoCommand {

    @Override
    public void executarGerarGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions) throws Exception {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        var temperaturaMedia = Double.parseDouble(viewDadosMedios.getTemperaturaMedia().getText().replace(",", "."));
        var umidadeMedia = Double.parseDouble(viewDadosMedios.getUmidadeMedia().getText().replace(",", "."));
        var pressoMedia = Double.parseDouble(viewDadosMedios.getPressaoMedia().getText().replace(",", "."));

        dataset.addValue(temperaturaMedia, "Temperatura Média", "");
        dataset.addValue(umidadeMedia, "Umidade Média", "");
        dataset.addValue(pressoMedia, "Pressão Média", "");

        if (graficoOptions.getTipo().equalsIgnoreCase("horizontal")) {
            grafico = new GraficoBarraHorizontal(dataset);
        } else if (graficoOptions.getTipo().equalsIgnoreCase("vertical")) {
            grafico = new GraficoBarraVertical(dataset);
        }

        if (graficoOptions.getSelected()) {
            grafico = new TituloEixoX(grafico, graficoOptions.getTituloEixoX());
            grafico = new TituloEixoY(grafico, graficoOptions.getTituloEixoY());
        } else {
            grafico = new TituloEixoX(grafico, "");
            grafico = new TituloEixoY(grafico, "");
        }

        GraficoPresenter graficoPresenter = new GraficoPresenter(new Frame(), true, grafico);
        graficoPresenter.viewGraficoModalVisible();
    }
}
