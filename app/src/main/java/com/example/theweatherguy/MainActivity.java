package com.example.theweatherguy;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_today:

                    selectedFragment = new TodayWeather();

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Today's wather", Toast.LENGTH_LONG);
                    toast1.show();
                    break;

                case R.id.navigation_week:

                    selectedFragment = new WeekForecast();

                    Toast toast2 = Toast.makeText(getApplicationContext(), "Week's forecast", Toast.LENGTH_LONG);
                    toast2.show();
                    break;

                case R.id.navigation_map:

                    selectedFragment = new WeatherMap();

                    Toast toast3 = Toast.makeText(getApplicationContext(), "Weather Map", Toast.LENGTH_LONG);
                    toast3.show();
                    break;
            }


            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_back_stack_frame_layout, selectedFragment);
            fragmentTransaction.commit();

            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_back_stack_frame_layout,
                new TodayWeather()).commit();


    }

}
