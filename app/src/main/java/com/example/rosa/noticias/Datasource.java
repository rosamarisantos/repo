package com.example.rosa.noticias;

import java.util.List;

public interface Datasource {
    public void getNoticias(String source, NoticiasCallback noticiasCallback);
    public void getNoticia(int id, NoticiaCallback noticiaCallback);

    interface NoticiaCallback {
        public void onNoticiaCargada(Noticia noticia);
        public void onNoticiaError();
    }
    interface NoticiasCallback {
        public void onNoticiasCargadas(List<Noticia> noticias);
        public void onNoticiasError();
    }
}
