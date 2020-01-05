package com.example.ilian.findpetcom;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilian.findpetcom.adapters.ViewPagerAdapter;
import com.example.ilian.findpetcom.fragments.FragmentEnAdopcion;
import com.example.ilian.findpetcom.fragments.FragmentMias;
import com.example.ilian.findpetcom.fragments.FragmentPerdidas;

public class Inicio extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    //CREA LOS FRAGMENTS Y LOS PRESENTA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Datos.cargarUsers();
        Datos.cargarMascotas();
        Datos.cargarMascotasEnAdopcion();
        Datos.cargarMascotasPerdidas();
        //Datos.cargarMascotasMias();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        tabs=(TabLayout)findViewById(R.id.tablayout_id);
        viewPager=(ViewPager)findViewById(R.id.viewpager_id);

        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        FragmentEnAdopcion f1=new FragmentEnAdopcion();
        f1.setI(1);
        FragmentEnAdopcion f2=new FragmentEnAdopcion();
        f2.setI(2);
        FragmentEnAdopcion f3=new FragmentEnAdopcion();
        f3.setI(3);
        adapter.addFragment(f1,"En Adopcion");
        adapter.addFragment(f2,"Perdidas");
        adapter.addFragment(f3,"Mis Macotas");

        Datos.adapter=adapter;

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);




    }
}
