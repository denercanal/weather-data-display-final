package br.ufes.pss.weather_data_display_final.adapter;

import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import java.io.IOException;

public abstract class Adapter {

    public abstract void adaptar(Tempo tempo) throws IOException;
    
    public abstract void adaptar(TempoMedia tempoMedia) throws IOException;

    public abstract void adaptar(GraficoOptions graficoOptions) throws IOException;
}
