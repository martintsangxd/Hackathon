package com.example.pins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chipNavigationBar = findViewById(R.id.bottom_nav_bar);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_map, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, new MapsFragment()).commit();

        bottomNavBar();
    }

    private void bottomNavBar() {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment f = null;
                switch (i) {
                    case R.id.bottom_nav_map:
                        f = new MapsFragment();
                        break;
                    case R.id.bottom_nav_account:
                        f = new AccountFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, f).commit();
            }
        });
    }
}