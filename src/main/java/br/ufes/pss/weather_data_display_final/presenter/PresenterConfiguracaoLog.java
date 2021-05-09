package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterConfiguracaoLog {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewConfiguracaoLog viewConfiguracaoLog;

    public PresenterConfiguracaoLog(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;

        this.viewConfiguracaoLog = new ViewConfiguracaoLog();

        this.viewTelaPrincipal.getDesktop().add(viewConfiguracaoLog);
        this.viewConfiguracaoLogGerar();
    }

    public void viewConfiguracaoLogVisible() {
        this.viewConfiguracaoLog.setVisible(true);
    }

    private void viewConfiguracaoLogGerar() {
        this.viewConfiguracaoLog.getBtnGerarLog().addActionListener((ActionEvent e) -> {
            try {

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

}
