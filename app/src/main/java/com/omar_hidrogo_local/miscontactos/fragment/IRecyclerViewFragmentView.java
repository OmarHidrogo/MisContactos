package com.omar_hidrogo_local.miscontactos.fragment;

import com.omar_hidrogo_local.miscontactos.adapter.ContactoAdaptador;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 20/07/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinerLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
