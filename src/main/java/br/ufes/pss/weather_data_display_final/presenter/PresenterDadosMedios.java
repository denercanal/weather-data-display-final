package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class PresenterDadosMedios {

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

}
