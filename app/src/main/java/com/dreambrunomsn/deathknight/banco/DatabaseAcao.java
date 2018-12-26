package com.dreambrunomsn.deathknight.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dreambrunomsn.deathknight.classes.Sing;
import com.dreambrunomsn.deathknight.classes.Usuario;
import com.dreambrunomsn.deathknight.enums.Patente;
import com.dreambrunomsn.deathknight.utilitario.Data;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAcao {
    private SQLiteDatabase db;

    public DatabaseAcao(Context context){
        DatabaseConexao conect = new DatabaseConexao(context);
        db = conect.getWritableDatabase();
    }

    public List<TestePatenteVo> getTestePatente() {
        String[] colunas = {"ID_TESTE", "DATA_CRIACAO", "DATA_TESTE", "ADM_CRIACAO",
                            "ADM_CONDUTOR", "ADM_RESPONSAVEL", "ABERTO"};
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
                vo.setAdmCondutor(cursor.getInt(4));

                vo.setAdmResponsavel(cursor.getInt(5));
                vo.setAtivo(cursor.getInt(6) == 1);
                lista.add(vo);
            }while (cursor.moveToNext());
            return lista;
        }
        return null;
    }

    public long criarTestePatente(ContentValues valor) throws Exception{

        valor.put("DATA_CRIACAO", 20181126); // data de hoje
        valor.put("ADM_CRIACAO", Sing.getUsuario().getIdUsuario()); // pegar adm no sing
        valor.put("ABERTO", 1);

        return db.insert("TESTE_PATENTE", null, valor);
    }

    public List<Usuario> getAdm(){
        String[] colunas = {"ID_USUARIO", "APELIDO"};
        Cursor cursor = db.query("USUARIO", colunas, "ADM = 1", null,
                        null, null, "APELIDO");
        if(cursor.moveToNext()){
            List<Usuario> lista = new ArrayList<Usuario>();
            do{
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(cursor.getInt(0));
                usuario.setApelido(cursor.getString(1));
                lista.add(usuario);
            }while(cursor.moveToNext());
            return lista;
        }
        return null;
    }

    public Usuario getUsuario(int cod){
        String[] colunas = {"ID_USUARIO", "NOME", "APELIDO", "EMAIL", "TELEFONE",
                            "ID_PATENTE", "NASCIMENTO", "BAN_FIM", "MASCULINO", "ADM",
                            "BAN_SCORE", "NIVEL"};
        Cursor cursor = db.query("USUARIO", colunas, "ID_USUARIO = " + cod, null, null, null, null);

        Usuario logado = new Usuario();
        if(cursor.moveToNext()){
            logado.setIdUsuario(cursor.getInt(cursor.getColumnIndex("ID_USUARIO")));
            logado.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            logado.setApelido(cursor.getString(cursor.getColumnIndex("APELIDO")));
            logado.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
            logado.setTelefone(cursor.getString(cursor.getColumnIndex("TELEFONE")));

            logado.setPatente(Patente.getPatente(cursor.getInt(cursor.getColumnIndex("ID_PATENTE"))));
            logado.setNascimento(Data.setData(cursor.getInt(cursor.getColumnIndex("NASCIMENTO"))));
            logado.setBanFim(Data.setData(cursor.getInt(cursor.getColumnIndex("BAN_FIM"))));
            logado.setMasc(cursor.getInt(cursor.getColumnIndex("MASCULINO")) == 1);
            logado.setAdm(cursor.getInt(cursor.getColumnIndex("ADM")) == 1);

            logado.setBanScore(cursor.getInt(cursor.getColumnIndex("BAN_SCORE")));
            logado.setNivel(cursor.getInt(cursor.getColumnIndex("NIVEL")));
        }

        return logado;
    }
}
