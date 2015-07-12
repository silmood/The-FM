package com.platzi.silmood.the_fm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.silmood.the_fm.R;
import com.platzi.silmood.the_fm.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistHolder> {

    ArrayList<Artist> artists;
    Context context;

    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistHolder onCreateViewHolder(ViewGroup container, int position) {
        View artistView = LayoutInflater.from(context)
                .inflate(R.layout.item_hyped_artists, container, false);

        return new HypedArtistHolder(artistView);
    }

    @Override
    public void onBindViewHolder(HypedArtistHolder hypedArtistHolder, int position) {
        Artist currentArtist = artists.get(position);

        hypedArtistHolder.setName(currentArtist.getName());

        if(currentArtist.getUrlMediumImage() != null)
            hypedArtistHolder.setImage(currentArtist.getUrlMediumImage());
        else
            hypedArtistHolder.setDefaultImage();
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(ArrayList<Artist> artists) {
        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        notifyDataSetChanged();
    }

    public void addItem(Artist artist){
        artists.add(artist);

        notifyItemInserted(getItemCount()-1);
    }

    public void replace(ArrayList<Artist> artists){
        this.artists = artists;
        notifyDataSetChanged();
    }

    public class HypedArtistHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name;

        public HypedArtistHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.artist_img);
            name = (TextView) itemView.findViewById(R.id.artist_name);
        }

        public void setName(String name){
           this.name.setText(name);
        }

        public void setDefaultImage(){
            Picasso.with(context)
                    .load(R.drawable.artist_placeholder)
                    .into(image);
        }

        public void setImage(String urlImage){
            Picasso.with(context)
                    .load(urlImage)
                    .placeholder(R.drawable.artist_placeholder)
                    .into(image);
        }

    }
}
