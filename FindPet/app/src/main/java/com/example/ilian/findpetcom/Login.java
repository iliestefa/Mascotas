package com.example.ilian.findpetcom;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilian.findpetcom.modelo.Usuario;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Datos.cargarUsers();

        Button iniciar =(Button)findViewById(R.id.btnIniciarSesion);
        final EditText usuario=(EditText) findViewById(R.id.txtUser);
        final EditText pass=(EditText) findViewById(R.id.txtPass);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u=Metodos.buscarUsuario(usuario.getText( ).toString());
                if( u!=null && u.getPass().equals(pass.getText().toString())){
                    Datos.user=u;
                    Datos.cargarMascotas();
                    Datos.cargarMascotasEnAdopcion();
                    Datos.cargarMascotasPerdidas();
                    Intent log=new Intent(Login.this,Inicio.class);
                    startActivity(log);
                    finish();

                }else{

                    Toast toast1 =  Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT);
                    toast1.show();
                }


            }
        });





    }



}
