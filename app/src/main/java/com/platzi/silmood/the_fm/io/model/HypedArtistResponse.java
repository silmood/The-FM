package com.platzi.silmood.the_fm.io.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.platzi.silmood.the_fm.domain.Artist;

import java.util.ArrayList;

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
public class HypedArtistResponse {

    @SerializedName(JsonKeys.ARTISTS_RESPONSE)
    private MainResponse mainResponse;

    public ArrayList<Artist> getArtists(){
        return  mainResponse.artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        mainResponse.artists = artists;
    }

    private class MainResponse {

        private ArrayList<Artist> artists;

    }
}
