package com.example.ilian.findpetcom.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private Integer id_usuario;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String usuario;
    private String contrasena;
    private String correo;
    private String telefono;

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

    public Usuario() {
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }



    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
