package com.example.theweatherguy;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_today:
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Today's wather", Toast.LENGTH_LONG);
                    toast1.show();
                    return true;
                case R.id.navigation_week:
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Week's forecast", Toast.LENGTH_LONG);
                    toast2.show();
                    return true;
                case R.id.navigation_map:
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Weather Map", Toast.LENGTH_LONG);
                    toast3.show();
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
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
