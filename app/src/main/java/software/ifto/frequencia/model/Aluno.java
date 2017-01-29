package software.ifto.frequencia.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Marques de Souza on 26/11/2016.
 */

public class Aluno implements Serializable{
        private Integer id;
        private String nome;
        private String matricula;
        private Integer idTurma;
        private Date dataCriacao;
        private Date dataAlteracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    @Override
    public String toString(){return getMatricula()+"-"+getNome();}


}
