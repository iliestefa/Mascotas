package com.example.ilian.findpetcom;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.telephony.PhoneNumberUtils;

import com.example.ilian.findpetcom.adapters.RecyclerViewAdapter;
import com.example.ilian.findpetcom.fragments.FragmentEnAdopcion;
import com.example.ilian.findpetcom.modelo.Usuario;

import java.util.List;

public class Metodos {

    public static void clicInfo(Dialog myDialog ){






    }

    public static void abrirWhatsapp(String telefono, Dialog myDialog) {
        Intent _intencion = new Intent("android.intent.action.MAIN");
        _intencion.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        _intencion.putExtra("jid", PhoneNumberUtils.stripSeparators(telefono)+"@s.whatsapp.net");
        myDialog.getContext().startActivity(_intencion);
    }


    public static void actualizarPerdidas(){
        //Datos.cargarMascotasPerdidas();
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(1)).getMyReciclerview().getAdapter().notifyDataSetChanged();
    }
    public static Usuario buscarUsuario(String text) {
        List<Usuario> lstUsers= Datos.cargarUsers();
        for (Usuario u : lstUsers){
            if (u.getCedula().equals(text)) return u;
        }
        return null;
    }

    public static void actualizarAdoptadas(Context c) {
        RecyclerViewAdapter recyclerAdapter= new RecyclerViewAdapter(c,Datos.masAdopcion,1);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(0)).getMyReciclerview().setAdapter(recyclerAdapter);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(0)).getMyReciclerview().getAdapter().notifyDataSetChanged();
    }

    public static void actualizarMias() {
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(2)).getMyReciclerview().getAdapter().notifyDataSetChanged();
    }

    public static void actualizarTodo(Context c){
        actualizarPerdidas();
        actualizarMias();
        actualizarAdoptadas(c);

    }

    public static void verListas(){


    }
}
