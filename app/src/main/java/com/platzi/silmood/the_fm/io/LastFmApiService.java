package com.platzi.silmood.the_fm.io;

import com.platzi.silmood.the_fm.domain.Artist;
import com.platzi.silmood.the_fm.io.model.ChartArtistResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Created by Pedro Hernández on 07/2015.
 */
public interface LastFmApiService {

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    void getHypedArtists(Callback<ChartArtistResponse> serverResponse);

    @GET(ApiConstants.URL_ARTIST_INFO)
    void getArtistInfo(@Query(ApiConstants.PARAM_ARTIST) String artistName, Callback<Artist> serverResponse);

    @GET(ApiConstants.URL_HYPED_ARTISTS)
    Observable<ChartArtistResponse> getHypedArtists();

    @GET(ApiConstants.URL_ARTIST_INFO)
    Observable<Artist> getArtistInfo(@Query(ApiConstants.PARAM_ARTIST) String name);

    @GET(ApiConstants.URL_TOP_ARTIST)
    Observable<ChartArtistResponse> getTopArtists();
}
