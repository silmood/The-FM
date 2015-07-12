package com.platzi.silmood.the_fm.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.platzi.silmood.the_fm.R;
import com.platzi.silmood.the_fm.io.LastFmApiAdapter;
import com.platzi.silmood.the_fm.io.LastFmApiService;
import com.platzi.silmood.the_fm.io.model.HypedArtistResponse;
import com.platzi.silmood.the_fm.io.model.TopArtistsResponse;
import com.platzi.silmood.the_fm.ui.ItemDividerDecoration;
import com.platzi.silmood.the_fm.ui.adapter.TopArtistAdapter;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

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
public class TopArtistsFragment extends Fragment {

    private RecyclerView artistList;
    private TopArtistAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_artist, container, false);

        artistList = (RecyclerView) root.findViewById(R.id.artist_list);
        adapter = new TopArtistAdapter(getActivity());
        setupList();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        LastFmApiAdapter.getTopArtist()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(topArtistsResponse -> {
                    adapter.addAll(topArtistsResponse.getArtists());
                });
    }

    private void setupList() {
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(adapter);
        artistList.addItemDecoration(new ItemDividerDecoration(getActivity()));
    }

}
