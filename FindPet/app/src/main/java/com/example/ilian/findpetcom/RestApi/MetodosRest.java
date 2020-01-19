package com.example.ilian.findpetcom.RestApi;

import android.util.Log;

import com.example.ilian.findpetcom.Estructuras.RequestLogin;
import com.example.ilian.findpetcom.Estructuras.RequestConsultarMascotas;
import com.example.ilian.findpetcom.Estructuras.RequestRealizarAdopcion;
import com.example.ilian.findpetcom.Estructuras.RequestReportar;
import com.example.ilian.findpetcom.Estructuras.RequestRegistrarMascota;
import com.example.ilian.findpetcom.Estructuras.ResponseRealizaAdopcion;
import com.example.ilian.findpetcom.VariablesGlobales;
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.RazaMascota;
import com.example.ilian.findpetcom.modelo.TipoMascota;
import com.example.ilian.findpetcom.modelo.Usuario;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MetodosRest {


    public static Usuario login(RequestLogin request) {
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<Usuario> call = retrofitConn.login(request);
            Response<Usuario> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }
        } catch (Exception e) {
            Log.e("login", e.getMessage());
            return null;
        }
    }


    public static List<Mascota> getAll(){
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<List<Mascota>> call = retrofitConn.getAllMascotas();
            Response<List<Mascota>> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }

    public static List<Mascota> consultarMisMascota(Integer id, String busqueda){
        RequestConsultarMascotas request = new RequestConsultarMascotas();
        request.dueno = id;
        request.busqueda =busqueda;
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<List<Mascota>> call = retrofitConn.consultarMisMascotas(request);
            Response<List<Mascota>> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }


    public static List<Mascota> ConsultarAdopciones(String busqueda){
        RequestConsultarMascotas request = new RequestConsultarMascotas();
        request.busqueda =busqueda;
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<List<Mascota>> call = retrofitConn.ConsultarAdopciones(request);
            Response<List<Mascota>> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }

    public static List<Mascota> ConsultarPerdidas(String busqueda){
        RequestConsultarMascotas request = new RequestConsultarMascotas();
        request.busqueda =busqueda;
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<List<Mascota>> call = retrofitConn.ConsultarPerdidas(request);
            Response<List<Mascota>> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }


    public static ResponseRealizaAdopcion RealizarAdopcion(String user, Integer id_mascota){
        RequestRealizarAdopcion request = new RequestRealizarAdopcion();
        request.id_mascota = id_mascota;
        request.dueno = user;
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<ResponseRealizaAdopcion> call = retrofitConn.RealizarAdopcion(request);
            Response<ResponseRealizaAdopcion> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else if(res.code()==400) {
                Gson parser = new Gson();
                ResponseRealizaAdopcion error =parser.fromJson(res.errorBody().string(), ResponseRealizaAdopcion.class);
                return error;
            }
            else{
                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }


    public static List<TipoMascota> getAllTipos(){
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<List<TipoMascota>> call = retrofitConn.getAllTipos();
            Response<List<TipoMascota>> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }

    public static List<RazaMascota> getAllRazas(){
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<List<RazaMascota>> call = retrofitConn.getAllRazas();
            Response<List<RazaMascota>> res = call.execute();
            if (res.isSuccessful()) {
                return res.body();

            }else {

                return null;
            }

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }


    public static Boolean RegistrarMascotas(RequestRegistrarMascota request){

        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<Object> call = retrofitConn.RegistrarMascota(request);
            Response<Object> res = call.execute();
            return res.isSuccessful();

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return false;
        }
    }


    public static Boolean RegistrarAdopcion(Integer id_mascota){
        RequestReportar request = new RequestReportar();
        request.id_mascota = id_mascota;

        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<Object> call = retrofitConn.RegistrarAdopcion(request);
            Response<Object> res = call.execute();
            return res.isSuccessful();

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }


    public static Boolean ReportarMascotaPerdida(Integer id_mascota){
        RequestReportar request = new RequestReportar();
        request.id_mascota = id_mascota;

        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<Object> call = retrofitConn.ReportarMascotaPerdida(request);
            Response<Object> res = call.execute();
            return res.isSuccessful();

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }

    public static Boolean ReportarMascotaEncontrada(Integer id_mascota){
        RequestReportar request = new RequestReportar();
        request.id_mascota = id_mascota;

        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VariablesGlobales.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

            RetrofitConn retrofitConn = retrofit.create(RetrofitConn.class);
            Call<Object> call = retrofitConn.ReportarMascotaEncontrada(request);
            Response<Object> res = call.execute();
            return res.isSuccessful();

        }catch(Exception e){
            Log.e("login", e.getMessage());
            return null;
        }
    }
}
