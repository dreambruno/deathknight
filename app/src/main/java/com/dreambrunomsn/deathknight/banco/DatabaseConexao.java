package com.dreambrunomsn.deathknight.banco;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseConexao extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "death_knight_dreammago_2018";

    private static final int DATABASE_VERSION = 1;

    public DatabaseConexao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.i("Código", "Método Construtor DatabaseConexao");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // métodos de criação de tabelas
        try {
            String USUARIO = "CREATE TABLE IF NOT EXISTS USUARIO ( " +
                    " ID_USUARIO INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " NOME TEXT NOT NULL, " +
                    " APELIDO TEXT DEFAULT '', " +
                    " EMAIL TEXT NOT NULL, " +
                    " TELEFONE TEXT NOT NULL, " +

                    " ID_PATENTE INTEGER DEFAULT 10, " +
                    " NASCIMENTO INTEGER(8) NOT NULL, " +
                    " BAN_FIM INTEGER(8) DEFAULT 0, " +
                    " MASCULINO TINYINT(1) DEFAULT 1, " +
                    " ADM TINYINT(1) DEFAULT 0, " +

                    " BAN_SCORE INTEGER DEFAULT 0, " +
                    " NIVEL TINYINT(2) DEFAULT 0 " +
                    " )";

            db.execSQL(USUARIO);
            db.execSQL("insert into USUARIO (NOME, APELIDO, TELEFONE, NASCIMENTO, ADM, NIVEL, EMAIL, ID_PATENTE ) " +
                            " values('Gabriel', 'Arkhanjo', 987654321, 20001122, 1, 3, 'ark@gmail.com', 40)");

            db.execSQL("insert into USUARIO (NOME, APELIDO, TELEFONE, NASCIMENTO, ADM, NIVEL, EMAIL, ID_PATENTE ) " +
                    " values('Bruno', 'Dream', 999331441, 19810615, 1, 4, 'dream@gmail.com', 30)");

            db.execSQL("insert into USUARIO (NOME, APELIDO, TELEFONE, NASCIMENTO, ADM, NIVEL, EMAIL, ID_PATENTE ) " +
                    " values('Anakin', 'Vader', 987655486, 17520112, 1, 5, 'anakin@gmail.com', 160)");



            String TESTE_PATENTES = " CREATE TABLE IF NOT EXISTS TESTE_PATENTE ( " +
                    " ID_TESTE INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " DATA_CRIACAO INTEGER(8) NOT NULL, " +
                    " ABERTO TINYINT(1) DEFAULT 1, " +
                    " DATA_TESTE INTEGER(8) NOT NULL, " +
                    " ADM_CRIACAO INTEGER NOT NULL, " +
                    " ADM_CONDUTOR INTEGER, " +
                    " ADM_RESPONSAVEL INTEGER DEFAULT 1, " +
                    " FOREIGN KEY (ADM_CRIACAO) REFERENCES USUARIO, " +
                    " FOREIGN KEY (ADM_CONDUTOR) REFERENCES USUARIO, " +
                    " FOREIGN KEY (ADM_RESPONSAVEL) REFERENCES USUARIO " +
                    " )";

            db.execSQL(TESTE_PATENTES);



            String TESTE_PATENTES_USUARIO = " CREATE TABLE IF NOT EXISTS TESTE_PATENTE_USUARIO ( " +
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

            db.execSQL(TESTE_PATENTES_USUARIO);

        } catch(SQLException e){
            Log.e("Código", "Erro ao criar tabelas: " + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
