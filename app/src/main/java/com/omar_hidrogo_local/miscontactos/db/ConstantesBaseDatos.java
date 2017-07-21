package com.omar_hidrogo_local.miscontactos.db;

/**
 * Created by tmhidrooma on 20/07/2017.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CONTACTS = "contacto";
    public static final String TABLE_CONTACTS_ID = "id";
    public static final String TABLE_CONTACTS_NOMBRE = "nombre";
    public static final String TABLE_CONTACTS_TELEFONO = "telefono";
    public static final String TABLE_CONTACTS_EMAIL = "email";
    public static final String TABLE_CONTACTS_FOTO = "foto";

    public static final String TABLE_LIKES_CONTACT = "contacto_likes";
    public static final String TABLE_LIKES_CONTACT_ID = "id";
    public static final String TABLE_LIKES_CONTACT_ID_CONTACTO = "id_contacto";
    public static final String TABLE_LIKES_CONTACT_NUMERO_LIKES = "numero_likes";
}
