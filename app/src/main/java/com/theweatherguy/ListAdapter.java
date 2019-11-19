package com.theweatherguy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theweatherguy.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<WeekDayViewHolder> {

    private List<WeekDay> data;

    public ListAdapter(List<WeekDay> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public WeekDayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new WeekDayViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekDayViewHolder holder, int position) {
        WeekDay weekDay = data.get(position);
        holder.getDayName().setText(weekDay.getDayName());
        holder.getDayCondition().setText(weekDay.getDayCondition());
        holder.getMaxTemperature().setText(weekDay.getMaxTemp());
        holder.getMinTemperature().setText(weekDay.getMinTemp());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface RecyclerViewOnItemClickListener {
        void onItemClick(int position);
    }

}


