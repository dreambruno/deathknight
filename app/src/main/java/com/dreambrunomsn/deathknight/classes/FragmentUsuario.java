package com.dreambrunomsn.deathknight.classes;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dreambrunomsn.deathknight.R;
import com.dreambrunomsn.deathknight.banco.DatabaseAcao;
import com.dreambrunomsn.deathknight.banco.TestePatenteVo;
import com.dreambrunomsn.deathknight.utilitario.Data;
import com.dreambrunomsn.deathknight.utilitario.Mascara;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Dream on 11/08/2018.
 */

public class FragmentUsuario extends Fragment implements OnClickListener{

    private Button btBanir;
    private Button btPatente;

    private TextView listarBan;
    private TextView listarHoje;

    private Calendar diaTeste;

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

        diaTeste = Calendar.getInstance();

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btBanir.getId()){
            Toast.makeText(getContext(), "Foi banido!", Toast.LENGTH_SHORT).show();
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
        final DatabaseAcao dba = new DatabaseAcao(getContext());
        final List<TestePatenteVo> teste = dba.getTestePatente();
        final List<Usuario> adm = dba.getAdm();

        final int[] admCod = new int[adm.size() + 1];
        String[] admNome = new String[adm.size() + 1];
        int i = 0;

        admNome[i] = getString(R.string.admResponsavel);
        admCod[i] = 0;
        for(Usuario us : adm){
            i++;
            admNome[i] = us.getApelido();
            admCod[i] = us.getIdUsuario();
        }

        final Dialog dialogoPatente = new Dialog(getContext());
        dialogoPatente.setContentView(R.layout.dialog_patentes);

        Button aplicar = (Button) dialogoPatente.findViewById(R.id.btPatenteAplicar);
        Button criar = (Button) dialogoPatente.findViewById(R.id.btPatenteCriar);
        Button finalizar = (Button) dialogoPatente.findViewById(R.id.btPatenteFinalizar);
        Button editar = (Button) dialogoPatente.findViewById(R.id.btPatenteEditar);
        Button salvar = (Button) dialogoPatente.findViewById(R.id.btPatenteSalvar);
        final Button dataTeste = (Button) dialogoPatente.findViewById(R.id.btDataTeste);

        final LinearLayout llAplicar = (LinearLayout) dialogoPatente.findViewById(R.id.llAplicar);
        final LinearLayout llCriar = (LinearLayout) dialogoPatente.findViewById(R.id.llCriar);

        final Spinner spAdm = (Spinner) dialogoPatente.findViewById(R.id.spAdm);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, admNome);
        spAdm.setAdapter(adapter);


        dataTeste.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        diaTeste.set(year, month, dayOfMonth);
                        dataTeste.setText(Data.dataFormatada(diaTeste));
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), dateListener,
                        diaTeste.get(Calendar.YEAR),
                        diaTeste.get(Calendar.MONTH),
                        diaTeste.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        salvar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ok = true;
                if(spAdm.getSelectedItemPosition() == 0){
                    ok = false;
                    Toast.makeText(getContext(), getString(R.string.admResponsavel), Toast.LENGTH_SHORT).show();
                }
                if(true){
                    //ok = false;
                    System.out.println("dia " + Data.calendarToInt(diaTeste));
                }
                if(ok){
                    ContentValues cv = new ContentValues();
                    cv.put("ADM_RESPONSAVEL", admCod[spAdm.getSelectedItemPosition()]);
                    cv.put("DATA_TESTE", Data.calendarToInt(diaTeste));
                    try {
                        dba.criarTestePatente(cv);
                        dialogoPatente.dismiss();
                        //TODO: Abrir tela de edição do teste
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "Erro ao Salvar Teste!", Toast.LENGTH_SHORT).show();
                    }
                }
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

            editar.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    String t = "";
                    for(TestePatenteVo tv : dba.getTestePatente()){
                        t += "--> \n";
                        t += "DATA_CRIACAO: " + tv.getDataCriacao() + "\n";
                        t += "ADM_CRIACAO: " + tv.getAdmCriacao() + "\n";
                        t += "ID_TESTE: " + tv.getIdTeste() + "\n";
                        t += "DATA_TESTE: " + tv.getDataTeste() + "\n";
                        t += "ADM_RESPONSAVEL: " + tv.getAdmResponsavel() + "\n";
                        t += "ADM_CONDUTOR: " + tv.getAdmCondutor() + "\n";
                        t += "ABERTO: " + tv.isAtivo() + "\n";
                    }
                    System.out.println("\n TESTE: \n" + t);
                }
            });
        }

        dialogoPatente.setTitle(getString(R.string.testePatente));
        dialogoPatente.show();
    }
}
