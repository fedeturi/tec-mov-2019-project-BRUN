package com.theweatherguy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WeekForecastFragment extends Fragment {


    private ArrayList<WeekDay> weekDaysList;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_week_forecast, container, false);

        mRecyclerView = rootView.findViewById(R.id.recycler_view_week_list);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast toast = Toast.makeText(getActivity(), getString(R.string.under_construction), Toast.LENGTH_SHORT);
        toast.show();
        initWeekDaysList();

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mAdapter = new Adapter(weekDaysList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initWeekDaysList() {
        weekDaysList = new ArrayList<>();

        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));
        weekDaysList.add(new WeekDay(R.drawable.ic_today_black_24dp, "Monday", "Sunny", "30", "ºC", "24", "ºC"));


    }

}
