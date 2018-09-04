package com.dreambrunomsn.deathknight.classes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Context;
import com.dreambrunomsn.deathknight.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dream on 11/08/2018.
 */

public class TabAdapterAdm extends FragmentPagerAdapter {

    private List<String> listaTitulos = new ArrayList<>();
    private List<Fragment> listaFragments = new ArrayList<>();
    private Context contexto;

    public TabAdapterAdm(FragmentManager fm, Context context) {
        super(fm);

        contexto = context;

        listaTitulos.add(context.getString(R.string.usuario));
        listaFragments.add(new FragmentUsuario());

        listaTitulos.add(context.getString(R.string.uniforme));
        listaFragments.add(new FragmentUniforme());
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentUsuario usuario = new FragmentUsuario();
                return usuario;
            case 1:
                FragmentUniforme uniforme = new FragmentUniforme();
                return uniforme;
        }
        return null;
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position){
        return listaTitulos.get(position);
    }
}
