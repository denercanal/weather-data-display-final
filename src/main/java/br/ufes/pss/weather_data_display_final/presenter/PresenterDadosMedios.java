package br.ufes.pss.weather_data_display_final.presenter;

import br.ufes.pss.weather_data_display_final.business.CalculadorMediaDia;
import br.ufes.pss.weather_data_display_final.business.CalculadorMediaMes;
import br.ufes.pss.weather_data_display_final.business.CalculadorMediaSemana;
import br.ufes.pss.weather_data_display_final.business.CalculadorMediaTempo;
import br.ufes.pss.weather_data_display_final.collection.TempoCollection;
import br.ufes.pss.weather_data_display_final.model.TempoMedia;
import br.ufes.pss.weather_data_display_final.observer.ITempoObservador;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import br.ufes.pss.weather_data_display_final.view.ViewTelaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresenterDadosMedios implements ITempoObservador {

    private ViewTelaPrincipal viewTelaPrincipal;
    private ViewDadosMedios viewDadosMedios;
    private CalculadorMediaTempo calculador;
    private TempoCollection tempoCollection;
    
    public PresenterDadosMedios(ViewTelaPrincipal viewTelaPrincipal) {
        this.viewTelaPrincipal = viewTelaPrincipal;
        this.viewDadosMedios = new ViewDadosMedios();
        this.calculador = new CalculadorMediaDia();
        this.viewTelaPrincipal.getDesktop().add(this.viewDadosMedios);
        atualizaDados();
        
        this.viewDadosMedios.getCbbPeriodo().addActionListener( new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent arg0) {
                atualizaDados();

            }
            
        });
    }

    public void viewDadosMediosVisible() {
        this.viewDadosMedios.setVisible(true);
    }
    
    private void atualizaDados() {
        
        String opcao = this.viewDadosMedios.getCbbPeriodo().getSelectedItem().toString();
        
        if (opcao.equalsIgnoreCase("diario")){
            calculador = new CalculadorMediaDia();
        }
        if (opcao.equalsIgnoreCase("semanal")){
            calculador = new CalculadorMediaSemana();
        }
        if (opcao.equalsIgnoreCase("mensal")){
            calculador = new CalculadorMediaMes();
        }
        
    }
    
    public void atualizarCampos(TempoMedia tempoMedia){
        
        viewDadosMedios.getTemperaturaMedia().setText(String.format("%.2f", tempoMedia.getTemperaturaTempo()));
        viewDadosMedios.getUmidadeMedia().setText(String.format("%.2f",tempoMedia.getUmidadeTempo()));
        viewDadosMedios.getPressaoMedia().setText(String.format("%.2f",tempoMedia.getPressaoTempo()));
        viewDadosMedios.getTotalRegistrosMedia().setText(String.valueOf(tempoMedia.getQuantidadeTempo()));
    }
    
    public void limparCampos(){
        
        viewDadosMedios.getTemperaturaMedia().setText("");
        viewDadosMedios.getUmidadeMedia().setText("");
        viewDadosMedios.getPressaoMedia().setText("");
        viewDadosMedios.getTotalRegistrosMedia().setText("0");
    }
    
    private void calcularMedia(){
        try{
            TempoMedia tempo = calculador.calcular(this.tempoCollection);
            atualizarCampos(tempo);
        }catch(RuntimeException re){
            limparCampos();
        }
    }

    @Override
    public void update(TempoCollection registrosTempo) {
        this.tempoCollection = registrosTempo;
        calcularMedia();        
    }
}
