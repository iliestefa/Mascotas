package com.example.ilian.findpetcom;

import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    public static List<Mascota> cargarMascotasEnAdopcion(){
        List <Mascota> lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tuti2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tuti3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tuti4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tuti2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tuti3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tuti4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tuti",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tuti2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tuti3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tuti4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        return lstMascotas;
    }

    public static List<Mascota> cargarMascotasPerdidas(){
        List <Mascota> lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Tu",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tu2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tu3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tu4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tu",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tu2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tu3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tu4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tu",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tu2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tu3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tu4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        return lstMascotas;
    }

    public static List<Mascota> cargarMascotasMias(){
        List <Mascota> lstMascotas=new ArrayList<>();
        lstMascotas.add(new Mascota("Tut",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tut2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tut3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tut4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tut",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tut2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tut3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tut4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        lstMascotas.add(new Mascota("Tut1",R.drawable.a,"Perro","Chiguagua",true,false));
        lstMascotas.add(new Mascota("Tut2",R.drawable.e,"Perro1","Chiguagua1",false,true));
        lstMascotas.add(new Mascota("Tut3",R.drawable.i,"Perro2","Chiguagua2",true,true));
        lstMascotas.add(new Mascota("Tut4",R.drawable.o,"Perro3","Chiguagua3",false,false));
        return lstMascotas;
    }
    public static List<Mascota> error(){
        return new ArrayList<Mascota>();
    }
}
