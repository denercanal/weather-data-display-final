package br.ufes.pss.weather_data_display_final.business;

import br.ufes.pss.weather_data_display_final.command.TempoGerarGraficoCommand;
import br.ufes.pss.weather_data_display_final.command.TempoInserirCommand;
import br.ufes.pss.weather_data_display_final.command.TempoRemoverCommand;
import br.ufes.pss.weather_data_display_final.decorator.Grafico;
import br.ufes.pss.weather_data_display_final.model.GraficoOptions;
import br.ufes.pss.weather_data_display_final.model.Tempo;
import br.ufes.pss.weather_data_display_final.view.ViewDadosMedios;
import br.ufes.pss.weather_data_display_final.view.ViewDadosTempo;

public class BusinessTempo {

    public void inserir(ViewDadosTempo viewDadosTempo) throws Exception {
        try {
            validacaoInserir(viewDadosTempo);
            new TempoInserirCommand().executarInserir(viewDadosTempo);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void remover(Tempo tempo) throws Exception {
        try {

            validacaoRemover(tempo);

            new TempoRemoverCommand().executarRemover(tempo);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void graficoHorizontal(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions) throws Exception {

        this.validaViewDadosMedios(viewDadosMedios);
        graficoOptions.setTipo("horizontal");
        new TempoGerarGraficoCommand().executarGerarGrafico(viewDadosMedios, grafico, graficoOptions);
    }

    public void graficoVertical(ViewDadosMedios viewDadosMedios, Grafico grafico, GraficoOptions graficoOptions) throws Exception {

        this.validaViewDadosMedios(viewDadosMedios);

        graficoOptions.setTipo("vertical");
        new TempoGerarGraficoCommand().executarGerarGrafico(viewDadosMedios, grafico, graficoOptions);
    }

    private void validaViewDadosMedios(ViewDadosMedios viewDadosMedios) throws Exception {

        try {
            if (viewDadosMedios.getTemperaturaMedia().getText().isBlank() || viewDadosMedios.getUmidadeMedia().getText().isBlank() || viewDadosMedios.getPressaoMedia().getText().isBlank()) {
                throw new Exception("Impossível gerar gráfico, sem dados inseridos para o período!");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void validacaoInserir(ViewDadosTempo viewDadosTempo) throws Exception {
        if ((viewDadosTempo.getDataTempo().getText().isBlank()) || viewDadosTempo.getDataTempo().getText().equalsIgnoreCase("  /  /    ")) {
            throw new Exception("Favor preencher o campo data!");
        }

        if (viewDadosTempo.getTemperaturaTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo temperatura!");
        }

        if (viewDadosTempo.getUmidadeTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo umidade!");
        }

        if (viewDadosTempo.getPressaoTempo().getText().isBlank()) {
            throw new Exception("Favor preencher o campo pressão!");
        }
    }

    private void validacaoRemover(Tempo tempo) throws Exception {
        if (tempo == null) {
            throw new Exception("Elemento inválido!");
        }
    }

}
