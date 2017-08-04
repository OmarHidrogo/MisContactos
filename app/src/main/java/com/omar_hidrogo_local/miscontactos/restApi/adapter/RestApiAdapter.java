package com.omar_hidrogo_local.miscontactos.restApi.adapter;

import com.omar_hidrogo_local.miscontactos.restApi.ConstantesRestApi;
import com.omar_hidrogo_local.miscontactos.restApi.EndpointsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tmhidrooma on 03/08/2017.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }
}
