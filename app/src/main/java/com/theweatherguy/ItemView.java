package com.theweatherguy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theweatherguy.R;

public class ItemView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_item);
    }
}
