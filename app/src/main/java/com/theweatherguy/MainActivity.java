package com.theweatherguy;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.theweatherguy.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private void sendMail() {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.developer_mail));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject));
        intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_body));
        intent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(intent, getString(R.string.choose_email_client)));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    R.string.there_is_no_email_client, Toast.LENGTH_SHORT).show();
        }

    }

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
            fragmentTransaction.replace(R.id.fragment_container, new TodayWeatherFragment());
            fragmentTransaction.commit();

            navigationView.setCheckedItem(R.id.nav_today);
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
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ProfileFragment());
                fragmentTransaction.commit();
                break;
            case R.id.nav_today:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TodayWeatherFragment());
                fragmentTransaction.commit();
                break;
            case R.id.nav_week:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new WeekForecastFragment());
                fragmentTransaction.commit();
                break;
            case R.id.nav_map:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new WeatherMapFragment());
                fragmentTransaction.commit();
                break;
            case R.id.nav_settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                /*
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UnderConstructionFragment());
                fragmentTransaction.commit();*/
                break;
            case R.id.nav_about:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UnderConstructionFragment());
                fragmentTransaction.commit();
                break;
            case R.id.nav_logout:

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        MainActivity.this);

                // set title
                alertDialogBuilder.setTitle("The Weather Guy");

                // set dialog message
                alertDialogBuilder
                        .setMessage("It was good to have you here!")
                        .setCancelable(false)
                        .setPositiveButton("Bye",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                MainActivity.this.finish();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();



                break;
            case R.id.nav_share:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new UnderConstructionFragment());
                fragmentTransaction.commit();
                break;
            case R.id.nav_send:
                sendMail();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
