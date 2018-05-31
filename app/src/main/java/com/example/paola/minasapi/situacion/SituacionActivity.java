package com.example.paola.minasapi.situacion;

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

import com.example.paola.minasapi.ListaMinaAdapter;
import com.example.paola.minasapi.R;
import com.example.paola.minasapi.Situacion;
import com.example.paola.minasapi.api.SituacionApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SituacionActivity extends Fragment
{
    private Retrofit retrofit;
    private RecyclerView recyclerView;
    private ListaSituacionAdapter listaSituacion;
    private boolean aptoParaCargar;
    final String TAG = "SITUACION_MINA";
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        final View view = inflater.inflate(R.layout.activity_main, container, false);

        retrofit = new Retrofit.Builder().baseUrl("https://www.datos.gov.co/resource/").addConverterFactory(GsonConverterFactory.create()).build();

        recyclerView = (RecyclerView) view.findViewById(R.id.reciclador);
        listaSituacion = new ListaSituacionAdapter(myContext);
        recyclerView.setAdapter(listaSituacion);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(myContext, 1);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy >0){
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if(aptoParaCargar) {
                        if ((visibleItemCount +pastVisibleItems ) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final");
                            aptoParaCargar = false;

                            procesarDatosSituacion();
                        }
                    }
                }
            }
        });


        aptoParaCargar = true;
        procesarDatosSituacion();
        return view;
    }

    private void procesarDatosSituacion()
    {
        SituacionApi service = retrofit.create(SituacionApi.class);

        Call<ArrayList<Situacion>> respuestaApi = service.obtenerLista();

        respuestaApi.enqueue(new Callback<ArrayList<Situacion>>()
        {
            @Override
            public void onResponse(Call<ArrayList<Situacion>> call, Response<ArrayList<Situacion>> response)
            {
                aptoParaCargar = true;
                ArrayList<Situacion>  situacion = response.body();
                listaSituacion.adicionarSituacion(situacion);
            }

            @Override
            public void onFailure(Call<ArrayList<Situacion>> call, Throwable t)
            {
                aptoParaCargar = true;
                Log.e(TAG," on Failure "+ t.getMessage());
            }
        });
    }
}
