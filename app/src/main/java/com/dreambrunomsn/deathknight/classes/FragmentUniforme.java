package com.dreambrunomsn.deathknight.classes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreambrunomsn.deathknight.R;

/**
 * Created by Dream on 11/08/2018.
 */

public class FragmentUniforme extends Fragment{

    private Context contexto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_uniforme, container, false);
    }

    public void setContext(Context context){
        this.contexto = context;
    }
}
