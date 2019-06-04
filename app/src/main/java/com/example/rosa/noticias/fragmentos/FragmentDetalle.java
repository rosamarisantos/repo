package com.example.rosa.noticias.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rosa.noticias.Noticia;
import com.example.rosa.noticias.R;

import butterknife.BindView;

public class FragmentDetalle extends Fragment {

    @BindView(R.id.d_titulo)
    TextView titulo;
    @BindView(R.id.d_autor)
    TextView autor;
    @BindView(R.id.d_descripcion)
    TextView descripcion;
    @BindView(R.id.d_fecha)
    TextView fecha;
    @BindView(R.id.d_imagen)
    ImageView imagen;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
    public FragmentDetalle() {
            }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_detalle, container, false);



        return vista;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        Noticia noticia= (Noticia) bundle.get("EVENTO");
        setNoticia(noticia, view);


         }

    private void setNoticia(Noticia noticia, View view) {
        if (noticia != null) {
            titulo.setText(noticia.getTitle());
            autor.setText(noticia.getAutor());
            descripcion.setText(noticia.getDescription());
            fecha.setText(noticia.getPublishedAt());

            Glide.with(view)
                    .load(noticia.getUrlToImage())
                    .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                    .into(imagen);
        }
    }

    public interface OnEventoSeleccionado {
        public void eventoSeleccionado(Noticia noticia);
    }

}
