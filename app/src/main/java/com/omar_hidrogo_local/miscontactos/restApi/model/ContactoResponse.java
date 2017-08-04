package com.omar_hidrogo_local.miscontactos.restApi.model;

import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 03/08/2017.
 */

public class ContactoResponse {
    ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
}
