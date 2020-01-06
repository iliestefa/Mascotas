package com.example.ilian.findpetcom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NuevaMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_mascota);
        NuevaMascotavista vista=new NuevaMascotavista(this);

    }
}
