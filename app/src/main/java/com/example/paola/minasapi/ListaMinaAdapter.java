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
import java.util.List;

public class ListaMinaAdapter extends RecyclerView.Adapter <ListaMinaAdapter.AdapterViewHolder>
{
    private List<Mina> items;

    public static class AdapterViewHolder extends RecyclerView.ViewHolder{

        public View v;
        public Context c;
        private TextView anio;
        private TextView departamento;
        private TextView municipio;
        private TextView sitio;
        private TextView tipoArea;
        private TextView estado;
        private ImageButton mapa;
        private CardView tarjetas;

        public AdapterViewHolder(View v){
            super(v);
            c = v.getContext();
            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
            anio = (TextView) itemView.findViewById(R.id.txtAnioR);
            departamento = (TextView) itemView.findViewById(R.id.txtDepartamentoR);
            municipio = (TextView) itemView.findViewById(R.id.txtMunicipioR);
            sitio = (TextView) itemView.findViewById(R.id.txtSitioR);
            tipoArea = (TextView) itemView.findViewById(R.id.txtTipoAreaR);
            estado = (TextView) itemView.findViewById(R.id.txtEstadoR);
            mapa = (ImageButton) itemView.findViewById(R.id.ibMapa);
            this.v = v;
        }
    }

    public ListaMinaAdapter(List<Mina> items)
    {
        this.items=items;
    }
    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mina,parent,false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterViewHolder holder, final int position)
    {
        holder.anio.setText(items.get(position).getAno());
        holder.departamento.setText(items.get(position).getDepartamento());
        holder.municipio.setText(items.get(position).getMunicipio());
        holder.sitio.setText(items.get(position).getSitio());
        holder.tipoArea.setText(items.get(position).getTipoarea());
        holder.estado.setText(items.get(position).getTipoevento());
        holder.mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(holder.c, MapsActivity.class);
                intent.putExtra("longitud", Double.valueOf(items.get(position).getLongitudcabecera()));
                intent.putExtra("latitud", Double.valueOf(items.get(position).getLatitudcabecera()));
                intent.putExtra("ubicacion", items.get(position).getMunicipio());

                holder.c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void lanzarMapa(Double longitud, Double latitud, String municipio)
    {

    }



}
