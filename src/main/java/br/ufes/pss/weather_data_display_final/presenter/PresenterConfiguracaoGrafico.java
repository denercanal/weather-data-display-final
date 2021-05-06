package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoGrafico;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class PresenterConfiguracaoGrafico {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewConfiguracaoGrafico viewConfiguracaoGrafico;

    public PresenterConfiguracaoGrafico(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;

        this.viewConfiguracaoGrafico = new ViewConfiguracaoGrafico();

        this.viewTelaPrincipal.getDesktop().add(viewConfiguracaoGrafico);
    }

    public void viewConfiguracaoGraficoVisible() {
        this.viewConfiguracaoGrafico.setVisible(true);
    }
}
