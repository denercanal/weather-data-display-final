package br.ufes.pss.weather_data_display_final.command;

import br.ufes.pss.weather_data_display_final.builder.GraficoGenericoBuilder;
import br.ufes.pss.weather_data_display_final.builder.GraficoPizzaBuilder;
import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;

public class TempoGerarGraficoCommand extends TempoCommand {

    @Override
    public void executarGerarGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions) throws Exception {

        if (graficoOptions.getTipo().equalsIgnoreCase("pizza")) {
            GraficoGenericoBuilder graficoPizza = new GraficoPizzaBuilder();
            graficoPizza.createGrafico(viewDadosMedios, grafico, graficoOptions);
        } else {
            GraficoGenericoBuilder graficoGenerico = new GraficoGenericoBuilder();
            graficoGenerico.createGrafico(viewDadosMedios, grafico, graficoOptions);
        }
    }
}
