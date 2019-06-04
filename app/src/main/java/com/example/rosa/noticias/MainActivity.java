package com.example.rosa.noticias;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.view.Menu;
import android.view.MenuItem;
import com.example.rosa.noticias.fragmentos.Adaptador;
import com.example.rosa.noticias.fragmentos.AdaptadorUno;
import com.example.rosa.noticias.fragmentos.FragmentCuarto;
import com.example.rosa.noticias.fragmentos.FragmentFavoritos;
import com.example.rosa.noticias.fragmentos.FragmentDetalle;
import com.example.rosa.noticias.fragmentos.FragmentPrimero;
import com.example.rosa.noticias.fragmentos.FragmenSegundo;
import com.example.rosa.noticias.fragmentos.FargmentTercero;
import com.example.rosa.noticias.fragmentos.FragmentDetalle.OnEventoSeleccionado;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private FragmentManager fm;
    private FragmentTransaction ft;
    ViewPager paginador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);
        paginador = (ViewPager) findViewById(R.id.contenedor1);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        verLista();

    }

    public void verLista(){

        final TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("EL MUNDO");
        primerTab.setIcon(R.drawable.elmundo);
        tabLayout.addTab(primerTab);

        final TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("CNN Spanish");
        segundoTab.setIcon(R.drawable.elcnn);
        tabLayout.addTab(segundoTab);

        final TabLayout.Tab terceroTab = tabLayout.newTab();
        terceroTab.setText("MARCA");
        terceroTab.setIcon(R.drawable.elmarca);
        tabLayout.addTab(terceroTab);


        Adaptador adaptador = new Adaptador(getSupportFragmentManager(), tabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                paginador.setCurrentItem(tab.getPosition());
                Fragment fragment = null;

                switch (tab.getPosition()){
                    case 0:
                        fragment = new FragmentPrimero();
                        break;

                    case 1:
                        fragment = new FragmenSegundo();
                        break;

                    case 2:
                        fragment = new FargmentTercero();
                        break;



                }

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.contenedor, fragment);
                ft.commit();

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void verFavoritos(){

        final TabLayout.Tab primerTab = tabLayout.newTab();
        primerTab.setText("ACTUALIDAD");
        primerTab.setIcon(R.drawable.actualidad);
        tabLayout.addTab(primerTab);

        final TabLayout.Tab segundoTab = tabLayout.newTab();
        segundoTab.setText("FAVORITOS");
        segundoTab.setIcon(R.drawable.favorito);
        tabLayout.addTab(segundoTab);



        AdaptadorUno adaptador = new AdaptadorUno(getSupportFragmentManager(), tabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));




        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                paginador.setCurrentItem(tab.getPosition());
                Fragment fragment = null;

                switch (tab.getPosition()){


                    case 0:
                        fragment = new FragmentCuarto();
                        break;


                    case 1:
                        fragment = new FragmentFavoritos();
                        break;


                }

                fm = getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.contenedor, fragment);
                ft.commit();

            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.lista) {
            tabLayout.removeAllTabs();
            paginador.removeAllViews();
            verLista();
            return true;
        }

        if (id == R.id.favoritos) {
            tabLayout.removeAllTabs();
            paginador.removeAllViews();
            verFavoritos();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    public void cambiarFragmento(Fragment fragmento) {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.contenedor, fragmento);
        FT.addToBackStack("jmr");
        FT.commit();
    }


    public void eventoSeleccionado(Noticia noticia) {
        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable("EVENTO", noticia);
        fragmentDetalle.setArguments(bundle);
        cambiarFragmento(fragmentDetalle);
    }
    */

}


