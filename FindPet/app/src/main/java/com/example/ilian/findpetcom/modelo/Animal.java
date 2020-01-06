package com.example.ilian.findpetcom.modelo;

import java.util.List;

public class Animal {
    String animal ;
    String[] razas;

    public Animal(String animal, String[] razas) {
        this.animal = animal;
        this.razas = razas;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String[] getRazas() {
        return razas;
    }

    public void setRazas(String[] razas) {
        this.razas = razas;
    }
}
