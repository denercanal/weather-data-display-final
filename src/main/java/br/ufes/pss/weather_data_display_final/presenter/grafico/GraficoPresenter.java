package br.ufes.pss.weather_data_display_final.presenter.grafico;

import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.view.grafico.ViewGraficoModal;
import java.awt.BorderLayout;
import java.awt.Frame;
import org.jfree.chart.ChartPanel;

public class GraficoPresenter {

    private ViewGraficoModal viewGraficoModal;
    private Grafico grafico;

    public GraficoPresenter(Frame parent, boolean modal, Grafico grafico) {
        this.viewGraficoModal = new ViewGraficoModal(parent, true);
        this.grafico = grafico;
        this.plotarGrafico();
    }

    public void viewGraficoModalVisible() {
        this.viewGraficoModal.setVisible(true);
    }

    public ViewGraficoModal getViewGraficoModal() {
        return viewGraficoModal;
    }

    private void plotarGrafico() {
        ChartPanel painelGrafico = new ChartPanel(grafico.plotar());
        this.viewGraficoModal.getPainelGrafico().setLayout(new BorderLayout());
        this.viewGraficoModal.getPainelGrafico().removeAll();
        this.viewGraficoModal.getPainelGrafico().add(painelGrafico);
    }
}
