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
                //List<ContentValues> lista = new DatabaseHelper(getBaseContext()).buscarEscala();

                Intent intent = new Intent(Abertura.this, LoginGoogle.class);
                /*
                if(lista != null) {
                    if (lista.size() > 0) {
                        intent.putExtra("trabalho", lista.get(0).getAsInteger("trabalho"));
                        intent.putExtra("folga", lista.get(0).getAsInteger("folga"));
                        intent.putExtra("reuniao", (lista.get(0).getAsInteger("reuniao") == 1));
                        intent.putExtra("dia", lista.get(0).getAsInteger("dia"));
                        intent.putExtra("mes", lista.get(0).getAsInteger("mes"));
                        intent.putExtra("ano", lista.get(0).getAsInteger("ano"));
                    }// fim if size
                }// fim if null
                */
                startActivity(intent);
                finish();
            }
        }, 2000);// fim do new Handler()


    }


}
