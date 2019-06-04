package com.example.rosa.noticias;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NoticiasBDService {

    private NoticiasServiceAPI noticiasService;
    private static NoticiasBDService instance;

    private NoticiasBDService(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://192.168.17.156:3000/")
               // .baseUrl("http://192.168.43.113:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        noticiasService = retrofit.create(NoticiasServiceAPI.class);
    }

    public static NoticiasBDService getInstance(){
        if(instance == null){
            instance = new NoticiasBDService();
        }
        return instance;
    }
    public void getNoticias(final CallbackNoticiasFavoritos callbackNoticias){

        noticiasService.getNoticias().enqueue(new Callback<List<Noticia>>() {
            @Override
            public void onResponse(Call<List<Noticia>> call, Response<List<Noticia>> response) {
                List<Noticia> noticias = response.body();
                Log.e("Error", "onResponse: "+noticias);
                callbackNoticias.onNoticias2(noticias);
            }

            @Override
            public void onFailure(Call<List<Noticia>> call, Throwable t) {
                Log.e("Error", t.getMessage());
                callbackNoticias.onNoticiasError2(t.getMessage());
            }
        });
    }

    public void addNoticiaFavoritos(Noticia noticia, final CallbackNoticia callbackNoticia){

        noticiasService.addNoticiaFavoritos(noticia).enqueue(new Callback<Noticia>() {
            @Override
            public void onResponse(Call<Noticia> call, Response<Noticia> response) {

                callbackNoticia.onNoticia2();

            }

            @Override
            public void onFailure(Call<Noticia> call, Throwable t) {
                callbackNoticia.onNoticiaError2(t.getMessage());
            }
        });
    }

    public void deleteNoticiasFavoritos(String id, final CallbackBorraNoticiaFavoritos callbackBorrarFavoritas){
        noticiasService.deleteNoticiaFavoritos(id).enqueue(new Callback<Noticia>() {
            @Override
            public void onResponse(Call<Noticia> call, Response<Noticia> response) {
                callbackBorrarFavoritas.onDeleteNoticia();
            }

            @Override
            public void onFailure(Call<Noticia> call, Throwable t) {
                callbackBorrarFavoritas.onDeleteNoticiaError();
            }
        });
    }



    public interface CallbackNoticiasFavoritos {
        void onNoticias2(List<Noticia> noticias);
        void onNoticiasError2(String mensajeError);
    }

    public interface CallbackNoticia {
        void onNoticia2();
        void onNoticiaError2(String mensajeError);
    }

    public interface CallbackBorraNoticiaFavoritos {
        void onDeleteNoticia();
        void onDeleteNoticiaError();
    }

}
