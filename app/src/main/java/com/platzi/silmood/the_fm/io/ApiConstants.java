package com.platzi.silmood.the_fm.io;


public class ApiConstants {

    public static final String API_KEY = "123ae7ccee87798c55c82b64c792a083";

    public static final String BASE_URL = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";

    public static final String VALUE_JSON = "json";
    public static final String VALUE_HYPED_ARTISTS_METHOD = "chart.gethypedartists";

    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "?" + PARAM_API_KEY + "=" + API_KEY
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_HYPED_ARTISTS_METHOD;

}
