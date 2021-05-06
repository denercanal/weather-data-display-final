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
                if (this.viewTabelaTempo.getTabela().getSelectedRowCount() == 0 || this.viewTabelaTempo.getTabela().getRowCount() <= 0) {
                    throw new Exception("Selecionar uma linha se for remover um registro!");
                } else {
                    var linhaSelecionada = viewTabelaTempo.getTabela().getSelectedRow();
                    var idDadoTempo = viewTabelaTempo.getTabela().getValueAt(linhaSelecionada, 0);
                    var tempo = TempoCollection.getTempoCollection().getTempoById((int) idDadoTempo);
                    this.businessTempo.remover(tempo);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(viewTelaPrincipal, ex.getMessage(), "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        );
    }

    @Override
    public void update(TempoCollection tempoCollection) {

        var tempos = TempoCollection.getTempoCollection().getAllTempos();

        ((DefaultTableModel) this.viewTabelaTempo.getTabela().getModel()).setNumRows(0);
        viewTabelaTempo.getTabela().updateUI();

        DefaultTableModel model = (DefaultTableModel) viewTabelaTempo.getTabela().getModel();

        if (!tempos.isEmpty()) {
            for (Tempo tempo : tempos) {
                var linha = new Object[]{tempo.getId(), tempo.getDataTempo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), tempo.getTemperaturaTempo().toString().replace(".", ","), tempo.getUmidadeTempo().toString().replace(".", ","), tempo.getPressaoTempo().toString().replace(".", ",")};
                model.addRow(linha);
            }
        }
    }
}
