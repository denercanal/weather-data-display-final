package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.TempoBusiness;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class TelaPrincipalPresenter {

    private final ViewTelaPrincipal viewTelaPrincipal;
    private TempoBusiness tempoBusiness;

    public TelaPrincipalPresenter() {
        this.tempoBusiness = new TempoBusiness();
        this.viewTelaPrincipal = new ViewTelaPrincipal();
        this.viewTelaPrincipalInserir();

    }

    public void viewTelaPrincipal() {
        this.viewTelaPrincipal.setVisible(true);
    }

    public ViewTelaPrincipal getViewTelaPrincipal() {
        return this.viewTelaPrincipal;
    }

    private void viewTelaPrincipalInserir() {
        this.viewTelaPrincipal.getBtnInserir().addActionListener((ActionEvent e) -> {
            try {
                this.tempoBusiness.inserir(viewTelaPrincipal);
                this.limparCamposInsert();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }

    private void limparCamposInsert() {
        this.viewTelaPrincipal.getDataTempo().setText("");
        this.viewTelaPrincipal.getTemperaturaTempo().setText("");
        this.viewTelaPrincipal.getUmidadeTempo().setText("");
        this.viewTelaPrincipal.getPressaoTempo().setText("");
    }
}
