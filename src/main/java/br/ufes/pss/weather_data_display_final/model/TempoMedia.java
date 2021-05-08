package br.ufes.pss.weather_data_display_final.model;

import java.time.LocalDate;

public class TempoMedia extends Tempo {
    
    private int quantidadeTempo;

    public TempoMedia() {
    }

    public TempoMedia(int quantidadeTempo, int id, LocalDate dataTempo, Double temperaturaTempo, Double umidadeTempo, Double pressaoTempo) {
        super(id, dataTempo, temperaturaTempo, umidadeTempo, pressaoTempo);
        this.quantidadeTempo = quantidadeTempo;
    }
    
    public int getQuantidadeTempo() {
        return quantidadeTempo;
    }

    public void setQuantidadeTempo(int quantidadeTempo) {
        this.quantidadeTempo = quantidadeTempo;
    }
    
}
