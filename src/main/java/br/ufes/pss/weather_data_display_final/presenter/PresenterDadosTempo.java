package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterDadosTempo {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewDadosTempo viewDadosTempo;
    private BusinessTempo businessTempo;

    public PresenterDadosTempo(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewDadosTempo = new ViewDadosTempo();
        
        this.viewTelaPrincipal.getDesktop().add(this.viewDadosTempo);

        this.businessTempo = new BusinessTempo();

        this.viewDadosTempoInserir();
    }

    public void viewDadosTempoVisible() {
        this.viewDadosTempo.setVisible(true);
    }

    private void viewDadosTempoInserir() {
        this.viewDadosTempo.getBtnInserir().addActionListener((ActionEvent e) -> {
            try {
                this.businessTempo.inserir(viewDadosTempo);
                this.limparCamposInsert();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }

    private void limparCamposInsert() {
        this.viewDadosTempo.getDataTempo().setText("");
        this.viewDadosTempo.getTemperaturaTempo().setText("");
        this.viewDadosTempo.getUmidadeTempo().setText("");
        this.viewDadosTempo.getPressaoTempo().setText("");
    }
}
