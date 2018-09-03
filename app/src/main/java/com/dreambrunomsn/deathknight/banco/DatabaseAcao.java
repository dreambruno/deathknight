package com.dreambrunomsn.deathknight.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.dreambrunomsn.deathknight.classes.Usuario;

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

    public boolean criarTestePatente(ContentValues valor){
        try {
            db.insert("TESTE_PATENTE", null, valor);
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    public List<Usuario> getAdm(){
        String[] colunas = {"ID_USUARIO", "APELIDO"};
        Cursor cursor = db.query("USUARIO", colunas, "ADM = 1", null,
                        null, null, "APELIDO");
        if(cursor.moveToNext()){
            List<Usuario> lista = new ArrayList<Usuario>();
            do{
                Usuario usuario = new Usuario();
                usuario.setIdUsuario("" + cursor.getInt(0));
                usuario.setApelido(cursor.getString(1));
                lista.add(usuario);
            }while(cursor.moveToNext());
            return lista;
        }
        return null;
    }
}
