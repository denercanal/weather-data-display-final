package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTabelaTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterTabelaTempo {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewTabelaTempo viewTabelaTempo;
    private BusinessTempo businessTempo;

    PresenterTabelaTempo(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewTabelaTempo = new ViewTabelaTempo();
        
        this.viewTelaPrincipal.getDesktop().add(viewTabelaTempo);

        this.businessTempo = new BusinessTempo();
    }

    public void viewTabelaTempoVisible() {
        this.viewTabelaTempo.setVisible(true);
    }

    private void viewDadosTempoInserir() {
        this.viewTabelaTempo.getBtnRemover().addActionListener((ActionEvent e) -> {
            try {
                this.businessTempo.remover(viewTabelaTempo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }
}
