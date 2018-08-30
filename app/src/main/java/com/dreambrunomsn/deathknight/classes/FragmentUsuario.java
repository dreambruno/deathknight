package com.dreambrunomsn.deathknight.classes;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dreambrunomsn.deathknight.R;

/**
 * Created by Dream on 11/08/2018.
 */

public class FragmentUsuario extends Fragment implements View.OnClickListener{

    private Context contexto;
    private Button btBanir;
    private Button btPatente;

    private TextView listarBan;
    private TextView listarHoje;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuario, container, false);

        btBanir = (Button) view.findViewById(R.id.btBanir);
        btPatente = (Button) view.findViewById(R.id.btPatente);
        listarBan = (TextView) view.findViewById(R.id.tvListarBanidos);
        listarHoje = (TextView) view.findViewById(R.id.tvListarHoje);

        btBanir.setOnClickListener(this);
        btPatente.setOnClickListener(this);
        listarBan.setOnClickListener(this);
        listarHoje.setOnClickListener(this);

        return view;
    }

    public void setContext(Context context) {
        this.contexto = context;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btBanir.getId()){
            Toast.makeText(contexto, "Foi banido!", Toast.LENGTH_SHORT).show();
        } else if(v.getId() == listarBan.getId()){
            listarBanidos(true);
        } else if(v.getId() == listarHoje.getId()){
            listarBanidos(false);
        } else if(v.getId() == btPatente.getId()){
            //
        }
    }

    public void listarBanidos(boolean total){
        Dialog dialogBanidos = new Dialog(getContext());//, R.style.dialogo_banidos);
        dialogBanidos.setTitle("Listagem de Banidos");
        dialogBanidos.setContentView(R.layout.lista_banidos);
        dialogBanidos.show();

    }

    public void patente(View v){
        //
    }
}
