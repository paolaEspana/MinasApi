package com.example.paola.minasapi;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

public class MinaFragment extends Fragment
{
    private FragmentActivity myContext;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    public String linea;

    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }
}
