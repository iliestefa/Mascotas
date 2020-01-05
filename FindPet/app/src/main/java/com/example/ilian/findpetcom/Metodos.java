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
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.Usuario;

import java.util.ArrayList;
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


    public static void actualizarPerdidas(Context c,List<Mascota> ms){
        //Datos.cargarMascotasPerdidas();
        RecyclerViewAdapter recyclerAdapter= new RecyclerViewAdapter(c,ms,2);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(1)).getMyReciclerview().setAdapter(recyclerAdapter);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(1)).getMyReciclerview().getAdapter().notifyDataSetChanged();
    }
    public static Usuario buscarUsuario(String text) {
        List<Usuario> lstUsers= Datos.cargarUsers();
        for (Usuario u : lstUsers){
            if (u.getCedula().equals(text)) return u;
        }
        return null;
    }

    public static void actualizarAdoptadas(Context c, List<Mascota> ms) {
        RecyclerViewAdapter recyclerAdapter= new RecyclerViewAdapter(c,ms,1);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(0)).getMyReciclerview().setAdapter(recyclerAdapter);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(0)).getMyReciclerview().getAdapter().notifyDataSetChanged();
    }

    public static void actualizarMias(Context c,List<Mascota> ms) {
        RecyclerViewAdapter recyclerAdapter= new RecyclerViewAdapter(c,ms,3);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(2)).getMyReciclerview().setAdapter(recyclerAdapter);
        ((FragmentEnAdopcion)Datos.adapter.getListFragment().get(2)).getMyReciclerview().getAdapter().notifyDataSetChanged();
    }

    public static void actualizarTodo(Context c){
        actualizarPerdidas(c,Datos.masPerdidas);
        actualizarMias(c,Datos.user.getMias());
        actualizarAdoptadas(c, Datos.masAdopcion);
    }


    public static void filtrarPerdidas(Context c,String texto){
        actualizarPerdidas(c,filtrar(Datos.masPerdidas,texto));
    }
    public static void filtrarMias(Context c,String texto){
        actualizarMias(c,filtrar(Datos.user.getMias(),texto));
    }
    public static void filtrarAdopcion(Context c,String texto){
        actualizarAdoptadas(c,filtrar(Datos.masAdopcion,texto));
    }



    public static List<Mascota> filtrar(List<Mascota> mascotas,String texto){
        texto=texto.toLowerCase();
        List<Mascota> filtrada=new ArrayList<>();
        for (Mascota m: mascotas){
            if (m.getAnimal().toLowerCase().contains(texto)||m.getRaza().toLowerCase().contains(texto)
                    ||m.getNombre().toLowerCase().contains(texto)
                    ||m.getDueno().getNombre().toLowerCase().contains(texto)
                    ||("perdidas".contains(texto) &&m.isPerdida())
                    ||("adopcion".contains(texto) &&m.isAdoptada())){
                filtrada.add(m);
            }
        }
        return filtrada;
    }

}
