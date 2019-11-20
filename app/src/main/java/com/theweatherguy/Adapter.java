
package com.theweatherguy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<WeekDay> arrayListOfItems;

    public Adapter(ArrayList<WeekDay> listOfDays) {
        arrayListOfItems = listOfDays;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                parent, false);
        ViewHolder vHolder = new ViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        WeekDay currentItem = arrayListOfItems.get(position);

        holder.dayAnimation.setImageResource(currentItem.getDayAnimation());
        holder.dayName.setText(currentItem.getDayName());
        holder.dayCondition.setText(currentItem.getDayCondition());
        holder.dayMaxValue.setText(currentItem.getDayMaxValue());
        holder.dayMaxUnits.setText(currentItem.getDayMaxValueUnits());
        holder.dayMinValue.setText(currentItem.getDayMinValue());
        holder.dayMinUnits.setText(currentItem.getDayMinValueUnits());

    }

    @Override
    public int getItemCount() {

        return arrayListOfItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView dayAnimation;
        public TextView dayName;
        public TextView dayCondition;

        public TextView dayMaxValue;
        public TextView dayMaxUnits;

        public TextView dayMinValue;
        public TextView dayMinUnits;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dayAnimation = itemView.findViewById(R.id.list_item_animation);
            dayName = itemView.findViewById(R.id.list_item_title);
            dayCondition = itemView.findViewById(R.id.list_item_subtitle);
            dayMaxValue = itemView.findViewById(R.id.list_item_max_value);
            dayMaxUnits = itemView.findViewById(R.id.list_item_max_units);
            dayMinValue = itemView.findViewById(R.id.list_item_min_value);
            dayMinUnits = itemView.findViewById(R.id.list_item_min_units);

        }
    }
}