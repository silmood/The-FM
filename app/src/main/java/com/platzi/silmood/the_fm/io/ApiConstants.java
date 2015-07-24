package com.platzi.silmood.the_fm.io;


public class ApiConstants {

    public static final String BASE_URL = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_ARTIST = "artist";

    public static final String VALUE_JSON = "json";
    public static final String VALUE_HYPED_ARTISTS_METHOD = "chart.gethypedartists";
    public static final String VALUE_TOP_ARTISTS_METHOD = "chart.gettopartists";
    public static final String VALUE_ARTIST_INFO_METHOD = "artist.getinfo";

    public static final String URL_HYPED_ARTISTS = BASE_URL + PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_HYPED_ARTISTS_METHOD + "&" + PARAM_API_KEY + "=";

    public static final String URL_TOP_ARTIST = BASE_URL + PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_TOP_ARTISTS_METHOD + "&" + PARAM_API_KEY + "=";

    public static final String URL_ARTIST_INFO = PATH_VERSION + "?"
            + "&" + PARAM_FORMAT + "=" + VALUE_JSON
            + "&" + PARAM_METHOD + "=" + VALUE_ARTIST_INFO_METHOD;


}
