package br.ufes.pss.weather_data_display_final;

import br.ufes.pss.weather_data_display_final.presenter.TelaPrincipalPresenter;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;

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

        TelaPrincipalPresenter telaPrincipal = new TelaPrincipalPresenter();
        telaPrincipal.viewTelaPrincipal();

    }
}
