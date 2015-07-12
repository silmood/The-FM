package com.platzi.silmood.the_fm.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.silmood.the_fm.R;
import com.platzi.silmood.the_fm.domain.Artist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

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
public class TopArtistAdapter extends RecyclerView.Adapter<TopArtistAdapter.TopArtistViewHolder>{


    Context context;
    ArrayList<Artist> artists;

    public TopArtistAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public TopArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View artistView = LayoutInflater.from(context).inflate(R.layout.item_top_artist, parent, false);

        return new TopArtistViewHolder(artistView);
    }

    @Override
    public void onBindViewHolder(TopArtistViewHolder holder, int position) {
        Artist artist = artists.get(position);

        holder.setName(artist.getName());
        holder.setListeners(artist.getListeners());
        holder.setPlayCount(artist.getPlayCount());

        if (artist.getUrlLargeImage() != null)
            holder.setImage(artist.getUrlLargeImage());

        else
            holder.setDefaultImage();

    }

    public void addAll(ArrayList<Artist> artists) {
        if (artists == null)
            throw new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class TopArtistViewHolder  extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView playCount;
        TextView listeners;

        public TopArtistViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.artist_img);
            name = (TextView) itemView.findViewById(R.id.artist_name);
            playCount = (TextView) itemView.findViewById(R.id.artist_playcount);
            listeners = (TextView) itemView.findViewById(R.id.artist_listeners);
        }


        public void setName(String name){
            this.name.setText(name);
        }

        public void setPlayCount(int playCount){
            this.playCount.setText(playCount + "");
        }

        public void setListeners(int listeners){
            this.listeners.setText(listeners + "");
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
