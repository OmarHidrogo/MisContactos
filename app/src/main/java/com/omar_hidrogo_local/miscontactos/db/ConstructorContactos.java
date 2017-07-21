package com.omar_hidrogo_local.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.omar_hidrogo_local.miscontactos.R;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 20/07/2017.
 */

public class ConstructorContactos {

    private Context context;
    public ConstructorContactos(Context context) {
        this.context=context;
    }


    public ArrayList<Contacto> obtenerDatos(){

       /* ArrayList<Contacto> contactos = new ArrayList<>();

        //se llena el arreglo por medio del constructor creado en la clase Contacto
        contactos.add(new Contacto(R.drawable.bulbasaur,"BULBASAUR", "8711363102", "omar.083090@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.dragon,"CHARMANDER", "8711213258", "joel.hidrogo@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.dragon2,"CROCODAW", "8714019648", "susana.munoz@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.pikachu,"PIKACHU", "8712359267", "viri.hidrogo@gmail.com", 9));
        contactos.add(new Contacto(R.drawable.poquemon,"ESCARBARENO", "8718960697", "pedro.luna@gmail.com", 2));
        return contactos;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTresContactos (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Vanessa Garcia");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "777888999");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "Victor.Garcia@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.fa1);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Brenda Velasques");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "8711213258");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "Mario.Velasques@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.fa2);

        db.insertarContactos(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Veronica Lopez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "8714019648");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "Veronica.Lopez@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.fa3);

        db.insertarContactos(contentValues);
    }
}
