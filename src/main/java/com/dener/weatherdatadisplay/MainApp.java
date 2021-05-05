package com.dener.weatherdatadisplay;

import com.dener.weatherdatadisplay.presenter.Inserir;
import com.dener.weatherdatadisplay.presenter.Remover;
import com.dener.weatherdatadisplay.view.Display;
import java.awt.event.ActionEvent;

public class MainApp {

    private static Display display;

    public static Display getDisplay() {
        return display;
    }

    public static void main(String args[]) {
        display = new Display();
        Inserir incluir = new Inserir();
        Remover remover = new Remover();
        
        display.getIncluirDados().addActionListener((ActionEvent e) -> {
            incluir.inserir(display);
        });
        
        display.getRemoverDados().addActionListener((ActionEvent e) -> {
            remover.removerDados();
        });
    }

}
