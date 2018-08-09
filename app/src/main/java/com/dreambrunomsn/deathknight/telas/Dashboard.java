package com.dreambrunomsn.deathknight.telas;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.dreambrunomsn.deathknight.R;
import com.dreambrunomsn.deathknight.classes.Sing;
import com.dreambrunomsn.deathknight.utilitario.Data;

import java.util.Calendar;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tvNome;
    private TextView tvPatente;

    private ImageView imFoto;

    private Switch editarPerfil;

    private EditText etxNome;
    private EditText etxNick;
    private EditText etxPatente;
    private EditText etxEmail;
    private EditText etxTelefone;

    private RadioButton rbMasculino;
    private RadioButton rbFeminino;

    private Button btNascimento;
    private Calendar nascimento;

    private ViewFlipper viewFlipper;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar.setNavigationOnClickListener(nav);

        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        viewFlipper.setDisplayedChild(0);

        editarPerfil = (Switch) findViewById(R.id.editarPerfil);
        etxNome = (EditText) findViewById(R.id.etxNome);
        etxNick = (EditText) findViewById(R.id.etxNick);
        etxPatente = (EditText) findViewById(R.id.etxPatente);
        etxEmail = (EditText) findViewById(R.id.etxEmail);
        etxTelefone = (EditText) findViewById(R.id.etxTelefone);

        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        btNascimento = (Button) findViewById(R.id.btNasc);


        etxNome.setText(Sing.getUsuario().getNome());
        etxNick.setText(Sing.getUsuario().getApelido());
        etxPatente.setText(Sing.getUsuario().getPatente());
        etxEmail.setText(Sing.getUsuario().getEmail());
        etxTelefone.setText(Sing.getUsuario().getTelefone());

        rbMasculino.setChecked(Sing.getUsuario().isMasc());
        rbFeminino.setChecked(!Sing.getUsuario().isMasc());

        nascimento = Sing.getUsuario().getNascimento();
        if(nascimento == null) {
            nascimento = Calendar.getInstance();
        }else{
            btNascimento.setText(Data.dataFormatada(nascimento));
        }
    }
    View.OnClickListener nav = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            escondeTeclado();
            drawer.openDrawer(Gravity.LEFT, true);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);

        tvNome = (TextView)findViewById(R.id.tvNome);
        tvPatente = (TextView)findViewById(R.id.tvPatente);
        imFoto = (ImageView)findViewById(R.id.imFoto);


        tvNome.setText(Sing.getUsuario().getApelido());
        tvPatente.setText(Sing.getUsuario().getPatente());
        //imFoto.setImageBitmap(R.mipmap.ic_launcher);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = 0;
        if(item != null) {
            id = item.getItemId();
        }

        switch (id) {
            case R.id.nav_perfil:
                viewFlipper.setDisplayedChild(1);
                setTitle(R.string.menu_perfil);
                break;

            case R.id.nav_eventos:
                viewFlipper.setDisplayedChild(2);
                setTitle(R.string.menu_eventos);
                break;

            case R.id.nav_configuracoes:
                viewFlipper.setDisplayedChild(3);
                setTitle(R.string.menu_cofiguracoes);
                break;

            case R.id.nav_adm:
                if(Sing.getUsuario().isAdm()){
                    Intent intent = new Intent(Dashboard.this, Administracao.class);
                    startActivity(intent);
                }else{
                    viewFlipper.setDisplayedChild(4);
                }
                setTitle(R.string.menu_adm);
                break;

            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;

            default:
                viewFlipper.setDisplayedChild(0);
                setTitle(R.string.menu_home);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void salvar(View v){
        Sing.getUsuario().setNome(etxNome.getText().toString());
        Sing.getUsuario().setApelido(etxNick.getText().toString());
        Sing.getUsuario().setEmail(etxEmail.getText().toString());
        Sing.getUsuario().setTelefone(etxTelefone.getText().toString());

        Sing.getUsuario().setNascimento(nascimento);
        Sing.getUsuario().setMasc(rbMasculino.isSelected());


        tvNome.setText(Sing.getUsuario().getApelido());
        escondeTeclado();
        editarPerfil.setChecked(false);
        editar(null);
        onNavigationItemSelected(null);

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

        rbMasculino.setEnabled(check);
        rbFeminino.setEnabled(check);
        btNascimento.setEnabled(check);

        escondeTeclado();
    }

    public void sera(View v){
        Toast.makeText(this, "Será?", Toast.LENGTH_SHORT).show();
    }

    private void escondeTeclado(){
        InputMethodManager imm = (InputMethodManager) getSystemService(getBaseContext().INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etxNome.getWindowToken(), 0);
    }

    public void abrirDatepicker(View v){
        DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                nascimento.set(year, month, dayOfMonth);
                btNascimento.setText(Data.dataFormatada(nascimento));
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(Dashboard.this, dateListener,
                                nascimento.get(Calendar.YEAR),
                                nascimento.get(Calendar.MONTH),
                                nascimento.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
