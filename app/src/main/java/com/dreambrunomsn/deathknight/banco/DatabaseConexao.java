package com.dreambrunomsn.deathknight.banco;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseConexao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "death_knight_dreammago_2018";

    private static final int DATABASE_VERSION = 1;

    private final String USUARIO = "CREATE TABLE IF NOT EXISTS USUARIO ( " +
            " ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " NOME TEXT NOT NULL, " +
            " APELIDO TEXT DEFAULT '', " +
            " EMAIL TEXT NOT NULL, " +
            " TELEFONE TEXT NOT NULL, " +
            " PATENTE TEXT DEFAULT 'Recruta', " +
            " NASCIMENTO INTEGER(8) NOT NULL, " +
            " BAN_FIM INTEGER(8) DEFAULT 0, " +
            " MASCULINO TINYINT(1) DEFAULT 1, " +
            " ADM TINYINT(1) DEFAULT 0, " +
            " BAN_SCORE INTEGER DEFAULT 0, " +
            " NIVEL TINYINT(2) DEFAULT 0 " +
            " )";

    private final String TESTE_PATENTES =
            " CREATE TABLE IF NOT EXISTS TESTE_PATENTE ( " +
            " ID_TESTE INTEGER PRIMARY KEY AUTOINCREMENT, " +
            " DATA_CRIACAO INTEGER(8) NOT NULL, " +
            " ABERTO TINYINT(1) DEFAULT 1, " +
            " DATA_TESTE INTEGER(8) NOT NULL, " +
            " ADM_CRIACAO INTEGER NOT NULL, " +
            " ADM_CONDUTOR INTEGER DEFAULT 1, " +
            " ADM_RESPONSAVEL INTEGER DEFAULT 1, " +
            " FOREIGN KEY (ADM_CRIACAO) REFERENCES USUARIO, " +
            " FOREIGN KEY (ADM_CONDUTOR) REFERENCES USUARIO, " +
            " FOREIGN KEY (ADM_RESPONSAVEL) REFERENCES USUARIO " +
            " )";

    private final String TESTE_PATENTES_USUARIO =
            " CREATE TABLE IF NOT EXISTS TESTE_PATENTE_USUARIO ( " +
            " ID_TESTE INTEGER, " +
            " ID_USUARIO INTEGER, " +
            " NOTA TINYINT(2), " +
            " APROVADO TINYINT(1), " +
            " ADM_CRIACAO INTEGER NOT NULL, " +
            " PRIMARY KEY (ID_TESTE, ID_USUARIO), " +
            " FOREIGN KEY (ADM_CRIACAO) REFERENCES USUARIO, " +
            " FOREIGN KEY (ID_TESTE) REFERENCES TESTE_PATENTE ON DELETE CASCADE ON UPDATE NO ACTION, " +
            " FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO ON DELETE CASCADE ON UPDATE NO ACTION " +
            " )";

    public DatabaseConexao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("Código", "Método Construtor DatabaseConexao");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // métodos de criação de tabelas
        try {
            db.execSQL(USUARIO);
            db.execSQL("insert into USUARIO (NOME, APELIDO, TELEFONE, NASCIMENTO, ADM, NIVEL, EMAIL ) values('Gabriel', 'Arkhanjo', 987654321, 20001122, 1, 3, 'ark@gmail.com')");
            Log.i("Código", "Criando usuario - " + USUARIO);

            db.execSQL(TESTE_PATENTES);
            db.execSQL("insert into TESTE_PATENTE (ID_TESTE, DATA_CRIACAO, DATA_TESTE, ADM_CRIACAO ) values(1, 20180901, 20180920, 1)");
            Log.i("Código", "Criando teste patente - " + TESTE_PATENTES);

            db.execSQL(TESTE_PATENTES_USUARIO);
            Log.i("Código", "Criando patente x usuario - " + TESTE_PATENTES_USUARIO);

        } catch(SQLException e){
            Log.e("Código", "Erro ao criar tabela patentes");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
