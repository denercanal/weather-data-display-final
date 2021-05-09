package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class PresenterDadosTempo implements ITempoObservador {

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
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        );
    }

    @Override
    public void update(TempoCollection tempoCollection) {
        this.viewDadosTempo.getDataTempo().setText("");
        this.viewDadosTempo.getTemperaturaTempo().setText("");
        this.viewDadosTempo.getUmidadeTempo().setText("");
        this.viewDadosTempo.getPressaoTempo().setText("");
    }
}
