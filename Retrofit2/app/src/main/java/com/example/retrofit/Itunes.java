package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Itunes {
   /* class Respuesta {
        List<Contenido> results;
    }

    class Contenido {
        String artistName;
        String trackName;
        String artworkUrl100;
    }*/

    class Respuesta {
        List<Contenido> documents;
    }

    class Contenido {
        Fields fields;
    }

    class Fields {
        Field descripcion;
        Field nombre;
        Field aspecto;
        intField edadMax;
    }

    class Field{
        String stringValue;
    }
    class intField{
        int integerValue;
    }

    public static Api api = new Retrofit.Builder()
            .baseUrl("https://firestore.googleapis.com/v1/projects/dnd-5-a8f22/databases/(default)/documents/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api.class);

    public interface Api {
        @GET("raza")
        Call<Respuesta> buscar();
    }

}
