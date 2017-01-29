package software.ifto.frequencia.model;

import java.util.Date;

/**
 * Created by Marques de Souza on 12/12/2016.
 */

public class Evento {
    private Date data;
    private String descricao;
    private String assunto;
    private String conteudo;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
