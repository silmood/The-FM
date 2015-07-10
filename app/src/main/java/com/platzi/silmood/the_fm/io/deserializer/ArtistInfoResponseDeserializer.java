package com.platzi.silmood.the_fm.io.deserializer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.platzi.silmood.the_fm.domain.Artist;
import com.platzi.silmood.the_fm.io.model.JsonKeys;

import org.json.JSONArray;

import java.lang.reflect.Type;

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
public class ArtistInfoResponseDeserializer implements JsonDeserializer<Artist> {
    @Override
    public Artist deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        JsonObject artistData = json.getAsJsonObject().getAsJsonObject(JsonKeys.ARTISTS_ARRAY);
        JsonArray artistImages = artistData.getAsJsonArray(JsonKeys.ARTIST_IMAGES);
        JsonObject artistStats = artistData.getAsJsonObject(JsonKeys.ARTIST_STATS);

        Artist artist = Artist.buildArtistFromJson(artistData);
        artist.extractUrlsFromImagesArray(artistImages);
        artist.extractStatsFromJson(artistStats);

        return artist;
    }
}
