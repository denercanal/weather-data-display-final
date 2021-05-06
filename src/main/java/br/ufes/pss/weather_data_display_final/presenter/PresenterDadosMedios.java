package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;

public class PresenterDadosMedios implements ITempoObservador{

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewDadosMedios viewDadosMedios;
    
    public PresenterDadosMedios(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewDadosMedios = new ViewDadosMedios();
        
        this.viewTelaPrincipal.getDesktop().add(this.viewDadosMedios);
    }

    public void viewDadosMediosVisible() {
        this.viewDadosMedios.setVisible(true);
    }

    @Override
    public void update(TempoCollection tempoCollection) {
        
    }
}
