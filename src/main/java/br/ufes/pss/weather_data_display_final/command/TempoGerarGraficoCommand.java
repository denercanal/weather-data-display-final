package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraHorizontal;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraVertical;
import br.ufes.pss.weather_data_display_final.presenter.grafico.GraficoPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import java.awt.Frame;
import org.jfree.data.category.DefaultCategoryDataset;

public class TempoGerarGraficoCommand extends TempoCommand {

    @Override
    public void executarGerarGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, String options) throws Exception {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        var temperaturaMedia = Double.parseDouble(viewDadosMedios.getTemperaturaMedia().getText().replace(",", "."));
        var umidadeMedia = Double.parseDouble(viewDadosMedios.getUmidadeMedia().getText().replace(",", "."));
        var pressoMedia = Double.parseDouble(viewDadosMedios.getPressaoMedia().getText().replace(",", "."));

        dataset.addValue(temperaturaMedia, "Temperatura Média", "");
        dataset.addValue(umidadeMedia, "Umidade Média", "");
        dataset.addValue(pressoMedia, "Pressão Média", "");

        if (options.equalsIgnoreCase("horizontal")) {
            grafico = new GraficoBarraHorizontal(dataset);
        } else if (options.equalsIgnoreCase("vertical")) {
            grafico = new GraficoBarraVertical(dataset);
        }

        GraficoPresenter graficoPresenter = new GraficoPresenter(new Frame(), true, grafico);
        graficoPresenter.viewGraficoModalVisible();
    }
}
