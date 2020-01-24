package com.example.ilian.findpetcom;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilian.findpetcom.Estructuras.RequestRegistrarMascota;
import com.example.ilian.findpetcom.RestApi.MetodosRest;
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.RazaMascota;
import com.example.ilian.findpetcom.modelo.TipoMascota;
import com.example.ilian.findpetcom.modelo.TipoMascota;
import java.util.ArrayList;
import java.util.List;

public class NuevaMascotavista {
    EditText nombre;
    AutoCompleteTextView tipo;
    AutoCompleteTextView raza;
    AutoCompleteTextView sexo;
    EditText edad;
    EditText descripcion;
    Button Aceptar;
    Button Cancelar;
    NuevaMascota c;
    Integer idUsuario;
    private SharedPreferences sharedPreferences;
    private List<TipoMascota> tiposObj;
    private List<String> tiposStr=  new ArrayList();
    private List<RazaMascota> razasObj;
    private List<String> razasStr=  new ArrayList();;
    private ProgressDialog barProgressDialog = null;

    public NuevaMascotavista(NuevaMascota c) {
        this.c=c;
        sharedPreferences = c.getSharedPreferences(VariablesGlobales.PREFERENCES, Context.MODE_PRIVATE);
        idUsuario = sharedPreferences.getInt("id_usuario", -1);
        this.nombre = (EditText) c.findViewById(R.id.txtNombre);
        this.tipo = (AutoCompleteTextView) c.findViewById(R.id.txtTipo);
        this.raza = (AutoCompleteTextView) c.findViewById(R.id.txtRaza);
        this.sexo =(AutoCompleteTextView) c.findViewById(R.id.txtSexo);
        this.edad = (EditText) c.findViewById(R.id.txtEdad);
        this.descripcion = (EditText) c.findViewById(R.id.txtDescripcion);
        Aceptar = (Button) c.findViewById(R.id.btnAceptar);
        Cancelar = (Button) c.findViewById(R.id.btnCancelar);
        barProgressDialog = new ProgressDialog(c);
        Aceptar.setEnabled(false);
        new ExecuteTaskListas().execute();
        acciones();

    }



    private void acciones() {
        final RequestRegistrarMascota request = new RequestRegistrarMascota();


                Aceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        request.descripcion = descripcion.getText().toString().trim();
                        if(request.descripcion.equals("")|| request.descripcion==null){
                            Toast.makeText(c, "Debe ingresar una descripcion valida", Toast.LENGTH_LONG).show();
                            return;
                        }

                        request.dueno = idUsuario;
                        request.edad = edad.getText().toString().trim();
                        if(request.edad.equals("")|| request.edad==null){
                            Toast.makeText(c, "Debe ingresar una edad valida", Toast.LENGTH_LONG).show();
                            return;
                        }

                        request.estado = 2;
                        Log.e("genero",sexo.getText().toString().trim().toLowerCase());
                        if(!sexo.getText().toString().trim().toLowerCase().equals("macho")&&!sexo.getText().toString().trim().toLowerCase().equals("hembra")){
                            Toast.makeText(c, "Debe Seleccionar un genero valido: Macho o Hembra", Toast.LENGTH_LONG).show();
                            return;
                        }
                        request.genero = (sexo.getText().toString().equals("Macho")?"M":"h");
                        int idxraza = razasStr.indexOf(raza.getText().toString().trim());
                        if(idxraza==-1){
                            Toast.makeText(c, "Debe Seleccionar una Raza valida", Toast.LENGTH_LONG).show();
                            return;
                        }
                        request.raza = razasObj.get(idxraza).id_raza;

                        int idxtipo = tiposStr.indexOf(tipo.getText().toString().trim());
                        if(idxtipo==-1){
                            Toast.makeText(c, "Debe Seleccionar una Tipo valido", Toast.LENGTH_LONG).show();
                            return;
                        }
                        request.tipo = tiposObj.get(idxtipo).id_tipo_mascota;


                        request.nombre = nombre.getText().toString().trim();
                        if(request.nombre.equals("")||request.nombre==null){
                            Toast.makeText(c, "Debe Ingresar un Nombre valido", Toast.LENGTH_LONG).show();
                            return;
                        }

                        new ExecuteTaskRegistrarMascota().execute(request);


                    }
                });

        Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.finish();

            }
        });
    }

    public EditText getNombre() {
        return nombre;
    }

    public void setNombre(EditText nombre) {
        this.nombre = nombre;
    }

    public AutoCompleteTextView getTipo() {
        return tipo;
    }

    public void setTipo(AutoCompleteTextView tipo) {
        this.tipo = tipo;
    }

    public AutoCompleteTextView getRaza() {
        return raza;
    }

    public void setRaza(AutoCompleteTextView raza) {
        this.raza = raza;
    }

    public AutoCompleteTextView getSexo() {
        return sexo;
    }

    public void setSexo(AutoCompleteTextView sexo) {
        this.sexo = sexo;
    }

    public EditText getEdad() {
        return edad;
    }

    public void setEdad(EditText edad) {
        this.edad = edad;
    }

    public EditText getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(EditText descripcion) {
        this.descripcion = descripcion;
    }

    public Button getAceptar() {
        return Aceptar;
    }

    public void setAceptar(Button aceptar) {
        Aceptar = aceptar;
    }

    public Button getCancelar() {
        return Cancelar;
    }

    public void setCancelar(Button cancelar) {
        Cancelar = cancelar;
    }



    class ExecuteTaskListas extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected void onPreExecute(){
            Toast.makeText(c, "Espere un momento mientras cargamos los datos necesarios", Toast.LENGTH_LONG).show();
        }


        @Override
        protected Boolean doInBackground(Void... params){
            tiposObj = MetodosRest.getAllTipos();
            razasObj = MetodosRest.getAllRazas();

            return tiposObj!=null && razasObj!=null;
        }

        @Override
        protected void onPostExecute(Boolean result){
            if(result){
                Metodos.generarListasParalelas(tiposObj,tiposStr,razasObj,razasStr);
                ArrayAdapter<String> tipoList=new ArrayAdapter<String>(c,R.layout.support_simple_spinner_dropdown_item,tiposStr);
                tipo.setAdapter(tipoList);
                ArrayAdapter<String> sexoList=new ArrayAdapter<String>(c,R.layout.support_simple_spinner_dropdown_item,new String[]{"Macho","Hembra"});
                sexo.setAdapter(sexoList);
                ArrayAdapter<String> razaList=new ArrayAdapter(c,R.layout.support_simple_spinner_dropdown_item,razasStr);
                raza.setAdapter(razaList);
                getAceptar().setEnabled(true);
                Toast.makeText(c, "Datos Cargados", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(c, "Error al cargar datos, vuelva a ingresar a la opcion", Toast.LENGTH_LONG).show();
            }

        }
    }


    class ExecuteTaskRegistrarMascota extends AsyncTask<RequestRegistrarMascota, Integer, Boolean>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            barProgressDialog.setTitle("Registrando Nueva Mascota");
            barProgressDialog.setMessage("Por favor espere...");
            barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            barProgressDialog.setCancelable(false);
            barProgressDialog.show();
        }

        @Override
        protected Boolean doInBackground(RequestRegistrarMascota... params){
            return MetodosRest.RegistrarMascotas(params[0]);
        }

        @Override
        protected void onPostExecute(Boolean result){
            barProgressDialog.dismiss();
            if(result){
                descripcion.setText("");
                edad.setText("");
                nombre.setText("");
                sexo.setText("");
                tipo.setText("");
                raza.setText("");
                Toast.makeText(c, "Mascota Registrada", Toast.LENGTH_LONG).show();


            }
            else{
                Toast.makeText(c, "Error al registrar Mascota", Toast.LENGTH_LONG).show();

            }
        }



    }



}
