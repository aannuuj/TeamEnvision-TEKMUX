package org.envision.trash_it;


import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

import android.app.FragmentTransaction;
import android.app.FragmentManager;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    boolean about_hack = false;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                  loadHomeFragment();
                    return true;
                case R.id.navigation_dashboard:
                   loadMapFragment();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        loadHomeFragment();
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private void loadHomeFragment()
    {
        about_hack = false;
        FragmentHome fragment = FragmentHome.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        setTitle("Home");
        ft.addToBackStack(null);
        ft.commit();
    }

    private void loadMapFragment()
    {
        about_hack = false;
        FragmentHome fragment = FragmentHome.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_frame, fragment);
        setTitle("Map");
        ft.addToBackStack(null);
        ft.commit();
    }

}
