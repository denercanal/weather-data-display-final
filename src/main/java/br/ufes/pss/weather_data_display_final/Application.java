package br.ufes.pss.weather_data_display_final;

import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.presenter.PresenterTelaPrincipal;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.time.LocalDate;

public class Application {

    public static void main(String args[]) {

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

        Tempo tempo0 = new Tempo(0, LocalDate.now(), 0D, 0D, 0D);
        Tempo tempo1 = new Tempo(1, LocalDate.now().plusDays(1), 1D, 1D, 1D);
        Tempo tempo2 = new Tempo(2, LocalDate.now().plusDays(2), 2D, 2D, 2D);
        Tempo tempo3 = new Tempo(3, LocalDate.now().plusDays(3), 3D, 3D, 3D);
        Tempo tempo4 = new Tempo(4, LocalDate.now().plusDays(4), 4D, 4D, 4D);
        Tempo tempo5 = new Tempo(5, LocalDate.now().plusDays(5), 5D, 5D, 5D);
        Tempo tempo6 = new Tempo(6, LocalDate.now().plusDays(6), 5D, 6D, 6D);

        TempoCollection.getTempoCollection().inserir(tempo0);
        TempoCollection.getTempoCollection().inserir(tempo1);
        TempoCollection.getTempoCollection().inserir(tempo2);
        TempoCollection.getTempoCollection().inserir(tempo3);
        TempoCollection.getTempoCollection().inserir(tempo4);
        TempoCollection.getTempoCollection().inserir(tempo5);
        TempoCollection.getTempoCollection().inserir(tempo6);
    }
}
