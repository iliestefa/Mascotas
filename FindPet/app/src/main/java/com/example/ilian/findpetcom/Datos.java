package com.example.ilian.findpetcom;

import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    public static Usuario  user;


    public static void cargarUsers(){
        user =new Usuario("0956482632","Iliana Bolaños","ili","0998771032","34 y letamendi");
        Usuario u2=new Usuario("0988888888","Emily Fajardo","emi","0998771032","34 y letamendi");
        user.setMias(cargarMascotasEnAdopcion());



    }

    public static List<Mascota> cargarMascotasEnAdopcion(){
        List <Mascota> lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false,"macho",1));
        lstMascotas.add(new Mascota("Fruti",R.drawable.e,"Perro","coloniza",true,false,"hembra",2));
        lstMascotas.add(new Mascota("Mongo",R.drawable.i,"Gato","siberiano",true,false,"macho",2));
        lstMascotas.add(new Mascota("Tazon",R.drawable.o,"Conejo","negro",true,false,"hembra",1));
        lstMascotas.add(new Mascota("wISW",R.drawable.a,"serpiente","son",true,false,"macho",2));

        return lstMascotas;
    }

    public static List<Mascota> cargarMascotasPerdidas(){
        List <Mascota> lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Sero",R.drawable.e,"Cuy","cie",true,true,"macho",1));
        lstMascotas.add(new Mascota("Frodo",R.drawable.i,"Paloma","blanca",true,true,"hembra",2));


        return lstMascotas;
    }

    public static List<Mascota> cargarMascotasMias(){
        List <Mascota> lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false,"macho",1));
        lstMascotas.add(new Mascota("Fruti",R.drawable.e,"Perro","coloniza",true,false,"hembra",2));
        lstMascotas.add(new Mascota("Mongo",R.drawable.i,"Gato","siberiano",true,false,"macho",2));
        lstMascotas.add(new Mascota("Tazon",R.drawable.o,"Conejo","negro",true,false,"hembra",1));
        lstMascotas.add(new Mascota("wISW",R.drawable.a,"serpiente","son",true,false,"macho",2));
        lstMascotas.add(new Mascota("Sero",R.drawable.e,"Cuy","cie",true,true,"macho",1));
        lstMascotas.add(new Mascota("Frodo",R.drawable.i,"Paloma","blanca",true,true,"hembra",2));

        return lstMascotas;
    }


    public static List<Mascota> error(){
        return new ArrayList<Mascota>();
    }
}
