package com.platzi.silmood.the_fm.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.platzi.silmood.the_fm.BuildConfig;
import com.platzi.silmood.the_fm.R;
import com.platzi.silmood.the_fm.io.LastFmApiAdapter;
import com.platzi.silmood.the_fm.io.model.HypedArtistResponse;
import com.platzi.silmood.the_fm.ui.ItemOffsetDecoration;
import com.platzi.silmood.the_fm.ui.adapter.HypedArtistsAdapter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.android.schedulers.AndroidSchedulers;


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

public class HypedArtistsFragment extends Fragment implements Callback<HypedArtistResponse> {

    public static final int COLUMNS = 2;

    private RecyclerView artistList;
    private HypedArtistsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);

        artistList = (RecyclerView) root.findViewById(R.id.artist_list);
        adapter = new HypedArtistsAdapter(getActivity());

        setupList();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        requestHypedArtists();
    }

    private void requestHypedArtists() {
        LastFmApiAdapter.getHypedArtist()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(hypedArtistResponse -> {
                    adapter.addAll(hypedArtistResponse.getArtists());
                });
    }



    private void setupList() {
        artistList.setLayoutManager(new GridLayoutManager(getActivity(), COLUMNS));
        artistList.setAdapter(adapter);
        artistList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset_grid));
    }

    @Override
    public void success(HypedArtistResponse hypedArtistResponse, Response response) {
        adapter.addAll(hypedArtistResponse.getArtists());
    }

    @Override
    public void failure(RetrofitError error) {
        if (error.getKind() == RetrofitError.Kind.NETWORK) {
            Toast.makeText(getActivity(), R.string.network_error, Toast.LENGTH_LONG).show();
        }
    }
}
