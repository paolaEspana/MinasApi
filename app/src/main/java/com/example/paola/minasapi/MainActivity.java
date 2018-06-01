package com.example.paola.minasapi;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paola.minasapi.api.Mina;
import com.example.paola.minasapi.api.MinaApiService;
import com.example.paola.minasapi.api.SituacionApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Fragment {

    private FragmentActivity myContext;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private Retrofit retrofit;
    public String linea;

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        final List<Mina> lista = new ArrayList<Mina>();

        // Obtener el Recycler
        recycler = (RecyclerView) view.findViewById(R.id.reciclador);
        // Usar un administrador para LinearLayout
        recycler.setLayoutManager(new LinearLayoutManager(myContext));

        MinaApiService service = retrofit.create(MinaApiService.class);

        Call<ArrayList<Mina>> respesutaApi = service.obtenerLista();

        respesutaApi.enqueue(new Callback<ArrayList<Mina>>() {
            @Override
            public void onResponse(Call<ArrayList<Mina>> call, Response<ArrayList<Mina>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Mina> minas = response.body();

                    for (int i = 0; i < minas.size(); i++) {
                        Mina laMina = (Mina) minas.get(i);
                        Mina miMina = new Mina(laMina.getAno(),laMina.getCodigodanedepartamento(),laMina.getCodigodanemunicipio(),laMina.getDepartamento(),laMina.getEvento(),laMina.getLatitudcabecera(),laMina.getLongitudcabecera(),laMina.getMes(),laMina.getMunicipio(),laMina.getSitio(),laMina.getTipoarea(),laMina.getTipoevento(),laMina.getTipolugar());
                        lista.add(miMina);
                    }

                    adapter=new ListaMinaAdapter(lista);
                    recycler.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Mina>> call, Throwable t) {

                Log.e("MinasApp", " on Failure " + t.getMessage());
            }
        });



        return view;
    }


}

    /**private void procesarDatos()
    {
        MinaApiService service = retrofit.create(MinaApiService.class);

        Call<ArrayList<Mina>> respesutaApi = service.obtenerLista();

        respesutaApi.enqueue(new Callback<ArrayList<Mina>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Mina>> call, Response<ArrayList<Mina>> response) {
                if (response.isSuccessful())
                {

                    ArrayList<Mina> minas = response.body();

                    for(int i=0; i<minas.size(); i++)
                    {
                        Mina laMina = (Mina) minas.get(i);
                        lista.add(laMina);
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Mina>> call, Throwable t) {

                Log.e("MinasApp"," on Failure "+ t.getMessage());
            }
        });


    }*/

