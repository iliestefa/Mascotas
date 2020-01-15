package com.example.ilian.findpetcom;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ilian.findpetcom.adapters.DialogMio;
import com.example.ilian.findpetcom.adapters.ViewPagerAdapter;
import com.example.ilian.findpetcom.fragments.FragmentEnAdopcion;

public class Inicio extends AppCompatActivity {
    public static FragmentEnAdopcion frag = null;

    private TabLayout tabs;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    DrawerLayout lay;
    ActionBarDrawerToggle ntoggle;

    //CREA LOS FRAGMENTS Y LOS PRESENTA
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Datos.cargarMascotasMias();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        lay = (DrawerLayout) findViewById(R.id.lay);
        ntoggle = new ActionBarDrawerToggle(this, lay, R.string.open, R.string.close);
        lay.addDrawerListener(ntoggle);
        NavigationView nv = findViewById(R.id.nv);
        ntoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nv);
        frag = new FragmentEnAdopcion();
        frag.setI(1);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.flconten, frag).commit();

/*

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


*/

    }

    public void selectItemDrawer(MenuItem menuItem) {
        frag = null;
        FragmentManager fm;

        switch (menuItem.getItemId()) {
            case R.id.mnuAdopcion:
                frag = new FragmentEnAdopcion();
                frag.setI(1);
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.flconten, frag).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                break;
            case R.id.mnuPerdidas:
                frag = new FragmentEnAdopcion();
                frag.setI(2);
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.flconten, frag).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                break;
            case R.id.mnuMias:
                frag = new FragmentEnAdopcion();
                frag.setI(3);
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.flconten, frag).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                break;
            case R.id.mnuAddPet:
                Intent addMasc = new Intent(Inicio.this, NuevaMascota.class);
                startActivity(addMasc);
                break;
            case R.id.mnuPerfil:
                DialogMio dialogo = new DialogMio(this);
                dialogo.llenarUser(Datos.user);
                break;
            case R.id.mnuCerrar:
                Intent log = new Intent(Inicio.this, Login.class);
                startActivity(log);
                finish();
                break;
            default:
                frag = new FragmentEnAdopcion();
                frag.setI(1);
        }


        lay.closeDrawers();


    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectItemDrawer(menuItem);


                return true;
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (ntoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

/*
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if (id==R.id.mnuAddPet){
            Intent addMasc=new Intent(Inicio.this,NuevaMascota.class);
            startActivity(addMasc);

        }else if(id==R.id.mnuPerfil){
            DialogMio dialogo =new DialogMio(this);
            dialogo.llenarUser(Datos.user);


        }else if(id==R.id.mnuCerrar){
            Intent log=new Intent(Inicio.this,Login.class);
            startActivity(log);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
 */
}
