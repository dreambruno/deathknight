package com.dreambrunomsn.deathknight.banco;

public class TestePatenteVo {
    private int idTeste;
    private int dataCriacao;
    private int dataTeste;

    private boolean ativo;

    private int admCriacao;
    private int admCondutor;
    private int admResponsavel;


    public int getIdTeste() {
        return idTeste;
    }
    public void setIdTeste(int idTeste) {
        this.idTeste = idTeste;
    }

    public int getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(int dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getDataTeste() {
        return dataTeste;
    }
    public void setDataTeste(int dataTeste) {
        this.dataTeste = dataTeste;
    }

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getAdmCriacao() {
        return admCriacao;
    }
    public void setAdmCriacao(int admCriacao) {
        this.admCriacao = admCriacao;
    }

    public int getAdmCondutor() {
        return admCondutor;
    }
    public void setAdmCondutor(int admCondutor) {
        this.admCondutor = admCondutor;
    }

    public int getAdmResponsavel() {
        return admResponsavel;
    }
    public void setAdmResponsavel(int admResponsavel) {
        this.admResponsavel = admResponsavel;
    }
}
