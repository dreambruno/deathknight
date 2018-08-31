package com.dreambrunomsn.deathknight.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseAcao {
    private SQLiteDatabase db;

    public DatabaseAcao(Context context){
        DatabaseConexao conect = new DatabaseConexao(context);
        db = conect.getWritableDatabase();
    }
}
