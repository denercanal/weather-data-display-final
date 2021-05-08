package br.ufes.pss.weather_data_display_final.model;

public class GraficoMedias {

    private Double temperaturaMedia;
    private Double umidadeMedia;
    private Double pressaoMedia;

    public GraficoMedias(Double temperaturaMedia, Double umidadeMedia, Double pressaoMedia) {
        this.temperaturaMedia = temperaturaMedia;
        this.umidadeMedia = umidadeMedia;
        this.pressaoMedia = pressaoMedia;
    }

    public Double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public Double getUmidadeMedia() {
        return umidadeMedia;
    }

    public void setUmidadeMedia(Double umidadeMedia) {
        this.umidadeMedia = umidadeMedia;
    }

    public Double getPressaoMedia() {
        return pressaoMedia;
    }

    public void setPressaoMedia(Double pressaoMedia) {
        this.pressaoMedia = pressaoMedia;
    }
}
