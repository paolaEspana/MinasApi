package com.example.paola.minasapi.api;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MinaApiService
{
    @GET("644k-i2xw.json")
    Call<ArrayList<Mina>> obtenerLista();
}
