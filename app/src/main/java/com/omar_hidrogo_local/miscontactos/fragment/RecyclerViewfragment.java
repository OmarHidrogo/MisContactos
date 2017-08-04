package com.omar_hidrogo_local.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omar_hidrogo_local.miscontactos.R;
import com.omar_hidrogo_local.miscontactos.adapter.ContactoAdaptador;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;
import com.omar_hidrogo_local.miscontactos.presentador.IRecyclerViewFragmentPresent;
import com.omar_hidrogo_local.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 12/07/2017.
 */

public class RecyclerViewfragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Contacto> contactos;//se declara una lista de arreglo
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresent present;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        //Asociar el fragment al recycler view
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        present = new RecyclerViewFragmentPresenter(this,getContext());

        return v;
    }

    /*
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        //se llena el arreglo por medio del constructor creado en la clase Contacto
        contactos.add(new Contacto(R.drawable.bulbasaur,"BULBASAUR", "8711363102", "omar.083090@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.dragon,"CHARMANDER", "8711213258", "joel.hidrogo@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.dragon2,"CROCODAW", "8714019648", "susana.munoz@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.pikachu,"PIKACHU", "8712359267", "viri.hidrogo@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.poquemon,"ESCARBARENO", "8718960697", "pedro.luna@gmail.com", likes));
    }*/

    @Override
    public void generarLinerLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2 );
        listaContactos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
