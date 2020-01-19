package com.example.ilian.findpetcom.RestApi;

import com.example.ilian.findpetcom.Estructuras.RequestLogin;
import com.example.ilian.findpetcom.Estructuras.RequestConsultarMascotas;
import com.example.ilian.findpetcom.Estructuras.RequestRealizarAdopcion;
import com.example.ilian.findpetcom.Estructuras.RequestReportar;
import com.example.ilian.findpetcom.Estructuras.RequestRegistrarMascota;
import com.example.ilian.findpetcom.Estructuras.ResponseRealizaAdopcion;
import com.example.ilian.findpetcom.modelo.Mascota;
import com.example.ilian.findpetcom.modelo.RazaMascota;
import com.example.ilian.findpetcom.modelo.TipoMascota;
import com.example.ilian.findpetcom.modelo.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RetrofitConn {

    @POST("login")
    Call<Usuario> login(@Body RequestLogin requestBody);


    @GET("allmascotas")
    Call<List<Mascota>> getAllMascotas();


    @POST("consultarMisMascotas")
    Call<List<Mascota>> consultarMisMascotas(@Body RequestConsultarMascotas request);


    @POST("consultarAdopciones")
    Call<List<Mascota>> ConsultarAdopciones(@Body RequestConsultarMascotas request);

    @POST("consultarPerdidas")
    Call<List<Mascota>> ConsultarPerdidas(@Body RequestConsultarMascotas request);

    @PUT("realizarAdopcion")
    Call<ResponseRealizaAdopcion> RealizarAdopcion(@Body RequestRealizarAdopcion request);

    @GET("alltipos")
    Call<List<TipoMascota>> getAllTipos();

    @GET("allrazas")
    Call<List<RazaMascota>> getAllRazas();

    @POST("registrarMascota")
    Call<Object> RegistrarMascota(@Body RequestRegistrarMascota request);

    @PUT("registrarAdopcion")
    Call<Object> RegistrarAdopcion(@Body RequestReportar request);

    @PUT("reportarMascotaPerdida")
    Call<Object> ReportarMascotaPerdida(@Body RequestReportar request);

    @PUT("reportarMascotaEncontrada")
    Call<Object> ReportarMascotaEncontrada(@Body RequestReportar request);

}
