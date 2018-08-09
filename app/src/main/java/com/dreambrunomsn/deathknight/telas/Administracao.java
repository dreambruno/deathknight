package com.dreambrunomsn.deathknight.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dreambrunomsn.deathknight.R;

public class Administracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracao);
    }

    public void botaoum(View v){
        Toast.makeText(this, "Um!", Toast.LENGTH_SHORT).show();
    }

    public void botaodois(View v){
        Toast.makeText(this, "Dois!", Toast.LENGTH_SHORT).show();}

    public void botaotres(View v){
        Toast.makeText(this, "Três!", Toast.LENGTH_SHORT).show();}

    public void botaoquatro(View v){
        Toast.makeText(this, "Quatro!", Toast.LENGTH_SHORT).show();}

    public void botaocinco(View v){
        Toast.makeText(this, "Cinco!", Toast.LENGTH_SHORT).show();}

    public void botaoseis(View v){
        Toast.makeText(this, "Seis!", Toast.LENGTH_SHORT).show();}
}
