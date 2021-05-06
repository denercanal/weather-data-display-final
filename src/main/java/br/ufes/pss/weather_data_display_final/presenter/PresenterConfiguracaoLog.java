package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class PresenterConfiguracaoLog {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewConfiguracaoLog viewConfiguracaoLog;
    
    public PresenterConfiguracaoLog(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        
        this.viewConfiguracaoLog = new ViewConfiguracaoLog();
        
        this.viewTelaPrincipal.getDesktop().add(viewConfiguracaoLog);
    }

    public void viewConfiguracaoLogVisible() {
        this.viewConfiguracaoLog.setVisible(true);
    }

}
