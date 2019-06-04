package com.example.rosa.noticias;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import java.util.List;

import retrofit2.Call;

public interface NoticiasServiceAPI {
    @GET("noticias")
    Call<List<Noticia>> getNoticias();

    @POST("noticias")
    Call<Noticia> addNoticiaFavoritos(@Body Noticia noticia);

    @DELETE("noticias/{id}")
    Call<Noticia> deleteNoticiaFavoritos(@Path("id") String id);
}

