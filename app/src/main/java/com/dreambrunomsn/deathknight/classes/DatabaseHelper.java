package com.dreambrunomsn.deathknight.classes;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "death_knight_dreammago_2018";

    private static final int DATABASE_VERSION = 1;

    private final String CRIAR_TABELA_PATENTES =
            " CREATE TABLE IF NOT EXISTS TESTE_PATENTE ( " +
            " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " DATA INTEGER(8) " +
            " )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("Código", "Método Construtor DatabaseHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // métodos de criação de tabelas
        try {
            db.execSQL(CRIAR_TABELA_PATENTES);
        } catch(SQLException e){
            Log.e("Código", "Erro ao criar tabela patentes");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
