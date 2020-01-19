package com.example.ilian.findpetcom.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.ilian.findpetcom.Datos;
import com.example.ilian.findpetcom.Metodos;
import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.RestApi.MetodosRest;
import com.example.ilian.findpetcom.adapters.RecyclerViewAdapter;
import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.ArrayList;
import java.util.List;


//SE CREA EL RECYCLER Y SE LE PASA LAS MASCOTAS
public class FragmentEnAdopcion extends Fragment {
    View v;
    private RecyclerView myReciclerview;
    private ProgressDialog barProgressDialog = null;
    private RecyclerViewAdapter recyclerAdapter;
    private List<Mascota> lstMascotas = new ArrayList();
    private Integer i, user=-1;
    public FragmentEnAdopcion() {
    }


    //SE CREA LA LISTA
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        barProgressDialog = new ProgressDialog(getContext());
//        switch (i){
//            case 1:
//                //lstMascotas=Datos.masAdopcion;
//                break;
//            case 2:
//                //lstMascotas=Datos.masPerdidas;
//                break;
//            case 3:
//                //lstMascotas=Datos.user.getMias();
//                break;
//            default:
//                lstMascotas=Datos.error();
//                break;
//
//        }
         new ExecuteTaskAllMmascota().execute("");

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
        recyclerAdapter= new RecyclerViewAdapter(getContext(),lstMascotas,i);
        myReciclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myReciclerview.setAdapter(recyclerAdapter);

        SearchView buscador=(SearchView)v.findViewById(R.id.buscador);
        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                new ExecuteTaskAllMmascota().execute(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                switch (i){
//                    case 1:
//
//                        //Metodos.filtrarAdopcion(getContext() ,newText);
//                        break;
//                    case 2:
//                        //Metodos.filtrarPerdidas(getContext(),newText);
//                        break;
//                    case 3:
//                       // Metodos.filtrarMias(getContext(),newText);
//                        break;
//                }
                return false;
            }
        });

        return v;

    }





    public View getV() {
        return v;
    }

    public void setV(View v) {
        this.v = v;
    }

    public RecyclerView getMyReciclerview() {
        return myReciclerview;
    }

    public void setMyReciclerview(RecyclerView myReciclerview) {
        this.myReciclerview = myReciclerview;
    }

    public List<Mascota> getLstMascotas() {
        return lstMascotas;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setLstMascotas(List<Mascota> lstMascotas) {
        this.lstMascotas = lstMascotas;
    }



    class ExecuteTaskAllMmascota extends AsyncTask<String, Integer, Boolean> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barProgressDialog.setTitle("Consultando Datos");
            barProgressDialog.setMessage("Por favor espere...");
            barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            barProgressDialog.setCancelable(false);
            barProgressDialog.show();
        }


        @Override
        protected Boolean doInBackground(String... params) {

            if(getI()==1){
                lstMascotas = MetodosRest.ConsultarAdopciones(params[0]);
            }
            else if(getI()==2){
                lstMascotas = MetodosRest.ConsultarPerdidas(params[0]);
            }
            else if(getI()==3 && getUser()!=-1){
                lstMascotas = MetodosRest.consultarMisMascota(getUser(),params[0]);
                recyclerAdapter.setUser(getUser());
            }

            return lstMascotas!=null;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            barProgressDialog.dismiss();
            if (result) {
                    recyclerAdapter.setmData(lstMascotas);
                    recyclerAdapter.notifyDataSetChanged();

            } else {

                Toast.makeText(getContext(), "Error...", Toast.LENGTH_LONG).show();
            }
        }

    }




}
