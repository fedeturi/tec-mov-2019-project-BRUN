package com.example.theweatherguy;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            fragmentTransaction.replace(R.id.fragment_container, new TodayWeather());
            fragmentTransaction.commit();

            navigationView.setCheckedItem(R.id.nav_weather);
        }


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_profile:
                //fragmentTransaction.replace(R.id.fragment_container, new TodayWeather());
                Toast message = Toast.makeText(this, "Profile", Toast.LENGTH_SHORT);
                message.show();
                break;
            case R.id.nav_weather:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TodayWeather());
                fragmentTransaction.commit();
                Toast message2 = Toast.makeText(this, "Today", Toast.LENGTH_SHORT);
                message2.show();
                break;
            case R.id.nav_week:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new WeekForecast());
                fragmentTransaction.commit();
                Toast message3 = Toast.makeText(this, "Week", Toast.LENGTH_SHORT);
                message3.show();
                break;
            case R.id.nav_map:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new WeatherMap());
                fragmentTransaction.commit();
                Toast message4 = Toast.makeText(this, "Map", Toast.LENGTH_SHORT);
                message4.show();
                break;
            case R.id.nav_settings:
                Toast message5 = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
                message5.show();
                break;
            case R.id.nav_about:
                Toast message6 = Toast.makeText(this, "About", Toast.LENGTH_SHORT);
                message6.show();
                break;
            case R.id.nav_logout:
                Toast message7 = Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT);
                message7.show();
                break;
            case R.id.nav_share:
                Toast message8 = Toast.makeText(this, "Share", Toast.LENGTH_SHORT);
                message8.show();
                break;
            case R.id.nav_send:
                Toast message9 = Toast.makeText(this, "Send", Toast.LENGTH_SHORT);
                message9.show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
