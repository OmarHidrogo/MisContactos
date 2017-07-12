package com.omar_hidrogo_local.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.omar_hidrogo_local.miscontactos.adapter.ContactoAdaptador;
import com.omar_hidrogo_local.miscontactos.adapter.PageAdapter;
import com.omar_hidrogo_local.miscontactos.fragment.PerfilFragment;
import com.omar_hidrogo_local.miscontactos.fragment.RecyclerViewfragment;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

import static com.omar_hidrogo_local.miscontactos.R.id.never;
import static com.omar_hidrogo_local.miscontactos.R.id.rvContactos;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }





        //se instancia el arreglo "crear"


        //se crea una lista de arreglos con el nombre de los contactor, una vez que el ArrayList contactos es llenado ens necesario crear otro
        //ArrayLista de tipo String para llenarlo solo de Nombres. tiene como nombre....   nombreContacto

  /*      ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombreContacto.add(contacto.getNombre());
        }
        //Se declara el ListView generado en Activity_main
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        //para llenar una lista de contactos es necesario utilizar un adaptador
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreContacto));

        //es necesario establecer en la lstContactos la escucha de cuando le den un click a una lista de contactos
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                //intent.putExtra("Contactos", contactos);
                startActivity(intent);
                finish();
            }
        });   */

    }




    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewfragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.contact);
        tabLayout.getTabAt(1).setIcon(R.drawable.person);
    }



}
