package com.dreambrunomsn.deathknight.telas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.dreambrunomsn.deathknight.R;

public class Abertura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_abertura);




        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                // Pegando dados do save
                //List<ContentValues> lista = new DatabaseConexao(getBaseContext()).buscarEscala();

                Intent intent = new Intent(Abertura.this, LoginGoogle.class);
                startActivity(intent);
                finish();
            }
        }, 2000);// fim do new Handler()


    }


}
