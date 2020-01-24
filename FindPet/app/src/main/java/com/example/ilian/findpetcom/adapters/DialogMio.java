package com.example.ilian.findpetcom.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ilian.findpetcom.Datos;
import com.example.ilian.findpetcom.Estructuras.ResponseRealizaAdopcion;
import com.example.ilian.findpetcom.Metodos;
import com.example.ilian.findpetcom.R;
import com.example.ilian.findpetcom.RestApi.MetodosRest;
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.Usuario;

import java.util.List;

public class DialogMio {
    Dialog myDialog;
    private ProgressDialog barProgressDialog = null;
    TextView dialog_nombre;
    TextView dialog_desc;

    TextView dialog_tipo;
    TextView dialog_sexedad;
    ImageView dialog_ima;
    Button whatsapp;
    Button info;
    Button retirar;
    Context mContex;
    private Integer myUser;
    private RecyclerViewAdapter recycler;
    private AlertDialog.Builder builder;


    public DialogMio(Context mContex) {
        this.mContex = mContex;
        myDialog = new Dialog(mContex);
        builder = new AlertDialog.Builder(mContex);
        barProgressDialog = new ProgressDialog(mContex);
        myDialog.setContentView(R.layout.dialog_adoptar);
        whatsapp = (Button) myDialog.findViewById(R.id.dialog_btn_adoptar);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog_nombre = (TextView) myDialog.findViewById(R.id.dialog_name);

        dialog_desc = (TextView) myDialog.findViewById(R.id.dialog_descripcion);
        dialog_tipo = (TextView) myDialog.findViewById(R.id.dialog_tipo);
        dialog_sexedad = (TextView) myDialog.findViewById(R.id.dialog_sexedad);
        dialog_ima = (ImageView) myDialog.findViewById(R.id.dialog_ima);
        info = (Button) myDialog.findViewById(R.id.dialog_btn_info);
        retirar = (Button) myDialog.findViewById(R.id.dialog_btn_retirar);
    }


    public void llenar(Mascota m) {
        whatsapp.setEnabled(true);
        info.setEnabled(true);

        String sexedad = (m.getGenero()=="M"?"Macho":"Hembra") + " de " + m.getEdad() +" de Edad";
        dialog_sexedad.setText(sexedad);
        dialog_nombre.setText(m.getNombre());
        dialog_desc.setText(m.getDescripcion());
        String tipo = m.getTipo() + "-" + m.getRaza();
        dialog_tipo.setText(tipo);
        dialog_ima.setImageResource(R.drawable.a);
    }

    public void accionesNormales(final Mascota mascota){

        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                llenarUser(mascota);
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Metodos.abrirWhatsapp(mascota.getTelefono(),myDialog);
            }
        });


    }

    //Dialog que sale cuando esta en la seccion de mis mascotas
    public void dialogMias(final Mascota m2) {


        if (m2.getEstado()==0){
            info.setText("Encontrada");

            whatsapp.setEnabled(false);
        }else {
            info.setText("Reportar Perdida");
            whatsapp.setEnabled(true);
        }

        info.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myDialog.cancel();

                builder.setTitle("Confirmacion");
                builder.setMessage("Desea Registrar la Mascota como "+(info.getText().equals("Encontrada")?"Encontrada":"Perdida")+"?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new ExecuteTaskReportar(info.getText().equals("Encontrada")?3:1, m2.getId_mascota()).execute();
                        dialog.dismiss();

                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.setCancelable(false);
                builder.show();

            }
        });

        if (m2.getEstado()==1){

            whatsapp.setText("Asignar Dueño");
            info.setEnabled(false);
            retirar.setHeight(100);

        }else {
            whatsapp.setText("Poner en Adopción");
            info.setEnabled(true);

        }


        whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (whatsapp.getText().equals("Asignar Dueño")) {
                    Dialog dialogCed = new Dialog(myDialog.getContext());
                    dialogCed.setContentView(R.layout.dialognuevoduenio);
                    accionesAsignarDuenio(dialogCed,m2);
                    dialogCed.show();
                    myDialog.cancel();

                }
                else{


                    myDialog.cancel();

                    builder.setTitle("Confirmacion");
                    builder.setMessage("Desea Poner en Adopción esta Mascota?");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new ExecuteTaskReportar(2, m2.getId_mascota()).execute();
                            dialog.dismiss();

                        }
                    });

                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });
                    builder.setCancelable(false);
                    builder.show();

                }

            }
        });
    }

    private void accionesAsignarDuenio(final Dialog dialogCed, final Mascota m) {
        Button aceptar = (Button) dialogCed.findViewById(R.id.dialog_btn_aceptar);
        Button cancelar = (Button) dialogCed.findViewById(R.id.dialog_btn_cancelar);
        final EditText ced=(EditText) dialogCed.findViewById(R.id.cedula);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ced.getText().toString().trim().equals("")){
                    Toast.makeText(mContex, "Debe Ingresar una cedula valida", Toast.LENGTH_LONG).show();
                }
                else{
                    new ExecuteTaskRealizarAdopcion(m.getId_mascota(),ced.getText().toString().trim(),dialogCed).execute();
                }
            }
        });
        cancelar.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialogCed.cancel();

                builder.setTitle("Confirmacion");
                builder.setMessage("Desea quitar de la lista de Adopción esta Mascota?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        new ExecuteTaskReportar(4, m.getId_mascota()).execute();
                        dialog.dismiss();

                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                });
                builder.setCancelable(false);
                builder.show();


            }
        });


    }



    public void llenarUser(final Mascota mascota){
        DialogMio d=new DialogMio(myDialog.getContext());
        d.dialog_ima.setImageResource(R.drawable.user);
        d.dialog_nombre.setText(mascota.getPrimer_nombre()+" "+mascota.getSegundo_nombre()+" "+mascota.getPrimer_apellido()+" "+mascota.getSegundo_apellido());
        d.dialog_desc.setText("+"+ mascota.getTelefono());
        d.dialog_tipo.setText(mascota.getDireccion());
        d.dialog_sexedad.setHeight(0);

        d.whatsapp.setText("Contactar");
        d.info.setText("");
        d.info.setVisibility(View.INVISIBLE);
        d.info.setMaxHeight(0);
        d.info.setHeight(0);
        d.myDialog.show();

        d.whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Metodos.abrirWhatsapp(mascota.getTelefono(),myDialog);
            }
        });


    }


    public void llenarPerfil(SharedPreferences sharedPreferences){
        DialogMio d=new DialogMio(myDialog.getContext());
        d.dialog_ima.setImageResource(R.drawable.user);
        String primer_nomb = sharedPreferences.getString("primer_nombre","");
        String Seg_nomb = sharedPreferences.getString("segundo_nombre","");
        String primer_ape = sharedPreferences.getString("primer_apellido","");
        String seg_ape = sharedPreferences.getString("segundo_apellido","");
        final String tlf = sharedPreferences.getString("telefono","");
        String dir = sharedPreferences.getString("direccion","");

        d.dialog_nombre.setText(primer_nomb+" "+Seg_nomb+" "+primer_ape+ " "+seg_ape);
        d.dialog_desc.setText( tlf);
        d.dialog_tipo.setText(dir);
        d.dialog_sexedad.setHeight(0);

        d.whatsapp.setText("Contactar");
        d.info.setText("");
        d.info.setVisibility(View.INVISIBLE);
        d.info.setMaxHeight(0);
        d.info.setHeight(0);
        d.myDialog.show();

        d.whatsapp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Metodos.abrirWhatsapp(tlf,myDialog);
            }
        });


    }

    //GETTERS AND SETTERS-----------------------------------------------------------------------------------------------


    public Dialog getMyDialog() {
        return myDialog;
    }

    public void setMyDialog(Dialog myDialog) {
        this.myDialog = myDialog;
    }

    public TextView getDialog_nombre() {
        return dialog_nombre;
    }

    public void setDialog_nombre(TextView dialog_nombre) {
        this.dialog_nombre = dialog_nombre;
    }

    public TextView getDialog_desc() {
        return dialog_desc;
    }

    public void setDialog_desc(TextView dialog_desc) {
        this.dialog_desc = dialog_desc;
    }

    public TextView getDialog_tipo() {
        return dialog_tipo;
    }

    public void setDialog_tipo(TextView dialog_tipo) {
        this.dialog_tipo = dialog_tipo;
    }

    public TextView getDialog_sexedad() {
        return dialog_sexedad;
    }

    public void setDialog_sexedad(TextView dialog_sexedad) {
        this.dialog_sexedad = dialog_sexedad;
    }

    public ImageView getDialog_ima() {
        return dialog_ima;
    }

    public void setDialog_ima(ImageView dialog_ima) {
        this.dialog_ima = dialog_ima;
    }

    public Button getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Button whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Button getInfo() {
        return info;
    }

    public void setInfo(Button info) {
        this.info = info;
    }

    public void setRecycler(RecyclerViewAdapter recycler) {
        this.recycler = recycler;
    }

    public RecyclerViewAdapter getRecycler() {
        return recycler;
    }

    public void setMyUser(Integer myUser) {
        this.myUser = myUser;
    }

    public Integer getMyUser() {
        return myUser;
    }

    class ExecuteTaskRealizarAdopcion extends AsyncTask<Void, Integer, Boolean> {
        private Integer id_mascota;
        private String user;
        private ResponseRealizaAdopcion response;
        private Boolean result = false;
        private List<Mascota> listMascotas;
        private String msj;
        private Dialog dialogCed;

        public ExecuteTaskRealizarAdopcion(Integer id_mascota, String user, Dialog dialogCed){
            this.id_mascota = id_mascota;
            this.user = user;
            this.dialogCed = dialogCed;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barProgressDialog.setTitle("Registrando Cambio de Dueño");
            barProgressDialog.setMessage("Por favor espere...");
            barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            barProgressDialog.setCancelable(false);
            barProgressDialog.show();
        }


        @Override
        protected Boolean doInBackground(Void... params) {

            response = MetodosRest.RealizarAdopcion(user,id_mascota);
            if(response!=null){
                if(response.confirm){
                    listMascotas =  MetodosRest.consultarMisMascota(getMyUser(),"");

                    msj = response.log+(listMascotas==null?", pero No se pudo Actualiza la lista de mascotas":"");
                    return listMascotas!=null;
                }
                else{
                    msj = response.log;
                    return result;
                }

            }
            msj="No se pudo realizar el registro de la adopcion";
            return result;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            barProgressDialog.dismiss();
            dialogCed.cancel();
            if (result) {
                recycler.setmData(listMascotas);
                recycler.notifyDataSetChanged();

            }

            Toast.makeText(mContex, msj, Toast.LENGTH_LONG).show();
        }

    }



    class ExecuteTaskReportar extends AsyncTask<Void, Integer, Boolean>{
        private Integer opcion,id_mascota;

        private Boolean result = false;
        private List<Mascota> listMascotas;
        private String msj;


        public ExecuteTaskReportar(int opcion, Integer id_mascota){
            this.opcion = opcion;
            this.id_mascota = id_mascota;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            String title ="";
            if(opcion==2){
               title = "Registrando Mascota en Adopcion" ;
            }
            else if(opcion==1){
                title = "Registrando Mascota Perdida" ;
            }
            else if(opcion==3){
                title = "Registrando Mascota como Encontrada" ;
            }else{
                title = "Quitando a la mascota de la lista de Adopciones";
            }
            barProgressDialog.setTitle(title);
            barProgressDialog.setMessage("Por favor espere...");
            barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            barProgressDialog.setCancelable(false);
            barProgressDialog.show();

        }

        @Override
        protected Boolean doInBackground(Void... params){
            if(opcion==2){
                result = MetodosRest.RegistrarAdopcion(id_mascota);
            }
            else if(opcion==1){
                result = MetodosRest.ReportarMascotaPerdida(id_mascota);
            }
            else if(opcion==3){
                result = MetodosRest.ReportarMascotaEncontrada(id_mascota);
            }else{
                result = MetodosRest.CambiarEstadoMascota(id_mascota,2);
            }
            if(result){
                if(opcion==1){
                    msj ="La Mascota ha sido Reportada como Perdida";
                }
                else if(opcion ==2){
                    msj="La Mascota ha sido Puesta en Adopcion";
                }
                else if(opcion==3){
                    msj= "La Mascota ha sido Reportada como Encontrada";
                }
                else {
                    msj="La mascota ha sido quitada de la lista de Adopciones";
                }

                listMascotas =  MetodosRest.consultarMisMascota(getMyUser(),"");
                return listMascotas!=null;
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result){
            barProgressDialog.dismiss();

            if(result){
                recycler.setmData(listMascotas);
                recycler.notifyDataSetChanged();
            }
            Toast.makeText(mContex, msj+(result?"":", pero no se pudo actualizar la lista"), Toast.LENGTH_LONG).show();
        }


    }
}