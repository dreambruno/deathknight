package com.dreambrunomsn.deathknight.telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.dreambrunomsn.deathknight.R;
import com.dreambrunomsn.deathknight.banco.DatabaseAcao;
import com.dreambrunomsn.deathknight.classes.Sing;
import com.dreambrunomsn.deathknight.utilitario.Data;

public class LoginGoogle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_google);

        DatabaseAcao dba = new DatabaseAcao(this);
    }

    public void entrar(View v){
        Sing.getUsuario().setNome("Bruno Affonso");
        Sing.getUsuario().setPatente("Cabo");
        Sing.getUsuario().setApelido("Dream");
        Sing.getUsuario().setEmail("dreambruno@gmail.com");
        Sing.getUsuario().setAdm(true);
        Sing.getUsuario().setMasc(true);
        Sing.getUsuario().setNascimento(Data.setData(19810615));
        Sing.getUsuario().setTelefone("21 99933-1441");
        Sing.getUsuario().setBanScore(0);
        Sing.getUsuario().setBanFim(null);
        Sing.getUsuario().setNivel(3);

        Intent intent = new Intent(LoginGoogle.this, Dashboard.class);
        startActivity(intent);
        finish();
    }
}
