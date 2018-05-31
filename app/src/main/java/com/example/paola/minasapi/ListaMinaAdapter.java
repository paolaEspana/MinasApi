package com.example.paola.minasapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.paola.minasapi.api.Mina;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class ListaMinaAdapter  extends RecyclerView.Adapter<ListaMinaAdapter.ViewHolder>
{
    private ArrayList<Mina> dataset;
    private Context context;
    private Mina mina;
    private ArrayList minas;
    private Integer postition1;

    public ListaMinaAdapter(Context context)
    {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mina, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull final ListaMinaAdapter.ViewHolder holder, final int position)
    {
        mina = dataset.get(position);
        Log.i("Posicionnnnnnnnnnnnnnnnnnnnnnn", ""+position);
        holder.anio.setText(mina.getAno());
        holder.departamento.setText(mina.getDepartamento());
        holder.municipio.setText(mina.getMunicipio());
        holder.sitio.setText(mina.getSitio());
        holder.tipoArea.setText(mina.getTipoarea());
        holder.estado.setText(mina.getTipoevento());

        holder.tarjetas.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v)
            {
                lanzarMapa(Double.valueOf(mina.getLongitudcabecera()),Double.valueOf(mina.getLatitudcabecera()),mina.getMunicipio());
            }
        });

        //holder.tarjetas.setOnClickListener(this);

        Glide.with(context);
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }

    public void adicionarMina(ArrayList<Mina> listaMina)
    {
        dataset.addAll(listaMina);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView tarjetas;
        private TextView anio;
        private TextView departamento;
        private TextView municipio;
        private TextView sitio;
        private TextView tipoArea;
        private TextView estado;
        private ImageButton mapa;

        public ViewHolder(View itemView)
        {
            super(itemView);

            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
            anio = (TextView) itemView.findViewById(R.id.txtAnioR);
            departamento = (TextView) itemView.findViewById(R.id.txtDepartamentoR);
            municipio = (TextView) itemView.findViewById(R.id.txtMunicipioR);
            sitio = (TextView) itemView.findViewById(R.id.txtSitioR);
            tipoArea = (TextView) itemView.findViewById(R.id.txtTipoAreaR);
            estado = (TextView) itemView.findViewById(R.id.txtEstadoR);
            mapa = (ImageButton) itemView.findViewById(R.id.ibMapa);
        }
    }

    public void lanzarMapa(Double longitud, Double latitud, String municipio)
    {
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra("longitud", longitud);
        intent.putExtra("latitud", latitud);
        intent.putExtra("ubicacion", municipio);
        Log.i("seeeeeeeeeeeeh",longitud + " " +latitud +" " +municipio);
        context.startActivity(intent);
    }
}
