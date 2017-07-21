package com.omar_hidrogo_local.miscontactos.presentador;

import android.content.Context;

import com.omar_hidrogo_local.miscontactos.adapter.ContactoAdaptador;
import com.omar_hidrogo_local.miscontactos.db.ConstructorContactos;
import com.omar_hidrogo_local.miscontactos.fragment.IRecyclerViewFragmentView;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 20/07/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresent {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context=context;
        obtenerContactosBaseDatos();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();
    }
}
