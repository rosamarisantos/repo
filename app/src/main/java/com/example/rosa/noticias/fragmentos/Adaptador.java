package com.example.rosa.noticias.fragmentos;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class Adaptador extends FragmentStatePagerAdapter {

    private int numTab;

    public Adaptador(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FragmentPrimero primero = new FragmentPrimero();
                return primero;

            case 1:
                FragmenSegundo segundo = new FragmenSegundo();
                return segundo;

            case 2:
                FargmentTercero tercero = new FargmentTercero();
                return tercero;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numTab;
    }

}


