package software.ifto.frequencia.model;

import java.util.Date;
import java.util.List;

import software.ifto.frequencia.model.Evento;
import software.ifto.frequencia.model.Parte;

/**
 * Created by Marques de Souza on 12/12/2016.
 */

public class Processo {
    private Integer numeroProcesso;
    private Date data;
    private String juiz;
    private String comarca;
    private String tipoProcesso;
    private List<Parte> partes;
    private List<Evento> eventos;

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Integer getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(Integer numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getJuiz() {
        return juiz;
    }

    public void setJuiz(String juiz) {
        this.juiz = juiz;
    }

    public String getComarca() {
        return comarca;
    }

    public void setComarca(String comarca) {
        this.comarca = comarca;
    }

    public String getTipoProcesso() {
        return tipoProcesso;
    }

    public void setTipoProcesso(String tipoProcesso) {
        this.tipoProcesso = tipoProcesso;
    }

    public List<Parte> getPartes() {
        return partes;
    }

    public void setPartes(List<Parte> partes) {
        this.partes = partes;
    }
}
