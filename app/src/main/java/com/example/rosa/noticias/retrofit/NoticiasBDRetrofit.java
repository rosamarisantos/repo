package com.example.rosa.noticias.retrofit;
import com.example.rosa.noticias.APIConfig;
import com.example.rosa.noticias.Datasource;
import com.example.rosa.noticias.Noticia;
import com.example.rosa.noticias.NoticiasResponse;

import java.util.List;

import javax.sql.DataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.internal.Internal.instance;

public class NoticiasBDRetrofit implements Datasource {
    private static NoticiasBDRetrofit instance;
    NoticiasAPI api;

    NoticiasBDRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         api = retrofit.create(NoticiasAPI.class);
    }


    public static NoticiasBDRetrofit getInstance() {
        if (instance == null) {
            instance = new NoticiasBDRetrofit();
        }
        return instance;
    }
    public void getNoticias(String source, final Datasource.NoticiasCallback noticiasCallback) {
        Call<NoticiasResponse> call = api.getNoticias(source,APIConfig.APIKEY);
        call.enqueue(new Callback<NoticiasResponse>() {
            @Override
            public void onResponse(Call<NoticiasResponse> call, Response<NoticiasResponse> response) {
                NoticiasResponse noticiasResponse = response.body();
                List<Noticia> notis = noticiasResponse.getNoticias();
                noticiasCallback.onNoticiasCargadas(notis);
            }
            @Override
            public void onFailure(Call<NoticiasResponse> call, Throwable t) {
                noticiasCallback.onNoticiasError();
            }
        });

    }


    @Override
    public void getNoticia(int id, final NoticiaCallback noticiaCallback) {
        Call<Noticia> call = api.getNoticia(id, APIConfig.APIKEY);
        call.enqueue(new Callback<Noticia>() {
            @Override
            public void onResponse(Call<Noticia> call, Response<Noticia> response) {
                Noticia noticia = response.body();
                noticiaCallback.onNoticiaCargada(noticia);
            }
            @Override
            public void onFailure(Call<Noticia> call, Throwable t) {
                noticiaCallback.onNoticiaError();
            }
        });
    }


}
