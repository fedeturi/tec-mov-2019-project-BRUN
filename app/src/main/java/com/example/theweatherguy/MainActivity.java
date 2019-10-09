package com.example.theweatherguy;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_today:
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Today's wather", Toast.LENGTH_LONG);
                    toast1.show();
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_week:
                    mTextMessage.setText(R.string.title_dashboard);
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Week's forecast", Toast.LENGTH_LONG);
                    toast2.show();
                    return true;
                case R.id.navigation_map:
                    mTextMessage.setText(R.string.title_notifications);
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
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
