package com.dreambrunomsn.deathknight.classes;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dreambrunomsn.deathknight.R;
import com.dreambrunomsn.deathknight.banco.DatabaseAcao;
import com.dreambrunomsn.deathknight.banco.TestePatenteVo;
import com.dreambrunomsn.deathknight.utilitario.Mascara;

import java.util.List;

/**
 * Created by Dream on 11/08/2018.
 */

public class FragmentUsuario extends Fragment implements OnClickListener{

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
            testePatente();
        }
    }

    public void listarBanidos(boolean total){
        Dialog dialogBanidos = new Dialog(getContext());//, R.style.dialogo_banidos);
        dialogBanidos.setTitle("Listagem de Banidos");
        dialogBanidos.setContentView(R.layout.lista_banidos);
        dialogBanidos.show();
    }

    public void testePatente(){
        DatabaseAcao dba = new DatabaseAcao(getContext());
        List<TestePatenteVo> teste = dba.getTestePatente();
        String[] adms = new String[]{"ADM Responsável", "Richard", "Stephen", "Conrado"};

        Dialog dialogoPatente = new Dialog(getContext());
        dialogoPatente.setContentView(R.layout.opcoes_patentes);

        Button aplicar = (Button) dialogoPatente.findViewById(R.id.btPatenteAplicar);
        Button criar = (Button) dialogoPatente.findViewById(R.id.btPatenteCriar);
        Button finalizar = (Button) dialogoPatente.findViewById(R.id.btPatenteFinalizar);
        Button editar = (Button) dialogoPatente.findViewById(R.id.btPatenteEditar);
        Button salvar = (Button) dialogoPatente.findViewById(R.id.btPatenteSalvar);

        final EditText data = (EditText) dialogoPatente.findViewById(R.id.etxDataTeste);
        data.addTextChangedListener(Mascara.mask(data, Mascara.FORMAT_DATE));

        final LinearLayout llAplicar = (LinearLayout) dialogoPatente.findViewById(R.id.llAplicar);
        final LinearLayout llCriar = (LinearLayout) dialogoPatente.findViewById(R.id.llCriar);

        Spinner spAdm = (Spinner) dialogoPatente.findViewById(R.id.spAdm);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, adms);
        spAdm.setAdapter(adapter);


        salvar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto, Mascara.validaData(data.getText().toString()), Toast.LENGTH_SHORT).show();
            }
        });

        if(teste == null){
            aplicar.setEnabled(false);
            finalizar.setEnabled(false);
            editar.setEnabled(false);
            llCriar.setVisibility(View.VISIBLE);
        }else {
            aplicar.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (llAplicar.getVisibility() == View.VISIBLE) {
                        llAplicar.setVisibility(View.GONE);
                    } else {
                        llAplicar.setVisibility(View.VISIBLE);
                    }
                }
            });

            criar.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(llCriar.getVisibility() == View.VISIBLE){
                        llCriar.setVisibility(View.GONE);
                    } else{
                        llCriar.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        dialogoPatente.setTitle(getString(R.string.testePatente));
        dialogoPatente.show();
    }
}
