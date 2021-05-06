package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;
import br.ufes.pss.weather_data_display_final.view.ViewTabelaTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PresenterTabelaTempo implements ITempoObservador {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewTabelaTempo viewTabelaTempo;
    private BusinessTempo businessTempo;

    PresenterTabelaTempo(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewTabelaTempo = new ViewTabelaTempo();

        this.viewTelaPrincipal.getDesktop().add(viewTabelaTempo);

        this.businessTempo = new BusinessTempo();

        this.viewTabelaTempoRemover();
    }

    public void viewTabelaTempoVisible() {
        this.viewTabelaTempo.setVisible(true);
    }

    private void viewTabelaTempoRemover() {
        this.viewTabelaTempo.getBtnRemover().addActionListener((ActionEvent e) -> {
            try {
                this.businessTempo.remover(viewTabelaTempo);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Dados Inválidos!", JOptionPane.OK_OPTION);
            }
        }
        );
    }

    @Override
    public void update(TempoCollection tempoCollection) {

        try {
            var tempos = TempoCollection.getTempoCollection().getAllTempos();

            ((DefaultTableModel) this.viewTabelaTempo.getTabela().getModel()).setNumRows(0);
            viewTabelaTempo.getTabela().updateUI();

            DefaultTableModel model = (DefaultTableModel) viewTabelaTempo.getTabela().getModel();

            if (!tempos.isEmpty()) {
                for (Tempo tempo : tempos) {
                    model.addRow(new Object[]{tempo.getDataTempo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), tempo.getTemperaturaTempo(), tempo.getUmidadeTempo(), tempo.getPressaoTempo()});
                }
            }
        } catch (Exception e) {
        }
    }
}
