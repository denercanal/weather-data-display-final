package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoGrafico;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterConfiguracaoGrafico {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewConfiguracaoGrafico viewConfiguracaoGrafico;
    private Grafico grafico;
    private BusinessTempo businessTempo;

    public PresenterConfiguracaoGrafico(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;

        this.viewConfiguracaoGrafico = new ViewConfiguracaoGrafico();
        this.businessTempo = new BusinessTempo();

        this.viewTelaPrincipal.getDesktop().add(viewConfiguracaoGrafico);

        this.viewConfiguracaoGraficoGerar();
    }

    public void viewConfiguracaoGraficoVisible() {
        this.viewConfiguracaoGrafico.setVisible(true);
    }

    private void viewConfiguracaoGraficoGerar() {
        this.viewConfiguracaoGrafico.getBtnGerarGrafico().addActionListener((ActionEvent e) -> {
            try {
                if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA HORIZONTAL")) {
                    this.businessTempo.graficoHorizontal(grafico);
                } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA VERTICAL")) {
                    this.businessTempo.graficoVertical(grafico);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }
}