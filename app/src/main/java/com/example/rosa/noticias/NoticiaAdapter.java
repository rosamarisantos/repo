package com.example.rosa.noticias;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticiaAdapter extends BaseAdapter {

    private Context context;
    private List<Noticia> noticias;

    public NoticiaAdapter(Context context, List<Noticia> noticias) {
        this.context = context;
        this.noticias = noticias;
    }

    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        Noticia noticia = noticias.get(i);

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.lista_intem, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.titulo.setText(noticia.getTitle());
        viewHolder.autor.setText(noticia.getAutor());
        viewHolder.fecha.setText(noticia.getPublishedAt());

        Glide.with(view)
                .load(noticia.getUrlToImage())
                .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                .into(viewHolder.imagen);

        return view;
    }

    public static class ViewHolder {
        @BindView(R.id.tvTitle)
        TextView titulo;
        @BindView(R.id.tvAutor)
        TextView autor;
        @BindView(R.id.tvFecha)
        TextView fecha;
        @BindView(R.id.imageViewPortada)
        ImageView imagen;

        public ViewHolder(View v) {
            ButterKnife.bind(this, v);
        }
    }
}

