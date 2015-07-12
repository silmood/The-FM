package com.platzi.silmood.the_fm.domain;

import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.platzi.silmood.the_fm.io.model.JsonKeys;

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
 *
 * Created by Pedro Hernández on 07/2015.
 */

public class Artist {

    @SerializedName(JsonKeys.ARTIST_NAME)
    private String name;

    @Nullable
    private String urlMediumImage;

    @Nullable
    private String urlLargeImage;

    private String bioSummary;

    private boolean onTour;

    @SerializedName(JsonKeys.ARTIST_LISTENERS)
    private int listeners;

    @SerializedName(JsonKeys.ARTIST_PLAY_COUNT)
    private int playCount;

    private ArrayList<Artist> relatedArtist;

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Nullable
    public String getUrlMediumImage() {
        return urlMediumImage;
    }

    public void setUrlMediumImage(@Nullable String urlMediumImage) {
        this.urlMediumImage = urlMediumImage;
    }

    @Nullable
    public String getUrlLargeImage() {
        return urlLargeImage;
    }

    public void setUrlLargeImage(@Nullable String urlLargeImage) {
        this.urlLargeImage = urlLargeImage;
    }

    public boolean isOnTour() {
        return onTour;
    }

    public void setOnTour(boolean onTour) {
        this.onTour = onTour;
    }

    public String getBioSummary() {
        return bioSummary;
    }

    public void setBioSummary(String bioSummary) {
        this.bioSummary = bioSummary;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public ArrayList<Artist> getRelatedArtist() {
        return relatedArtist;
    }

    public void setRelatedArtist(ArrayList<Artist> relatedArtist) {
        this.relatedArtist = relatedArtist;
    }

    public static Artist buildArtistFromJson(JsonObject artistData) {
        Gson gson = new Gson();

        return gson.fromJson(artistData, Artist.class);
    }


    public Artist extractUrlsFromImagesArray(JsonArray imagesJson){
        String [] images = new String[2];

        for (int i = 0; i < imagesJson.size(); i++) {
            JsonObject currentImage = imagesJson.get(i).getAsJsonObject();

            String size = currentImage.get(JsonKeys.IMAGE_SIZE).getAsString();
            String url = currentImage.get(JsonKeys.IMAGE_URL).getAsString();

            url = url.replaceAll("\\/", "/");

            if (url.isEmpty())
                url = null;

            if (size.matches(JsonKeys.IMAGE_MEDIUM) )
                images[0] = url;

            else if (size.matches(JsonKeys.IMAGE_LARGE))
                images[1] = url;

        }

        //Set the images
        setUrlMediumImage(images[0]);
        setUrlLargeImage(images[1]);

        return this;
    }

    public Artist extractStatsFromJson(JsonObject stats){
        String listeners = stats.get(JsonKeys.ARTIST_LISTENERS).getAsString();
        String playCount = stats.get(JsonKeys.ARTIST_PLAY_COUNT).getAsString();

        setListeners(Integer.parseInt(listeners));
        setPlayCount(Integer.parseInt(playCount));

        return this;
    }
}
