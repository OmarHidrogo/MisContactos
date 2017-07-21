package com.omar_hidrogo_local.miscontactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.omar_hidrogo_local.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by tmhidrooma on 20/07/2017.
 */

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //se crea la estructura de la base de datos
        String queryCrearTablaContacto = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_CONTACTS+ "("+
                    ConstantesBaseDatos.TABLE_CONTACTS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE       + " TEXT, "+
                    ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO     + " TEXT, "+
                    ConstantesBaseDatos.TABLE_CONTACTS_EMAIL        + " TEXT, "+
                    ConstantesBaseDatos.TABLE_CONTACTS_FOTO         + " INTEGER"+
                    ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE "+ ConstantesBaseDatos.TABLE_LIKES_CONTACT + "("+
                    ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO      + " INTEGER, "+
                    ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES     + " INTEGER, "+
                    "FOREIGN KEY  (" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") "+
                    "REFERENCES "+ ConstantesBaseDatos.TABLE_CONTACTS + "("+ConstantesBaseDatos.TABLE_CONTACTS_ID+")"+
                    ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXIST "+ ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        onCreate(db);
    }


    public ArrayList<Contacto> obtenerTodosLosContactos(){
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            contactos.add(contactoActual);
        }
            db.close();

        return contactos;
    }

    public  void insertarContactos(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues );
        db.close();
    }

}
