package com.example.paola.minasapi;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paola.minasapi.api.Mina;
import com.example.paola.minasapi.api.MinaApiService;
import com.example.paola.minasapi.api.SituacionApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Fragment
{

    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaMinaAdapter listaMina;
    private boolean aptoParaCargar;
    final String TAG = "MINA";
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_main, container, false);

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        recyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        listaMina = new ListaMinaAdapter(myContext);
        recyclerView.setAdapter(listaMina);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(myContext, 1);
        recyclerView.setLayoutManager(layoutManager);

        aptoParaCargar = true;

        procesarDatos();

        return view;
    }

    private void procesarDatos()
    {
        MinaApiService service = retrofit.create(MinaApiService.class);

        Call<ArrayList<Mina>> respesutaApi = service.obtenerLista();

        respesutaApi.enqueue(new Callback<ArrayList<Mina>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Mina>> call, Response<ArrayList<Mina>> response) {
                if (response.isSuccessful())
                {
                    aptoParaCargar = true;
                    ArrayList<Mina>  minas = response.body();

                    listaMina.adicionarMina(minas);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Mina>> call, Throwable t) {
                aptoParaCargar = true;
                Log.e(TAG," on Failure "+ t.getMessage());
            }
        });
    }
}
