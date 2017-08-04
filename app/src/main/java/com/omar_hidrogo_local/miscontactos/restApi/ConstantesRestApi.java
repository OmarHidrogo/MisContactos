package com.omar_hidrogo_local.miscontactos.restApi;

/**
 * Created by tmhidrooma on 03/08/2017.
 */

public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com"+VERSION;
    public static final String ACCESS_TOKEN = "5810080353.8c253d9.d52094964a454b88bd8d64b2d7fc5a98";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;


    //https://api.instagram.com/v1/users/self/media/recent/?access_token=5810080353.8c253d9.d52094964a454b88bd8d64b2d7fc5a98
}
