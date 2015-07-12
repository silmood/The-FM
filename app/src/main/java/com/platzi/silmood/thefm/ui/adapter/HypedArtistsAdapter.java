package com.platzi.silmood.thefm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.platzi.silmood.thefm.R;
import com.platzi.silmood.thefm.domain.Artist;

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
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistViewHolder>{

    ArrayList<Artist> artists;
    Context context;

    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_hyped_artists, parent, false);

        return new HypedArtistViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);

        holder.setArtistName(currentArtist.getName());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artists){
        if (artists == null)
            throw  new NullPointerException("The items cannot be null");

        this.artists.addAll(artists);
        notifyDataSetChanged();
    }

    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{

        TextView artistName;
        ImageView artistImage;

        public HypedArtistViewHolder(View itemView) {
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.txt_name);
            artistImage = (ImageView) itemView.findViewById(R.id.img_artist);
        }

        public void setArtistName (String name){
            artistName.setText(name);
        }
    }
}
