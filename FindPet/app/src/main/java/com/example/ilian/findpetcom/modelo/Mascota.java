package com.example.ilian.findpetcom.modelo;

import com.example.ilian.findpetcom.Datos;
import com.example.ilian.findpetcom.R;

public class Mascota {

    private Integer foto = R.drawable.a;
    private Integer id_mascota;
    private String  nombre;
    private String  genero;
    private String descripcion;
    private String edad;
    private Integer estado;
    private Integer dueno;
    private String  raza;
    private String  tipo;
    private Integer id_tipo_mascota;
    private Integer id_raza;
    private Integer id_usuario;
    private String cedula;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String correo;
    private String telefono;
    private String direccion;



    public Mascota(String nombre) {
        this.nombre = nombre;
    }



    public void setId_mascota(Integer id_mascota) {
        this.id_mascota = id_mascota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public void setDueno(Integer dueno) {
        this.dueno = dueno;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId_tipo_mascota(Integer id_tipo_mascota) {
        this.id_tipo_mascota = id_tipo_mascota;
    }

    public void setId_raza(Integer id_raza) {
        this.id_raza = id_raza;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getId_mascota() {
        return id_mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEdad() {
        return edad;
    }

    public Integer getEstado() {
        return estado;
    }

    public Integer getDueno() {
        return dueno;
    }

    public String getRaza() {
        return raza;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getId_tipo_mascota() {
        return id_tipo_mascota;
    }

    public Integer getId_raza() {
        return id_raza;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public String getCedula() {
        return cedula;
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

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
