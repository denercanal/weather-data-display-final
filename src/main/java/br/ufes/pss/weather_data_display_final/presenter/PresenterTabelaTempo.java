package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.BusinessTempo;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;
import br.ufes.pss.weather_data_display_final.view.ViewTabelaTempo;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PresenterTabelaTempo implements ITempoObservador{

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
        ArrayList<Tempo> tempos = TempoCollection.getTempoCollection().getAllTempos();

    }
}
