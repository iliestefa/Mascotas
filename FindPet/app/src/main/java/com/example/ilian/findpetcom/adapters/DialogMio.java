package com.example.ilian.findpetcom.adapters;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilian.findpetcom.Datos;
import com.example.ilian.findpetcom.Metodos;
import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.Usuario;

public class DialogMio {
    Dialog myDialog;

    TextView dialog_nombre;
    TextView dialog_desc;
    TextView dialog_tipo;
    TextView dialog_sexedad;
    ImageView dialog_ima;
    Button whatsapp;
    Button info;


    public DialogMio(Context mContex) {
        myDialog = new Dialog(mContex);
        myDialog.setContentView(R.layout.dialog_adoptar);
        whatsapp = (Button) myDialog.findViewById(R.id.dialog_btn_adoptar);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_nombre = (TextView) myDialog.findViewById(R.id.dialog_name);
        dialog_desc = (TextView) myDialog.findViewById(R.id.dialog_descripcion);
        dialog_tipo = (TextView) myDialog.findViewById(R.id.dialog_tipo);
        dialog_sexedad = (TextView) myDialog.findViewById(R.id.dialog_sexedad);
        dialog_ima = (ImageView) myDialog.findViewById(R.id.dialog_ima);
        info = (Button) myDialog.findViewById(R.id.dialog_btn_info);
    }


    public void llenar(Mascota m) {

        String sexedad = m.getSexo() + " de " + m.getEdad() + " años";
        dialog_sexedad.setText(sexedad);
        dialog_nombre.setText(m.getNombre());
        dialog_desc.setText(m.getDescripcion());
        String tipo = m.getAnimal() + "-" + m.getRaza();
        dialog_tipo.setText(tipo);
        dialog_ima.setImageResource(m.getFoto());


    }

    public void accionesNormales(final Mascota mascota){

        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                llenarUser(mascota.getDueno());
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Metodos.abrirWhatsapp(mascota.getDueno().getCelular(),myDialog);
            }
        });


    }
    //Dialog que sale cuando esta en la seccion de mis mascotas
    public void dialogMias(Mascota m) {
        final Mascota m2 = m;
        if (m.isPerdida()) info.setText("Encontrada");
        else info.setText("Reportar Perdida");

        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (info.getText().equals("Encontrada")) m2.setPerdida(false);
                else m2.setPerdida(true);
            }
        });
        if (m.isAdoptada()) whatsapp.setText("Asignar Dueño");
        else whatsapp.setText("Poner en Adopción");

        whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (whatsapp.getText().equals("Asignar Dueño")) m2.setAdoptada(false);
                else m2.setAdoptada(true);
            }
        });
    }

    public void llenarUser(final Usuario user){
        DialogMio d=new DialogMio(myDialog.getContext());
        d.dialog_ima.setImageResource(R.drawable.user);
        d.dialog_nombre.setText(user.getNombre());
        d.dialog_desc.setText("                        +"+user.getCelular()+"                        ");
        d.dialog_tipo.setText(user.getDireccion());
        d.dialog_sexedad.setHeight(0);

        d.whatsapp.setText("Contactar");
        d.info.setText("");
        d.info.setVisibility(View.INVISIBLE);
        d.info.setMaxHeight(0);
        d.info.setHeight(0);
        d.myDialog.show();

        d.whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Metodos.abrirWhatsapp(user.getCelular(),myDialog);
            }
        });


    }


    //GETTERS AND SETTERS-----------------------------------------------------------------------------------------------


    public Dialog getMyDialog() {
        return myDialog;
    }

    public void setMyDialog(Dialog myDialog) {
        this.myDialog = myDialog;
    }

    public TextView getDialog_nombre() {
        return dialog_nombre;
    }

    public void setDialog_nombre(TextView dialog_nombre) {
        this.dialog_nombre = dialog_nombre;
    }

    public TextView getDialog_desc() {
        return dialog_desc;
    }

    public void setDialog_desc(TextView dialog_desc) {
        this.dialog_desc = dialog_desc;
    }

    public TextView getDialog_tipo() {
        return dialog_tipo;
    }

    public void setDialog_tipo(TextView dialog_tipo) {
        this.dialog_tipo = dialog_tipo;
    }

    public TextView getDialog_sexedad() {
        return dialog_sexedad;
    }

    public void setDialog_sexedad(TextView dialog_sexedad) {
        this.dialog_sexedad = dialog_sexedad;
    }

    public ImageView getDialog_ima() {
        return dialog_ima;
    }

    public void setDialog_ima(ImageView dialog_ima) {
        this.dialog_ima = dialog_ima;
    }

    public Button getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Button whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Button getInfo() {
        return info;
    }

    public void setInfo(Button info) {
        this.info = info;
    }
}