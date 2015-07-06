package com.platzi.silmood.the_fm.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.platzi.silmood.the_fm.R;
import com.platzi.silmood.the_fm.ui.fragment.HypedArtistsFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            setupFragment();
        }
    }

    public void setupFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_container, new HypedArtistsFragment())
                .commit();
    }
}
