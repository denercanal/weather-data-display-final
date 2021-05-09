package br.ufes.pss.weather_data_display_final.builder;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;

public abstract class GraficoBuilder {
    
    public abstract void createGrafico(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions);
   
}
