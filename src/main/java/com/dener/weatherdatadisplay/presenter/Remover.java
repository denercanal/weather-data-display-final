package com.dener.weatherdatadisplay.presenter;

import com.dener.weatherdatadisplay.MainApp;
import com.dener.weatherdatadisplay.model.Tempo;
import com.dener.weatherdatadisplay.view.Display;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dener
 */
public class Remover {

    public void removerDados() {
        Tempo tempo = new Tempo();
        Display display = MainApp.getDisplay();
        JTable table = display.getRegistroTabela();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (table.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "erro!");
        } else {
            Vector v = model.getDataVector().elementAt(table.getSelectedRow());
            String data, temperatura, umidade, pressao;
            data = v.get(0).toString();
            temperatura = v.get(1).toString();
            umidade = v.get(2).toString();
            pressao = v.get(3).toString();
            String[] vetorRemover = new String[4];
            vetorRemover[0] = data;
            vetorRemover[1] = temperatura;
            vetorRemover[2] = umidade;
            vetorRemover[3] = pressao;

            tempo.removerInformacoes(vetorRemover);
            update(table.getSelectedRow());
        }

    }

    public void update(int index) {
        
        Atualizar.removerRowTabela(index);
    }
}
