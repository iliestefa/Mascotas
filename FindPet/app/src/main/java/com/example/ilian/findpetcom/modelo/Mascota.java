package com.example.ilian.findpetcom.modelo;

public class Mascota {

    private String nombre;
    private String descripcion;
    private int foto;
    private String animal;
    private String raza;
    private int edad;
    private String sexo;
    private boolean adoptada;
    private boolean perdida;



    public Mascota(String nombre) {
        this.nombre = nombre;
    }

    public Mascota(String nombre, int foto, String animal, String raza, boolean adoptada, boolean perdida) {
        this.nombre = nombre;
        this.foto = foto;
        this.animal = animal;
        this.raza = raza;
        this.adoptada = adoptada;
        this.perdida = perdida;
        descripcion="Es un cachorro lindo y jugueton, todo el dia pasa activo y no ladra mucho.";
    }

    public Mascota(String nombre, boolean adoptada, boolean perdida) {
        this.nombre = nombre;
        this.adoptada = adoptada;
        this.perdida = perdida;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isAdoptada() {
        return adoptada;
    }

    public void setAdoptada(boolean adoptada) {
        this.adoptada = adoptada;
    }

    public boolean isPerdida() {
        return perdida;
    }

    public void setPerdida(boolean perdida) {
        this.perdida = perdida;
    }

}
