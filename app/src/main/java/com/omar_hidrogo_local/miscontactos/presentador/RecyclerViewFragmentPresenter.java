package com.omar_hidrogo_local.miscontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.omar_hidrogo_local.miscontactos.adapter.ContactoAdaptador;
import com.omar_hidrogo_local.miscontactos.db.ConstructorContactos;
import com.omar_hidrogo_local.miscontactos.fragment.IRecyclerViewFragmentView;
import com.omar_hidrogo_local.miscontactos.pojo.Contacto;
import com.omar_hidrogo_local.miscontactos.restApi.EndpointsApi;
import com.omar_hidrogo_local.miscontactos.restApi.adapter.RestApiAdapter;
import com.omar_hidrogo_local.miscontactos.restApi.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();                                           //conexion a web services
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();                 //se prepara objeto Gson  realizando una deserializadorpersonalizado
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);//Establecemos la conexion y pasamos el objeto gsonMediaRecent
        Call<ContactoResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            //eventos de la peticion
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso en la conexion intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
