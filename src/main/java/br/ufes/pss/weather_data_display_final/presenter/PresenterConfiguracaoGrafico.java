package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraHorizontal;
import br.ufes.pss.weather_data_display_final.decorator.GraficoBarraVertical;
import br.ufes.pss.weather_data_display_final.presenter.grafico.GraficoPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewConfiguracaoGrafico;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
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
                this.tipoGrafico();
                GraficoPresenter graficoPresenter = new GraficoPresenter(new Frame(), true, this.grafico);
                graficoPresenter.viewGraficoModalVisible();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }

    private void tipoGrafico() throws Exception {
        if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA HORIZONTAL")) {
            this.graficoHorizontal();
        } else if (this.viewConfiguracaoGrafico.getjComboBox3().getSelectedItem().toString().equalsIgnoreCase("BARRA VERTICAL")) {
            this.graficoVertical();
        }
    }

    private Grafico graficoHorizontal() throws Exception {
        var dataset = this.getDadosGrafico();
        return grafico = new GraficoBarraHorizontal(dataset);
    }

    private Grafico graficoVertical() throws Exception {
        var dataset = this.getDadosGrafico();
        return grafico = new GraficoBarraVertical(dataset);
    }

    private DefaultCategoryDataset getDadosGrafico() throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        var viewDadosMedios = PresenterDadosMedios.getViewDadosMedios();
        validaViewDadosMedios(viewDadosMedios);

        var temperaturaMedia = Double.parseDouble(viewDadosMedios.getTemperaturaMedia().getText().replace(",", "."));
        var umidadeMedia = Double.parseDouble(viewDadosMedios.getUmidadeMedia().getText().replace(",", "."));
        var pressoMedia = Double.parseDouble(viewDadosMedios.getPressaoMedia().getText().replace(",", "."));

        dataset.addValue(temperaturaMedia, "Temperatura Média", "");
        dataset.addValue(umidadeMedia, "Umidade Média", "");
        dataset.addValue(pressoMedia, "Pressão Média", "");

        return dataset;
    }

    private void validaViewDadosMedios(ViewDadosMedios viewDadosMedios) throws Exception {

        try {
            if (viewDadosMedios.getTemperaturaMedia().getText().isBlank() || viewDadosMedios.getUmidadeMedia().getText().isBlank() || viewDadosMedios.getPressaoMedia().getText().isBlank()) {
                throw new Exception("Impossível gerar gráfico, sem dados inseridos para o período!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
