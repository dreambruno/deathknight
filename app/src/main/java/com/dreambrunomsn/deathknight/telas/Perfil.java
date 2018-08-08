package com.dreambrunomsn.deathknight.telas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import com.dreambrunomsn.deathknight.R;

public class Perfil extends AppCompatActivity {

    private Switch editarPerfil;

    private EditText etxNome;
    private EditText etxNick;
    private EditText etxPatente;
    private EditText etxEmail;
    private EditText etxTelefone;
    private EditText etxNascimento;

    private RadioButton rbNome;
    private RadioButton rbApelido;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;

    private Button btSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);


        editarPerfil = (Switch) findViewById(R.id.editarPerfil);
        etxNome = (EditText) findViewById(R.id.etxNome);
        etxNick = (EditText) findViewById(R.id.etxNick);
        etxPatente = (EditText) findViewById(R.id.etxPatente);
        etxEmail = (EditText) findViewById(R.id.etxEmail);
        etxTelefone = (EditText) findViewById(R.id.etxTelefone);
        etxNascimento = (EditText) findViewById(R.id.etxNascimento);

        rbNome = (RadioButton) findViewById(R.id.rbNome);
        rbApelido = (RadioButton) findViewById(R.id.rbApelido);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        btSalvar = (Button) findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(listener);

        etxNome.setText("Bruno");
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Perfil.this, "vai!", Toast.LENGTH_SHORT).show();
        }
    };

    public void salvarPerfil(View v){
        Toast.makeText(this, "salvar", Toast.LENGTH_SHORT).show();
        //Sing.getUsuario().setNome(etxNome.getText().toString());
        //String tx = Sing.getUsuario().getNome();

        //MenuItem mi = (MenuItem) findViewById(R.id.nav_perfil);
        //onNavigationItemSelected(mi);
    }

    public void editar(View v){
        boolean check = editarPerfil.isChecked();

        etxNome.setFocusableInTouchMode(check);
        etxNome.setFocusable(check);

        etxNick.setFocusableInTouchMode(check);
        etxNick.setFocusable(check);

        etxEmail.setFocusableInTouchMode(check);
        etxEmail.setFocusable(check);

        etxTelefone.setFocusableInTouchMode(check);
        etxTelefone.setFocusable(check);

        etxNascimento.setFocusableInTouchMode(check);
        etxNascimento.setFocusable(check);

        rbNome.setEnabled(check);
        rbApelido.setEnabled(check);
        rbMasculino.setEnabled(check);
        rbFeminino.setEnabled(check);
    }
}
