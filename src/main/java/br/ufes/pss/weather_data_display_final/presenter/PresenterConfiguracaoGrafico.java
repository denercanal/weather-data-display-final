package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraHorizontal;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraVertical;
import br.ufes.pss.weather_data_display_final.presenter.grafico.GraficoPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoGrafico;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import org.jfree.data.category.DefaultCategoryDataset;

public class PresenterConfiguracaoGrafico {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewConfiguracaoGrafico viewConfiguracaoGrafico;
    private Grafico grafico;

    public PresenterConfiguracaoGrafico(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;

        this.viewConfiguracaoGrafico = new ViewConfiguracaoGrafico();

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
                    this.graficoHorizontal();
                } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA VERTICAL")) {
                    this.graficoVertical();
                }
                GraficoPresenter graficoPresenter = new GraficoPresenter(new Frame(), true, this.grafico);
                graficoPresenter.viewGraficoModalVisible();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }

    private Grafico graficoHorizontal() {

        var dataset = this.getDadosGrafico();

        return grafico = new GraficoBarraHorizontal(dataset);
    }

    private Grafico graficoVertical() {
        var dataset = this.getDadosGrafico();
        
        return grafico = new GraficoBarraVertical(dataset);
    }

    private DefaultCategoryDataset getDadosGrafico() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(250, "Temperatura Média", "");
        dataset.addValue(120, "Umidade Média", "");
        dataset.addValue(1000, "Pressão Média", "");

        return dataset;
    }
}
