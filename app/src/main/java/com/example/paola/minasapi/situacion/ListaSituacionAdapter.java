package com.example.paola.minasapi.situacion;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.paola.minasapi.ListaMinaAdapter;
import com.example.paola.minasapi.R;
import com.example.paola.minasapi.Situacion;
import com.example.paola.minasapi.api.Mina;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListaSituacionAdapter extends RecyclerView.Adapter<ListaSituacionAdapter.ViewHolder>
{

    private ArrayList<Situacion> dataset;
    private Context context;
    private Situacion mina;

    public ListaSituacionAdapter(Context context)
    {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaSituacionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_situacion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaSituacionAdapter.ViewHolder holder, int position)
    {
        mina = dataset.get(position);
        holder.departamento.setText(mina.getDepartamento());
        holder.municipio.setText(mina.getMunicipio());
        holder.anio.setText(mina.getAno());
        holder.mes.setText(mina.getMes());
        holder.tipoDes.setText(mina.getTipodesminado());
        holder.totalMinas.setText(mina.getTotalartefactosdestruidos());
        holder.organizacion.setText(mina.getOrganizacion());

        Glide.with(context);
    }

    @Override
    public int getItemCount()
    {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private CardView tarjetas;
        private TextView departamento;
        private TextView municipio;
        private TextView anio;
        private TextView mes;
        private TextView tipoDes;
        private TextView totalMinas;
        private TextView organizacion;

        public ViewHolder(View itemView)
        {
            super(itemView);

            tarjetas = (CardView) itemView.findViewById(R.id.tarjetas);
            departamento = (TextView) itemView.findViewById(R.id.tvDeparamento);
            municipio = (TextView) itemView.findViewById(R.id.txtMunicipio);
            anio = (TextView) itemView.findViewById(R.id.txtanio);
            mes = (TextView) itemView.findViewById(R.id.tvmes);
            tipoDes = (TextView) itemView.findViewById(R.id.tvTipoDesminado);
            totalMinas = (TextView) itemView.findViewById(R.id.tvTotal);
            organizacion = (TextView) itemView.findViewById(R.id.tvOrganizacion);
        }
    }

    public void adicionarSituacion(ArrayList<Situacion> listaSituacion)
    {
        dataset.addAll(listaSituacion);
        notifyDataSetChanged();
    }
}
