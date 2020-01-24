package com.example.ilian.findpetcom.adapters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilian.findpetcom.Datos;
import com.example.ilian.findpetcom.Metodos;
import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.RestApi.MetodosRest;
import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.List;

//RECIBE LA LISTA DE MASCOTAS Y LAS PRESENTA EN EL RECYCLER

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContex;
    List<Mascota> mData;
    Dialog myDialog;
    DialogMio myDialo;
    int ind, user=-1;



    //CONSTRUNCTOR
    public RecyclerViewAdapter(Context mContex, List<Mascota> mData,int i) {
        this.mContex = mContex;
        this.mData = mData;
        ind=i;
    }


    //SE CREA LA VISTA
    @SuppressLint("RestrictedApi")
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v= LayoutInflater.from(mContex).inflate(R.layout.item_mascota,viewGroup,false);
        final MyViewHolder vHolder=new MyViewHolder(v);



        //SE CREA EL DIALOG -----------------
        myDialo=new DialogMio(mContex);
        myDialo.setRecycler(this);
        myDialo.setMyUser(getUser());
        //SE MUESTRA EL DIALOG AL HACER CLICK
        vHolder.item_mascota.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                myDialo.llenar(mData.get(vHolder.getAdapterPosition()));
                if (ind==1 || ind==2) myDialo.accionesNormales(mData.get(vHolder.getAdapterPosition()));
                if (ind==2)  myDialo.getWhatsapp().setText("Dar Info");
                if (ind==3) myDialo.dialogMias(mData.get(vHolder.getAdapterPosition()));
                myDialo.getMyDialog().show();
            }
        });
       return vHolder;
    }


    //SE COLOCAN LOS DATOS EN CADA  MASCOTA
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(mData.get(i).getNombre());
        myViewHolder.tv_tipo.setText(mData.get(i).getTipo()+"-"+mData.get(i).getRaza());
        myViewHolder.tv_desc.setText(mData.get(i).getDescripcion());
        if (ind==3) {
            if (mData.get(i).getEstado() == 0) {
                myViewHolder.tv_estado.setText("PERDIDA");
            } else if (mData.get(i).getEstado() == 1) {
                myViewHolder.tv_estado.setText("EN ADOPCIÓN");
            } else
                myViewHolder.tv_estado.setText("LIBRE");
            myViewHolder.img.setImageResource(R.drawable.a);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }










    //SE CREA EL FORMATO DE LA VISTA del recycler
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_estado;
        private TextView tv_desc;
        private TextView tv_tipo;
        private ImageView img;
        private LinearLayout item_mascota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_mascota=(LinearLayout) itemView.findViewById(R.id.mascota_item_id);
            tv_name=(TextView) itemView.findViewById(R.id.nombre);
            tv_desc=(TextView) itemView.findViewById(R.id.descripcion);
            tv_tipo=(TextView) itemView.findViewById(R.id.tipo);
            img=(ImageView) itemView.findViewById(R.id.img_mascota);
            tv_estado=(TextView) itemView.findViewById(R.id.txtestado);


        }
    }


    public Context getmContex() {
        return mContex;
    }

    public void setmContex(Context mContex) {
        this.mContex = mContex;
    }

    public List<Mascota> getmData() {
        return mData;
    }

    public void setmData(List<Mascota> mData) {
        this.mData = mData;
    }

    public Dialog getMyDialog() {
        return myDialog;
    }

    public void setMyDialog(Dialog myDialog) {
        this.myDialog = myDialog;
    }

    public DialogMio getMyDialo() {
        return myDialo;
    }

    public void setMyDialo(DialogMio myDialo) {
        this.myDialo = myDialo;
    }

    public int getInd() {
        return ind;
    }

    public void setInd(int ind) {
        this.ind = ind;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getUser() {
        return user;
    }




}
