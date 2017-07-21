package com.omar_hidrogo_local.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class DetalleContacto extends AppCompatActivity {

    //Variables en raiz
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    final private int REQUEST_CODE_ASK_PERMISSIONS =123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //es necesario recibir los parametros enviados de un Intent en Bundle
        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.pnombre));//nombre
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));//telefono
        String email = parametros.getString(getResources().getString(R.string.pemail));//email


        //es necesario sincronizar los textView del layout y guardarlo en una variable.
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        //asignar el valor de la variable  al android:text
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
    }

    //metodo para llamar
    public void llamar(View v) {

        int permissioncheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS},
                        REQUEST_CODE_ASK_PERMISSIONS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
            Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+tvTelefono));
            startActivity(i);
        }


       /* if(permissioncheck != PackageManager.PERMISSION_GRANTED){
            Log.i("Mensaje", "No se tiene permiso para realizar llamadas telefonica.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 225);
            }else {
                    Log.i("Mensaje", "Se tiene permiso para realizar llamadas");
            }
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                     if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)==PackageManager.PERMISSION_GRANTED){
                    }else {
                             ActivityCompat.requestPermissions(DetalleContacto.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                        return;
                    }
                    Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8711363102"));
                    startActivity(i);
        }*/







       /* String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
            Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8711363102"));
            startActivity(i);
        //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));*/
    }

    //Metodo para enviar correo electronico
    public void enviarMail(View v){
        String email = tvEmail.getText().toString();
        Intent emailIntent = new Intent ((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));

        //en al extension: EXTRA_EMAIL   se puede cambiar a EXTRA_CC  si queremos realizar el envio de correo electronico como copia al parametro que se pasa.
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);

        //indentificar que tipo de aplicacion abrira el correo electronico
        emailIntent.setType("message/rfc822");

        //declarar cual sera la aplicacion a utilizar el envio de correo electronico en este caso el usuario eligira cual.
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
            if(keyCode == KeyEvent.KEYCODE_BACK){
                Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
                startActivity(intent);
            }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
