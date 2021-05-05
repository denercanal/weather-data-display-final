package com.dener.weatherdatadisplay.model;

public class Tempo {

    private String data;
    private float temperatura;
    private float umidade;
    private float pressao;

    public Tempo(String data, float temperatura, float umidade, float pressao) {
        this.data = data;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.pressao = pressao;
    }

    public Tempo() {
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
    }

    public void setPressao(float pressao) {
        this.pressao = pressao;
    }
    
    public String getData() {
        return data;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public float getUmidade() {
        return umidade;
    }

    public float getPressao() {
        return pressao;
    }
    
    TempoCollection temposCollect = TempoCollection.getIntances();

    public void setInformacoes(String[] tempos) {
        data = tempos[0];
        temperatura = (Float.parseFloat(tempos[1]));
        umidade = (Float.parseFloat(tempos[2]));
        pressao = (Float.parseFloat(tempos[3]));
        temposCollect.inserir(this);
    }
    
    public void removerInformacoes(String[] tempos ){
        data = tempos[0];
        temperatura = (Float.parseFloat(tempos[1]));
        umidade = (Float.parseFloat(tempos[2]));
        pressao = (Float.parseFloat(tempos[3]));
        temposCollect.remover(this);
    }
}
