package com.example.ilian.findpetcom.adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContex;
    List<Mascota> mData;


    public RecyclerViewAdapter(Context mContex, List<Mascota> mData) {
        this.mContex = mContex;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContex).inflate(R.layout.item_mascota,viewGroup,false);
        MyViewHolder vHolder=new MyViewHolder(v);

       return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(mData.get(i).getNombre());
        myViewHolder.tv_tipo.setText(mData.get(i).getAnimal());
        myViewHolder.tv_raza.setText(mData.get(i).getRaza());
        myViewHolder.img.setImageResource(mData.get(i).getFoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_raza;
        private TextView tv_tipo;
        private ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name=(TextView) itemView.findViewById(R.id.nombre);
            tv_raza=(TextView) itemView.findViewById(R.id.raza);
            tv_tipo=(TextView) itemView.findViewById(R.id.tipo);
            img=(ImageView) itemView.findViewById(R.id.img_mascota);


        }
    }


}
