package br.ufes.pss.weather_data_display_final.model;

import java.time.LocalDate;

public class Tempo {

    private int id;
    private LocalDate dataTempo;
    private Double temperaturaTempo;
    private Double umidadeTempo;
    private Double pressaoTempo;

    public Tempo() {
    }

    public Tempo(int id, LocalDate dataTempo, Double temperaturaTempo, Double umidadeTempo, Double pressaoTempo) {
        this.id = id;
        this.dataTempo = dataTempo;
        this.temperaturaTempo = temperaturaTempo;
        this.umidadeTempo = umidadeTempo;
        this.pressaoTempo = pressaoTempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataTempo() {
        return dataTempo;
    }

    public void setDataTempo(LocalDate dataTempo) {
        this.dataTempo = dataTempo;
    }

    public Double getTemperaturaTempo() {
        return temperaturaTempo;
    }

    public void setTemperaturaTempo(Double temperaturaTempo) {
        this.temperaturaTempo = temperaturaTempo;
    }

    public Double getUmidadeTempo() {
        return umidadeTempo;
    }

    public void setUmidadeTempo(Double umidadeTempo) {
        this.umidadeTempo = umidadeTempo;
    }

    public Double getPressaoTempo() {
        return pressaoTempo;
    }

    public void setPressaoTempo(Double pressaoTempo) {
        this.pressaoTempo = pressaoTempo;
    }

}
