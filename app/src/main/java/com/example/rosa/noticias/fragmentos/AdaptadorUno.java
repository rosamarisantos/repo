package com.example.rosa.noticias.fragmentos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AdaptadorUno extends FragmentStatePagerAdapter {

    private int numTab;

    public AdaptadorUno(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                FragmentCuarto cuarto = new FragmentCuarto();
                return cuarto;

            case 1:
                FragmentFavoritos favoritos = new FragmentFavoritos();
                return favoritos;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }

}


