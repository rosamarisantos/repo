package com.example.rosa.noticias.retrofit;

import com.example.rosa.noticias.Noticia;
import com.example.rosa.noticias.NoticiasResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NoticiasAPI {

    @GET("everything")
    Call<NoticiasResponse> getNoticias(@Query("sources") String sources, @Query("apiKey") String apiKey);
    public Call<Noticia> getNoticia(@Path("sources/id") int id, @Query("api_key") String api_key);
}
