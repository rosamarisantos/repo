package com.example.rosa.noticias.fragmentos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rosa.noticias.R;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.rosa.noticias.Datasource;
import com.example.rosa.noticias.Noticia;
import com.example.rosa.noticias.NoticiaAdapter;
import com.example.rosa.noticias.retrofit.NoticiasBDRetrofit;

import java.util.ArrayList;
import java.util.List;

public class FargmentTercero extends Fragment {
    private ListView lvNoticia;
    private  Noticia noticia;
    private List<Noticia> listaNoticias=new ArrayList<>();
    private NoticiaAdapter noticiaAdapter;
    private SegundoEventoSeleccionado callback;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // this.callback = (OnEventoSeleccionado) context;
    }
    public FargmentTercero() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_tercero, container, false);
        // Bundle bundle = getArguments();
        //--- = (---) bundle.get("EVENTO");
        //  mooc();

        lvNoticia =vista.findViewById(R.id.listViewNoticia);
        NoticiasBDRetrofit.getInstance().getNoticias("marca", new Datasource.NoticiasCallback() {
            @Override
            public void onNoticiasCargadas(List<Noticia> noticias) {


                NoticiaAdapter noticiaAdapter=new NoticiaAdapter(getContext(),noticias);
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
                // callback.eventoSeleccionado(listaNoticias.get(position));
                // Toast.makeText(getContext(), ((Noticia) listaNoticias.get(position)).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

     /*   lvNoticia.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView titulo = view.findViewById(R.id.tvTitle);
                TextView autor= view.findViewById(R.id.tvAutor);
                Noticia noticia = new Noticia();
                noticia.setTitle(titulo.getText().toString());
                noticia.setAutor(autor.getText().toString());
                NoticiasAPI.getInstance().addNoticiaFavoritos(noticia, new NoticiasAPI.CallbackNoticia() {
                    @Override
                    public void onNoticia() {
                    }
                    @Override
                    public void onNoticiaError(String mensajeError) {
                    }

                });
                return false;
            }
        });

*/



        return vista;
    }
    public void mooc() {
        //  Noticia n1=new Noticia(1,"Mi noticia","https://trome.pe/actualidad/peppa-pig-espeluznante-imagen-rostro-visto-frente-fotos-81153", "url","Es fantástica esta noticia","14/01/2019");
        //  listaNoticias.add(n1);
    }
    public interface SegundoEventoSeleccionado {
        public void eventoDosSeleccionado(Noticia noticia);
    }
}