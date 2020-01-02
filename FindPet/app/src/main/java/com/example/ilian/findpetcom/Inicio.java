package com.example.ilian.findpetcom;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilian.findpetcom.adapters.ViewPagerAdapter;
import com.example.ilian.findpetcom.fragments.FragmentAdopcion;
import com.example.ilian.findpetcom.fragments.FragmentMias;
import com.example.ilian.findpetcom.fragments.FragmentPerdidas;

public class Inicio extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        tabs=(TabLayout)findViewById(R.id.tablayout_id);
        viewPager=(ViewPager)findViewById(R.id.viewpager_id);

        adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentAdopcion(),"En Adopcion");
        adapter.addFragment(new FragmentPerdidas(),"Perdidas");
        adapter.addFragment(new FragmentMias(),"Mias");

        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);



    }
}
