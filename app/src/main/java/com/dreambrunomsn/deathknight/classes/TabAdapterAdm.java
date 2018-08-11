package com.dreambrunomsn.deathknight.classes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dream on 11/08/2018.
 */

public class TabAdapterAdm extends FragmentPagerAdapter {

    List<String> listaTitulos = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();

    public TabAdapterAdm(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return listaTitulos.get(position);
    }
}
