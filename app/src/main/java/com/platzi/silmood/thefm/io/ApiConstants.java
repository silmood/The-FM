package com.platzi.silmood.thefm.io;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Pedro Hernández on 07/2015.
 */
public class ApiConstants {

    public static final String API_KEY = "123ae7ccee87798c55c82b64c792a083";

    public static final String URL_BASE = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_METHOD="method";
    public static final String PARAM_FORMAT = "format";
    public static final String PARAM_API_KEY = "api_key";

    public static final String VALUE_HYPED_ARTIST_METHOD = "chart.gethypedartists";
    public static final String VALUE_JSON = "json";

    //?api_key=123ae7ccee87798c55c82b64c792a083&method=chart.gethypedartists&format=json
    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "?" + PARAM_API_KEY + "=" + API_KEY + "&" +
            PARAM_METHOD + "=" + VALUE_HYPED_ARTIST_METHOD + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;
}
