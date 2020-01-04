package com.example.ilian.findpetcom.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String cedula;
    private String nombre;
    private String pass;
    private String celular;
    private String direccion;
    private List<Mascota> mias;

    public Usuario(String cedula, String nombre, String pass, String celular, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.pass = pass;
        this.celular = celular;
        this.direccion = direccion;
        mias=new ArrayList<>();
    }



    public void addMascota(Mascota m){
        mias.add(m);

    }

    public List<Mascota> getMias() {
        return mias;
    }

    public void setMias(List<Mascota> mias) {
        this.mias = mias;
    }

    public void remove(Mascota m){
        mias.remove(m);

    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
