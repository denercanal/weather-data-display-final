package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoGrafico;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterConfiguracaoGrafico {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewConfiguracaoGrafico viewConfiguracaoGrafico;
    private Grafico grafico;
    private BusinessTempo businessTempo;
    private GraficoOptions graficoOptions;

    public PresenterConfiguracaoGrafico(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;

        this.viewConfiguracaoGrafico = new ViewConfiguracaoGrafico();
        this.businessTempo = new BusinessTempo();
        this.graficoOptions = new GraficoOptions();

        this.viewTelaPrincipal.getDesktop().add(viewConfiguracaoGrafico);

        this.viewConfiguracaoGraficoGerar();
    }

    public void viewConfiguracaoGraficoVisible() {
        this.viewConfiguracaoGrafico.setVisible(true);
    }

    private void viewConfiguracaoGraficoGerar() {
        this.viewConfiguracaoGrafico.getBtnGerarGrafico().addActionListener((ActionEvent e) -> {
            try {
                var viewDadosMedios = PresenterDadosMedios.getViewDadosMedios();

                var options = this.graficoOptions();

                if (viewConfiguracaoGrafico.getTitulo().isSelected()) {
                    if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA HORIZONTAL")) {
                        this.businessTempo.graficoHorizontal(viewDadosMedios, grafico, options);
                    } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA VERTICAL")) {
                        this.businessTempo.graficoVertical(viewDadosMedios, grafico, options);
                    } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("AREA EMPILHADA")) {
                        this.businessTempo.graficoAreaEmpilhada(viewDadosMedios, grafico, options);
                    } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("PIZZA")) {
                        throw new Exception("Impossível gerar gráfico de pizza com títulos");
                    }
                } else {
                    if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA HORIZONTAL")) {
                        this.businessTempo.graficoHorizontal(viewDadosMedios, grafico, options);
                    } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA VERTICAL")) {
                        this.businessTempo.graficoVertical(viewDadosMedios, grafico, options);
                    } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("AREA EMPILHADA")) {
                        this.businessTempo.graficoAreaEmpilhada(viewDadosMedios, grafico, options);
                    } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("PIZZA")) {
                        this.businessTempo.graficoPizza(viewDadosMedios, grafico, options);
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        );
    }

    private GraficoOptions graficoOptions() {

        boolean selected = this.viewConfiguracaoGrafico.getTitulo().isSelected();
        String tituloEixoX = "Titulo do eixo X";
        String tituloEixoY = "Titulo do eixo Y";

        graficoOptions.setSelected(selected);
        graficoOptions.setTituloEixoX(tituloEixoX);
        graficoOptions.setTituloEixoY(tituloEixoY);
        return graficoOptions;
    }
}
