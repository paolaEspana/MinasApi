package com.example.paola.minasapi.api;

import com.example.paola.minasapi.Situacion;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SituacionApi
{
    @GET("c9ef-kn6i.json")
    Call<ArrayList<Situacion>> obtenerLista();
}
