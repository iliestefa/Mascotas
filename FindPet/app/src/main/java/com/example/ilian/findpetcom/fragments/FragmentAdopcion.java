package com.example.ilian.findpetcom.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.adapters.RecyclerViewAdapter;
import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdopcion extends Fragment {
    View v;
    private RecyclerView myReciclerview;
    private List<Mascota> lstMascotas;
    public FragmentAdopcion() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tuti2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tuti3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tuti4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tuti2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tuti3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tuti4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tuti2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tuti3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tuti4",R.drawable.o,"Perro3","Chiguagua3",false,false));


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.adopcion_fragment,container,false);
        myReciclerview=(RecyclerView) v.findViewById(R.id.adopcion_recyclerview);
        RecyclerViewAdapter recyclerAdapter= new RecyclerViewAdapter(getContext(),lstMascotas);
        myReciclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myReciclerview.setAdapter(recyclerAdapter);
        return v;

    }
}
