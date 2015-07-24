package com.platzi.silmood.the_fm.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.platzi.silmood.the_fm.BuildConfig;
import com.platzi.silmood.the_fm.R;
import com.platzi.silmood.the_fm.domain.Artist;
import com.platzi.silmood.the_fm.io.ApiConstants;
import com.platzi.silmood.the_fm.io.VolleySingleton;
import com.platzi.silmood.the_fm.ui.ItemDividerDecoration;
import com.platzi.silmood.the_fm.ui.adapter.TopArtistAdapter;

import org.json.JSONObject;

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
public class TopArtistsFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    public static final String TAG = HypedArtistsFragment.class.getSimpleName();

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
        requestTopArtists();
    }


    private void requestTopArtists() {
        String urlTopArtists = ApiConstants.URL_TOP_ARTIST + BuildConfig.LAST_FM_API_KEY;
        Log.d(TAG, urlTopArtists);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlTopArtists, this, this);
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onResponse(JSONObject response) {
        adapter.addAll(Artist.parseJsonArtists(response));
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getActivity(), R.string.network_error, Toast.LENGTH_LONG).show();
    }

    private void setupList() {
        artistList.setLayoutManager(new LinearLayoutManager(getActivity()));
        artistList.setAdapter(adapter);
        artistList.addItemDecoration(new ItemDividerDecoration(getActivity()));
    }
}
