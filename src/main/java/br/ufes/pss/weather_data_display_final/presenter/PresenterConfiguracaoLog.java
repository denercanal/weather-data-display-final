package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoLog;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterConfiguracaoLog {

    private ViewTelaPrincipal viewTelaPrincipal;
    private static ViewConfiguracaoLog viewConfiguracaoLog;

    public PresenterConfiguracaoLog(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;

        this.viewConfiguracaoLog = new ViewConfiguracaoLog();

        this.viewTelaPrincipal.getDesktop().add(viewConfiguracaoLog);
        this.viewConfiguracaoLogTipo();
    }

    public void viewConfiguracaoLogVisible() {
        this.viewConfiguracaoLog.setVisible(true);
    }

    public static ViewConfiguracaoLog getViewConfiguracaoLog() {
        return viewConfiguracaoLog;
    }

    private void viewConfiguracaoLogTipo() {
        this.viewConfiguracaoLog.getLogOptions().addActionListener((ActionEvent e) -> {
            if (this.viewConfiguracaoLog.getLogOptions().getSelectedItem().equals("JSON")) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, "Usando sistema de Log em formato Json!");
            } else {
                JOptionPane.showMessageDialog(viewTelaPrincipal, "Usando sistema de Log em formato Xml!");
            }
        });
    }

}
