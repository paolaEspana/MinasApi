package com.example.paola.minasapi;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;

import com.example.paola.minasapi.situacion.SituacionActivity;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class InicioFragment extends Fragment{

    private FragmentActivity myContext;
    private CardView visualizar,zona,acercaDe,situacion;

    @Override
    public void onAttach(Activity activity)
    {
        myContext = (FragmentActivity) activity;

        super.onAttach(activity);
    }

    public InicioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.activity_inicio_fragment, container, false);
        visualizar = (CardView) view.findViewById(R.id.cvVisualizar);
        zona = (CardView) view.findViewById(R.id.cvZona);
        acercaDe = (CardView) view.findViewById(R.id.acercaDe);
        situacion = (CardView) view.findViewById(R.id.cvSituacion);

        visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                Class fragmentClass= MainActivity.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });

        situacion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fragment fragment = null;
                Class fragmentClass= SituacionActivity.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
            }
        });
        return view;

    }
}
