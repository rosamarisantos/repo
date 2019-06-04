package com.example.rosa.noticias.fragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rosa.noticias.ComunicaFragment;
import com.example.rosa.noticias.Noticia;
import com.example.rosa.noticias.NoticiaAdapter;
import com.example.rosa.noticias.NoticiasBDService;
import com.example.rosa.noticias.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFavoritos extends Fragment {

    @BindView(R.id.listaFavoritos)
    ListView listView;
    private  Noticia noticia;
    private List<Noticia> listaNoticias=new ArrayList<>();
    private NoticiaAdapter noticiaAdapter;
    private ComunicaFragment callback;

    public FragmentFavoritos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_favoritos, container, false);
        listView = vista.findViewById(R.id.listaFavoritos);
        return vista;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Log.e("CONSUUUUU", "erooooooooooooooooooooooooooooooooooooooooooo");
        NoticiasBDService.getInstance().getNoticias(new NoticiasBDService.CallbackNoticiasFavoritos() {


            @Override
            public void onNoticias2(List<Noticia> noticias) {
                NoticiaAdapter noticiaAdapter = new NoticiaAdapter(getContext(), noticias);
                listView.setAdapter(noticiaAdapter);

            }

            @Override
            public void onNoticiasError2(String mensajeError) {
                Log.e("CONSUUUUU22", "222erooooooooooooooooooooooooooooooooooooooooooo");
            }

        });


    }
        @Override
    public void onAttach (Context context){
        super.onAttach(context);

    }

}
