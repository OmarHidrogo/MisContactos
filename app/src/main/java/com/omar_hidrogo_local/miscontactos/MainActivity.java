package com.omar_hidrogo_local.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import static com.omar_hidrogo_local.miscontactos.R.id.rvContactos;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;//se declara una lista de arreglo

    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(rvContactos);

       /* GridLayoutManager glm = new GridLayoutManager(this, 2);*/

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();


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

    public ContactoAdaptador adaptador;
    private void inicializaAdaptador(){
       //ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
       //listaContactos.setAdapter(adaptador);
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        //se llena el arreglo por medio del constructor creado en la clase Contacto
        contactos.add(new Contacto(R.drawable.bulbasaur,"BULBASAUR", "8711363102", "omar.083090@gmail.com"));
        contactos.add(new Contacto(R.drawable.dragon,"CHARMANDER", "8711213258", "joel.hidrogo@gmail.com"));
        contactos.add(new Contacto(R.drawable.dragon2,"CROCODAW", "8714019648", "susana.munoz@gmail.com"));
        contactos.add(new Contacto(R.drawable.pikachu,"PIKACHU", "8712359267", "viri.hidrogo@gmail.com"));
        contactos.add(new Contacto(R.drawable.poquemon,"ESCARBARENO", "8718960697", "pedro.luna@gmail.com"));
    }
}
