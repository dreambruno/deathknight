package com.dreambrunomsn.deathknight.classes;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Dream on 29/04/2018.
 */

public class Usuario implements Serializable {

    private String id;

    private String nome;
    private String apelido;
    private String email;
    private String telefone;
    private String patente;

    private Calendar nascimento;
    private Calendar banFim;

    private boolean masc;
    private boolean adm;

    private int banScore;
    private int nivel;


    // CONSTRUCTOR
    public Usuario() {
        this.id = "";
        this.nome = "";
        this.apelido = "";
        this.email = "";
        this.patente = "";
        this.nascimento = Calendar.getInstance();
        this.banFim = null;
        this.masc = false;
        this.adm = false;
        this.telefone = "";
        this.banScore = 0;
        this.nivel = 0;
    }

    // GETTERS AND SETTERS

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Calendar getBanFim() {
        return banFim;
    }

    public void setBanFim(Calendar banAte) {
        this.banFim = banAte;
    }

    public int getBanScore() {
        return banScore;
    }

    public void setBanScore(int banScore) {
        this.banScore = banScore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar idade) {
        this.nascimento = idade;
    }

    public boolean isMasc() {
        return masc;
    }

    public void setMasc(boolean masc) {
        this.masc = masc;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
