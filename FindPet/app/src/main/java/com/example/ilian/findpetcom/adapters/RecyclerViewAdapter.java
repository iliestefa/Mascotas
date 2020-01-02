package com.example.ilian.findpetcom.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContex;
    List<Mascota> mData;
    Dialog myDialog;


    public RecyclerViewAdapter(Context mContex, List<Mascota> mData) {
        this.mContex = mContex;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContex).inflate(R.layout.item_mascota,viewGroup,false);
        final MyViewHolder vHolder=new MyViewHolder(v);
        //DIALOG -----------------
        myDialog=new Dialog(mContex);
        myDialog.setContentView(R.layout.dialog_adoptar);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        vHolder.item_mascota.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                TextView dialog_nombre=(TextView) myDialog.findViewById(R.id.dialog_name);
                TextView dialog_desc=(TextView) myDialog.findViewById(R.id.dialog_descripcion);
                TextView dialog_tipo=(TextView) myDialog.findViewById(R.id.dialog_tipo);
                ImageView dialog_ima=(ImageView) myDialog.findViewById(R.id.dialog_ima);
                dialog_nombre.setText(mData.get(vHolder.getAdapterPosition()).getNombre());
                dialog_desc.setText(mData.get(vHolder.getAdapterPosition()).getDescripcion());
                String tipo=mData.get(vHolder.getAdapterPosition()).getAnimal()+"-"+mData.get(vHolder.getAdapterPosition()).getRaza();
                dialog_tipo.setText(tipo);
                dialog_ima.setImageResource(mData.get(vHolder.getAdapterPosition()).getFoto());
                Toast.makeText(mContex, "Test Click"+String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        }
        );

       return vHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_name.setText(mData.get(i).getNombre());
        myViewHolder.tv_tipo.setText(mData.get(i).getAnimal()+"-"+mData.get(i).getRaza());
        myViewHolder.tv_desc.setText(mData.get(i).getDescripcion());
        myViewHolder.img.setImageResource(mData.get(i).getFoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
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


        }
    }


}
