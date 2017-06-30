package com.omar_hidrogo_local.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.net.URI;

public class DetalleContacto extends AppCompatActivity {

    //Variables en raiz
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

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
        String telefono = tvTelefono.getText().toString();
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
        //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
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
}
