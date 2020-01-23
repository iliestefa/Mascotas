package com.example.ilian.findpetcom.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ilian.findpetcom.R;


public class header extends Fragment {
    private SharedPreferences sharedPreferences;
    View a;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String primer_nomb = sharedPreferences.getString("primer_nombre","");
        String Seg_nomb = sharedPreferences.getString("segundo_nombre","");
        String primer_ape = sharedPreferences.getString("primer_apellido","");
        String seg_ape = sharedPreferences.getString("segundo_apellido","");
        String tlf = sharedPreferences.getString("telefono","");
        String dir = sharedPreferences.getString("direccion","");
        View a=inflater.inflate(R.layout.header,container,false);
        TextView nomb=(TextView)a.findViewById(R.id.txtHnombre);
        TextView dire=(TextView)a.findViewById(R.id.txtHdir);
        TextView tel=(TextView)a.findViewById(R.id.txttelefono);
        nomb.setText(primer_nomb+Seg_nomb+primer_ape+seg_ape);
        dire.setText(dir);
        tel.setText("+"+tlf);
        return inflater.inflate(R.layout.header, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event




}
