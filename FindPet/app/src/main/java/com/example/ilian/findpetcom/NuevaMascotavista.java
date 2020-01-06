package com.example.ilian.findpetcom;

import android.content.Context;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ilian.findpetcom.modelo.Mascota;

import java.util.ArrayList;

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

    public NuevaMascotavista(NuevaMascota c) {
        this.c=c;
        this.nombre = (EditText) c.findViewById(R.id.txtNombre);
        this.tipo = (AutoCompleteTextView) c.findViewById(R.id.txtTipo);
        this.raza = (AutoCompleteTextView) c.findViewById(R.id.txtRaza);
        this.sexo =(AutoCompleteTextView) c.findViewById(R.id.txtSexo);
        this.edad = (EditText) c.findViewById(R.id.txtEdad);
        this.descripcion = (EditText) c.findViewById(R.id.txtDescripcion);
        Aceptar = (Button) c.findViewById(R.id.btnAceptar);
        Cancelar = (Button) c.findViewById(R.id.btnCancelar);
        datos();
        acciones();
    }

    private void datos() {
        ArrayAdapter<String> tipoList=new ArrayAdapter<String>(c,R.layout.support_simple_spinner_dropdown_item,Datos.cargarDatosMasc());
        tipo.setAdapter(tipoList);
        ArrayAdapter<String> tipoList1=new ArrayAdapter<String>(c,R.layout.support_simple_spinner_dropdown_item,new String[]{"Macho","Hembra"});
        sexo.setAdapter(tipoList1);

    }

    private void acciones() {

        tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> tipoList1=new ArrayAdapter<String>(c,R.layout.support_simple_spinner_dropdown_item,Datos.animales.get(position).getRazas());
                raza.setAdapter(tipoList1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

                Aceptar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Mascota m = new Mascota(nombre.getText().toString(), descripcion.getText().toString(), R.drawable.i, tipo.getText().toString(), raza.getText().toString(), Integer.valueOf(edad.getText().toString()), sexo.getText().toString(), Datos.user);
                        Datos.user.getMias().add(m);
                        c.finish();
                        Metodos.actualizarTodo(c);
                        //  Toast toast1 =  Toast.makeText(c, "Mascota creada correctamente", Toast.LENGTH_SHORT);
                        // toast1.show();

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
}
