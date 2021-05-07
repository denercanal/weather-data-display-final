package br.ufes.pss.weather_data_display_final;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.presenter.PresenterTelaPrincipal;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.time.LocalDate;

public class Application {

    public static void main(String args[]) {
        /*
        Aplicando tema na janela.
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        PresenterTelaPrincipal telaPrincipal = new PresenterTelaPrincipal();
        
        Tempo tempo1 = new Tempo(0, LocalDate.now().plusMonths(1), 10D, 10D, 10D);
        Tempo tempo2 = new Tempo(1, LocalDate.now().plusMonths(1), 10D, 10D, 10D);
        Tempo tempo3 = new Tempo(2, LocalDate.now().plusWeeks(-5), 20D, 20D, 20D);
        Tempo tempo4 = new Tempo(3, LocalDate.now().plusWeeks(-5), 20D, 20D, 20D);
        Tempo tempo5 = new Tempo(4, LocalDate.now(), 5D, 5D, 5D);
        Tempo tempo6 = new Tempo(5, LocalDate.now(), 2D, 2D, 2D);

        TempoCollection.getTempoCollection().inserir(tempo1);
        TempoCollection.getTempoCollection().inserir(tempo2);
        TempoCollection.getTempoCollection().inserir(tempo3);
        TempoCollection.getTempoCollection().inserir(tempo4);
        TempoCollection.getTempoCollection().inserir(tempo5);
        TempoCollection.getTempoCollection().inserir(tempo6);
    }
}
