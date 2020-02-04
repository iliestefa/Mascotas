package com.example.ilian.findpetcom;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ilian.findpetcom.adapters.DialogMio;
import com.example.ilian.findpetcom.adapters.ViewPagerAdapter;
import com.example.ilian.findpetcom.fragments.FragmentEnAdopcion;
import com.example.ilian.findpetcom.fragments.header;

public class Inicio extends AppCompatActivity {
    public static FragmentEnAdopcion frag = null;
    private SharedPreferences sharedPreferences;
    private ProgressDialog barProgressDialog = null;
    private TabLayout tabs;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    DrawerLayout lay;
    ActionBarDrawerToggle ntoggle;
    Integer idUsuario;
    //CREA LOS FRAGMENTS Y LOS PRESENTA
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Datos.cargarMascotasMias();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inicio);

        sharedPreferences = getSharedPreferences(VariablesGlobales.PREFERENCES, Context.MODE_PRIVATE);
        idUsuario = sharedPreferences.getInt("id_usuario", -1);
        if (idUsuario == -1) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
            return;
        }

        lay = (DrawerLayout) findViewById(R.id.lay);
        ntoggle = new ActionBarDrawerToggle(this, lay, R.string.open, R.string.close);
        lay.addDrawerListener(ntoggle);
        NavigationView nv = findViewById(R.id.nv);
        ntoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nv);


        frag = new FragmentEnAdopcion();
        frag.setI(1);
        frag.setUser(idUsuario);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.flconten, frag).commit();
        //header header= new header();
        //header.setSharedPreferences(sharedPreferences);
        llenarheader(nv);
       // llenarheader();

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


    void llenarheader(NavigationView nv){

        View header=nv.getHeaderView(0);
        String primer_nomb = sharedPreferences.getString("primer_nombre","");

        String primer_ape = sharedPreferences.getString("primer_apellido","");

         String tlf = sharedPreferences.getString("telefono","");
        String dir = sharedPreferences.getString("direccion","");
        TextView nomb=header.findViewById(R.id.txtHnombre);
        TextView dire=header.findViewById(R.id.txtHdir);
        TextView tel=header.findViewById(R.id.txttelefono);
        nomb.setText(primer_nomb+" "+primer_ape);
        dire.setText(dir);
        tel.setText("+"+tlf);
        }

    public void selectItemDrawer(MenuItem menuItem) {
        frag = null;
        FragmentManager fm;

        switch (menuItem.getItemId()) {
            case R.id.mnuAdopcion:
                frag = new FragmentEnAdopcion();
                frag.setI(1);
                frag.setUser(idUsuario);
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.flconten, frag).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                break;
            case R.id.mnuPerdidas:
                frag = new FragmentEnAdopcion();
                frag.setI(2);
                frag.setUser(idUsuario);
                fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.flconten, frag).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                break;
            case R.id.mnuMias:
                frag = new FragmentEnAdopcion();
                frag.setI(3);
                frag.setUser(idUsuario);
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
                dialogo.llenarPerfil(this.sharedPreferences);
                break;
            case R.id.mnuCerrar:

                final SharedPreferences sharedpreferences = getSharedPreferences(VariablesGlobales.PREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();


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
