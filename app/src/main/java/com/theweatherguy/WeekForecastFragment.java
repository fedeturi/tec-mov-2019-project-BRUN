package com.theweatherguy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theweatherguy.R;

import java.util.ArrayList;

public class WeekForecastFragment extends Fragment {


    private ArrayList<WeekDay> weekDaysList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_week_forecast, container, false);
        initWeekDaysList();
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_week_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListAdapter(weekDaysList));

        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL));


        return rootView;
    }


    private void initWeekDaysList() {
        weekDaysList = new ArrayList<>();

        weekDaysList.add(new WeekDay("Monday", "Sunny", 30, 24));
        weekDaysList.add(new WeekDay("Tuesday", "Sunny", 31, 29));
        weekDaysList.add(new WeekDay("Wednesday", "Cloudy", 28, 23));
        weekDaysList.add(new WeekDay("Thursday", "Sunny", 29, 26));
        weekDaysList.add(new WeekDay("Friday", "Partly Cloudy", 29, 27));
        weekDaysList.add(new WeekDay("Saturday", "Sunny", 31, 19));
        weekDaysList.add(new WeekDay("Sunday", "Rainy", 30, 25));
    }

}
