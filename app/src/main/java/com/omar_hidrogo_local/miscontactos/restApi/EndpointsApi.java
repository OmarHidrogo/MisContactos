package com.omar_hidrogo_local.miscontactos.restApi;


import com.omar_hidrogo_local.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tmhidrooma on 03/08/2017.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
   Call<ContactoResponse> getRecentMedia();
}
