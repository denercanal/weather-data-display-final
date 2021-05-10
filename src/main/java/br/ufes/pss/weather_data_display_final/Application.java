package br.ufes.pss.weather_data_display_final;

import br.ufes.pss.weather_data_display_final.presenter.PresenterTelaPrincipal;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

public class Application {

    public static void main(String args[]) throws InterruptedException {

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

        new PresenterTelaPrincipal();

//        Tempo tempo0 = new Tempo(0, LocalDate.now(), 100.9D, 200.2D, 530.7D, "");
//        Tempo tempo1 = new Tempo(1, LocalDate.now().plusDays(1), 1D, 1D, 1D, "");
//        Tempo tempo2 = new Tempo(2, LocalDate.now().plusDays(2), 2D, 2D, 2D, "");
//
//        TempoCollection.getTempoCollection().inserir(tempo0);
//        TimeUnit.SECONDS.sleep(1);
//        TempoCollection.getTempoCollection().inserir(tempo1);
//        TimeUnit.SECONDS.sleep(1);
//        TempoCollection.getTempoCollection().inserir(tempo2);
    }
}
