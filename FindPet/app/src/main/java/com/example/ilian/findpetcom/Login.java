package com.example.ilian.findpetcom;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilian.findpetcom.Estructuras.RequestLogin;
import com.example.ilian.findpetcom.RestApi.MetodosRest;
import com.example.ilian.findpetcom.modelo.Usuario;

public class Login extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private ProgressDialog barProgressDialog = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Datos.cargarUsers();
        barProgressDialog = new ProgressDialog(this);
        sharedPreferences = getSharedPreferences(VariablesGlobales.PREFERENCES, Context.MODE_PRIVATE);
        Button iniciar =(Button)findViewById(R.id.btnIniciarSesion);
        final EditText usuario=(EditText) findViewById(R.id.txtUser);
        final EditText pass=(EditText) findViewById(R.id.txtPass);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString().trim();
                String password = pass.getText().toString().trim();
               // Log.e("user",user);
                new ExecuteTask().execute(user, password);

//                Usuario u=Metodos.buscarUsuario(usuario.getText( ).toString());
//                if( u!=null && u.getPass().equals(pass.getText().toString())){
//                    Datos.user=u;
//                    Datos.cargarMascotas();
//                    Datos.cargarMascotasEnAdopcion();
//                    Datos.cargarMascotasPerdidas();
//                    Intent log=new Intent(Login.this,Inicio.class);
//                    startActivity(log);
//                    finish();
//
//                }else{
//
//                    Toast toast1 =  Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT);
//                    toast1.show();
//                }


            }
        });





    }


    class ExecuteTask extends AsyncTask<String, Integer, Boolean> {


        private Usuario response;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barProgressDialog.setTitle("Verificando Datos");
            barProgressDialog.setMessage("Por favor espere...");
            barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            barProgressDialog.setCancelable(false);
            barProgressDialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {

            RequestLogin request = new RequestLogin();
            request.usuario = params[0];
            request.contrasena = params[1];

            response = MetodosRest.login(request);


            return response!=null;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            barProgressDialog.dismiss();
            if (result) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("usuario", response.getUsuario());
                editor.putString("contrasena", response.getContrasena());
                editor.putInt("id_usuario", response.getId_usuario());
                editor.putString("primer_nombre", response.getPrimer_nombre());
                editor.putString("segundo_nombre", response.getSegundo_nombre());
                editor.putString("primer_apellido", response.getPrimer_apellido());
                editor.putString("segundo_apellido", response.getSegundo_apellido());
                editor.putString("correo", response.getCorreo());
                editor.putString("telefono", response.getTelefono());
                editor.putString("direccion", response.getDireccion());
                editor.commit();

                Intent intent = new Intent(Login.this, Inicio.class);
                startActivity(intent);
                finish();

            } else {

                Toast.makeText(getApplicationContext(), "CREDENCIALES INCORRECTAS...", Toast.LENGTH_LONG).show();
            }
        }

    }



}
