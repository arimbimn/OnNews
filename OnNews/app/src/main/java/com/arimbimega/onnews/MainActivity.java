package com.arimbimega.onnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.arimbimega.onnews.Model.HealthModel;
import com.arimbimega.onnews.Retrofit.APIService;
import com.arimbimega.onnews.Topic.EntertaimentFragment;
import com.arimbimega.onnews.Topic.HealthFragment;
import com.arimbimega.onnews.Topic.SearchFragment;
import com.arimbimega.onnews.Topic.SportFragment;
import com.arimbimega.onnews.Topic.TechnologyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //TextView tvStatus, tvPenerbit, tvJudul, tvDesc, tvUrl, tvTgl, tvIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentPage(new SportFragment());
        BottomNavigationView navigationView = findViewById(R.id.NavigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.health:
                        fragment = new HealthFragment();
                        break;

                    case R.id.sport:
                        fragment = new SportFragment();
                        break;

                    case R.id.ent:
                        fragment = new EntertaimentFragment();
                        break;

                    case R.id.technology:
                        fragment = new TechnologyFragment();
                        break;

                    case R.id.search:
                        fragment = new SearchFragment();
                        break;

                }
                return getFragmentPage(fragment);
            }

        });

    }

    private boolean getFragmentPage(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.page_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}