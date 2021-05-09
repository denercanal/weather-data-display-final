package br.ufes.pss.weather_data_display_final.model;

public class GraficoOptions {

    private Double temperaturaMedia;
    private Double umidadeMedia;
    private Double pressaoMedia;
    private Boolean selected;
    private String tituloEixoX;
    private String tituloEixoY;
    private String tipo;

    public GraficoOptions() {
    }

    public GraficoOptions(Double temperaturaMedia, Double umidadeMedia, Double pressaoMedia, Boolean selected, String tituloEixoX, String tituloEixoY, String tipo) {
        this.temperaturaMedia = temperaturaMedia;
        this.umidadeMedia = umidadeMedia;
        this.pressaoMedia = pressaoMedia;
        this.selected = selected;
        this.tituloEixoX = tituloEixoX;
        this.tituloEixoY = tituloEixoY;
        this.tipo = tipo;
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

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getTituloEixoX() {
        return tituloEixoX;
    }

    public void setTituloEixoX(String tituloEixoX) {
        this.tituloEixoX = tituloEixoX;
    }

    public String getTituloEixoY() {
        return tituloEixoY;
    }

    public void setTituloEixoY(String tituloEixoY) {
        this.tituloEixoY = tituloEixoY;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
