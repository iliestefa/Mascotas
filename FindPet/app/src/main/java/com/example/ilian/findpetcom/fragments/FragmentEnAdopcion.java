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

import com.example.ilian.findpetcom.Datos;
import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.adapters.RecyclerViewAdapter;
import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.ArrayList;
import java.util.List;


//SE CREA EL RECYCLER Y SE LE PASA LAS MASCOTAS
public class FragmentEnAdopcion extends Fragment {
    View v;
    private RecyclerView myReciclerview;
    private List<Mascota> lstMascotas;
    private int i;
    public FragmentEnAdopcion() {
    }


    //SE CREA LA LISTA
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switch (i){
            case 1:
                lstMascotas=Datos.cargarMascotasEnAdopcion();
                break;
            case 2:
                lstMascotas=Datos.cargarMascotasPerdidas();
                break;
            case 3:
                lstMascotas=Datos.cargarMascotasMias();
                break;
            default:
                lstMascotas=Datos.error();
                break;

        }

    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //SE CREA EL RECYCLER CON LA LISTA CREADA
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.adopcion_fragment,container,false);
        myReciclerview=(RecyclerView) v.findViewById(R.id.adopcion_recyclerview);
        RecyclerViewAdapter recyclerAdapter= new RecyclerViewAdapter(getContext(),lstMascotas,i);
        myReciclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myReciclerview.setAdapter(recyclerAdapter);
        return v;

    }
}
