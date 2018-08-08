package com.dreambrunomsn.deathknight.classes;

/**
 * Created by Dream on 05/08/2018.
 */

public class Sing {
    private static final Sing ourInstance = new Sing();

    private static Usuario usuario;

    static Sing getInstance() {
        return ourInstance;
    }

    private Sing() {
        this.usuario = new Usuario();
    }

    public static Usuario getUsuario() {
        return usuario;
    }
}
