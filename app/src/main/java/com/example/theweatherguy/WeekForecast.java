package com.example.theweatherguy;

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

public class WeekForecast extends Fragment {


    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //Solo usar el onCreate en fragments cuando tenemos que inicializar una instancia o recibir argumentos de otro fragment
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week_forecast, container, false);

        // Una vez inflada la vista, ahora si podemos bindear los elementos que luego se van a usar en el onViewCreated
        mRecyclerView = view.findViewById(R.id.weather_rv);
        return view;
    }

    // Este onViewCreated es el que se usa como el onCreate() en los Fragments
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast toast = Toast.makeText(getActivity(),getString(R.string.under_construction),Toast.LENGTH_SHORT);
        toast.show();

        ArrayList<RecyclerViewItem> exampleList = new ArrayList<>();
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Monday", "33º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Tuesday", "30º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Wednesday", "30º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Thursday", "27º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Friday", "33º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Saturday", "30º"));
        exampleList.add(new RecyclerViewItem(R.drawable.ic_today_black_24dp, "Sunday", "27º"));


        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mAdapter = new Adapter(exampleList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
