package com.dreambrunomsn.deathknight.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAcao {
    private SQLiteDatabase db;

    public DatabaseAcao(Context context){
        DatabaseConexao conect = new DatabaseConexao(context);
        db = conect.getWritableDatabase();
    }

    public List<TestePatenteVo> getTestePatente() {
        String[] colunas = {"ID_TESTE", "DATA_CRIACAO", "DATA_TESTE", "ADM_CRIACAO", "ADM_CONDUTOR", "ADM_RESPONSAVEL", "ABERTO"};
        Cursor cursor = db.query("TESTE_PATENTE", colunas, "ABERTO = 1",
                    null, null, null, "DATA_TESTE");
        if(cursor.moveToNext()){
            List<TestePatenteVo> lista = new ArrayList<TestePatenteVo>();
            do{
                TestePatenteVo vo = new TestePatenteVo();
                vo.setIdTeste(cursor.getInt(0));
                vo.setDataCriacao(cursor.getInt(1));
                vo.setDataTeste(cursor.getInt(2));
                vo.setAdmCriacao(cursor.getInt(3));
                vo.setAdmCriacao(cursor.getInt(4));
                vo.setAdmCriacao(cursor.getInt(5));
                vo.setAtivo(cursor.getInt(6) == 1 ? true : false);
                lista.add(vo);
            }while (cursor.moveToNext());
            return lista;
        }
        return null;
    }

    public boolean InserirTestePatente(ContentValues valor){
        try {
            db.insert("TESTE_PATENTE", null, valor);
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}
