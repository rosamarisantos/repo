package com.example.rosa.noticias.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rosa.noticias.ComunicaFragment;
import com.example.rosa.noticias.Datasource;
import com.example.rosa.noticias.Noticia;
import com.example.rosa.noticias.NoticiaAdapter;
import com.example.rosa.noticias.R;
import com.example.rosa.noticias.retrofit.NoticiasBDRetrofit;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentPrimero extends Fragment {
    private ListView lvNoticia;
    private  Noticia noticia;
    private List<Noticia> listaNoticias=new ArrayList<>();
    private NoticiaAdapter noticiaAdapter;
    private ComunicaFragment callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicaFragment)
            this.callback = (ComunicaFragment) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public FragmentPrimero() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_primero, container, false);

        lvNoticia = vista.findViewById(R.id.listViewNoticia);
        NoticiasBDRetrofit.getInstance().getNoticias("el-mundo", new Datasource.NoticiasCallback() {
            @Override
            public void onNoticiasCargadas(List<Noticia> noticias) {
                NoticiaAdapter noticiaAdapter = new NoticiaAdapter(getContext(), noticias);
                lvNoticia.setAdapter(noticiaAdapter);
                noticiaAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNoticiasError() {

            }
        });


        lvNoticia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getContext(), "Es la ------------" +position, Toast.LENGTH_SHORT).show();
                callback.pasarNoticia(listaNoticias.get(position));
            }
        });


        return vista;
    }



}