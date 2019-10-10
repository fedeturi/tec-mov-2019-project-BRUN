package com.example.theweatherguy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeekForecast extends Fragment {

    /*
    private RecyclerView.LayoutManager mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    */

    /*TODO CHange to Recycler View
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<RecyclerViewItem> exampleList = new ArrayList<>();
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Monday", "33º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Tuesday", "30º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Wednesday", "30º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Thursday", "27º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Friday", "33º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Saturday", "30º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Sunday", "27º"));

        mRecyclerView = getView().findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new Adapter(exampleList);
    }*/

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast toast = Toast.makeText(getActivity(),getString(R.string.under_construction),Toast.LENGTH_SHORT);
        toast.show();
        return inflater.inflate(R.layout.fragment_week_forecast, container, false);
    }
}
