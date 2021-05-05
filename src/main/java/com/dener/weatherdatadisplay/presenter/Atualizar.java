package com.dener.weatherdatadisplay.presenter;

import com.dener.weatherdatadisplay.MainApp;
import com.dener.weatherdatadisplay.model.Tempo;
import com.dener.weatherdatadisplay.view.Display;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Atualizar {

    public static void atualizarUltima(String data, float temperatura, float umidade, float pressao) {
        Display display = MainApp.getDisplay();
        display.getUltimaData().setText(data);
        display.getUltimaTemperatura().setText(Float.toString(temperatura));
        display.getUltimaUmidade().setText(Float.toString(umidade));
        display.getUltimaPressao().setText(Float.toString(pressao));
    }

    public static void atualizarTabela(Tempo tempo) {
        JTable registroTabela = MainApp.getDisplay().getRegistroTabela();
        DefaultTableModel model = (DefaultTableModel) registroTabela.getModel();
        model.addRow(new Object[]{tempo.getData(), tempo.getTemperatura(), tempo.getUmidade(), tempo.getPressao()});
    }
    
    public static void removerRowTabela(int index) {
        JTable registroTabela = MainApp.getDisplay().getRegistroTabela();
        DefaultTableModel model = (DefaultTableModel) registroTabela.getModel();
        model.removeRow(index);
    }

    public static void atualizarMedia(float temperatura, float umidade, float pressao, int count) {
        Display display = MainApp.getDisplay();
        display.getMedioRegistros().setText(Float.toString(count));
        display.getMedioTemperatura().setText(Float.toString(temperatura));
        display.getMedioUmidade().setText(Float.toString(umidade));
        display.getMedioPressao().setText(Float.toString(pressao));
    }
}
