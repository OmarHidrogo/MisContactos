package com.omar_hidrogo_local.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omar_hidrogo_local.miscontactos.R;
import com.omar_hidrogo_local.miscontactos.adapter.ContactoAdaptador;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 12/07/2017.
 */

public class RecyclerViewfragment extends Fragment {

    private ArrayList<Contacto> contactos;//se declara una lista de arreglo
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        //Asociar el fragment al recycler view
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

       LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializaAdaptador();



        return v;
    }
    public ContactoAdaptador adaptador;

    private void inicializaAdaptador(){
        //ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        //listaContactos.setAdapter(adaptador);
        adaptador = new ContactoAdaptador(contactos, getActivity());
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
