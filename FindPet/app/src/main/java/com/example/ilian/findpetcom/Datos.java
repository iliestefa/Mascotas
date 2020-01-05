package com.example.ilian.findpetcom;

import android.content.Context;

import com.example.ilian.findpetcom.adapters.ViewPagerAdapter;
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    public static Usuario  user;
    public static List<Mascota> mascotas;
    public static List<Usuario> users;
    public static  ViewPagerAdapter adapter;
    public static List<Mascota> masPerdidas;
    public static List<Mascota> masAdopcion;
    public static Context contex;



    public static void cargarMascotas(){
        mascotas=new ArrayList<>();
        masPerdidas=new ArrayList<>();
        masAdopcion=new ArrayList<>();
        mascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false,"macho",1));
        mascotas.add(new Mascota("Fruti",R.drawable.e,"Perro","coloniza",true,false,"hembra",2));
        mascotas.add(new Mascota("Mongo",R.drawable.i,"Gato","siberiano",true,false,"macho",2));
        mascotas.add(new Mascota("Tazon",R.drawable.o,"Conejo","negro",true,false,"hembra",1));
        mascotas.add(new Mascota("wISW",R.drawable.a,"serpiente","son",true,false,"macho",2));
        mascotas.add(new Mascota("Sero",R.drawable.e,"Cuy","cie",false,true,"macho",1));
        mascotas.add(new Mascota("Frodo",R.drawable.i,"Paloma","blanca",false,true,"hembra",2));
        mascotas.add(new Mascota("Mario",R.drawable.i,"lagarto","cafe",false,true,"hembra",1));
        mascotas.add(new Mascota("Mia",R.drawable.i,"Gato","Siames",false,false,"hembra",1));
        user.setMias(mascotas);
    }



    public static List<Usuario>   cargarUsers(){
        user =new Usuario("0956482632","Iliana Bolaños","ili","593998771032","34 y letamendi");
        Usuario u2=new Usuario("0988888888","Emily Fajardo","emi","593998771032","34 y letamendi");
        users=new ArrayList<>();
        users.add(user);
        users.add(u2);
        return users;
    }

    public static List<Mascota> cargarMascotasEnAdopcion(){

        for (Mascota m :mascotas){
            if (m.isAdoptada())masAdopcion.add(m);
        }
        return masAdopcion;
    }

    public static List<Mascota> cargarMascotasPerdidas(){

        for (Mascota m :mascotas){
            if (m.isPerdida())masPerdidas.add(m);
        }
        return masPerdidas;
    }

    public static List<Mascota> cargarMascotasMias(){
        return user.getMias();
    }


    public static List<Mascota> error(){
        return new ArrayList<Mascota>();
    }

    public static String datosString() {
        return "Mias: "+Datos.user.getMias()+
        "\nperdidas: "+Datos.masPerdidas+"\nadopcion: "+Datos.masAdopcion;
    }
}
