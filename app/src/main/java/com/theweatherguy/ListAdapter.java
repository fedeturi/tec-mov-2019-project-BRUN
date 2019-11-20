package com.theweatherguy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theweatherguy.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.WeekDayViewHolder> {

    private List<WeekDay> weekForecast;

    public ListAdapter(List<WeekDay> data) {
        this.weekForecast = data;
    }

    @NonNull
    @Override
    public WeekDayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        WeekDayViewHolder viewHolder = new WeekDayViewHolder(row);
        //TODO Por aca esta el error. No se bien como inicializar el ViewHolder con mis Views

        //ImageView dayAnimation =
        //viewHolder.setDayAnimation((ImageView))
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeekDayViewHolder holder, int position) {
        WeekDay weekDay = weekForecast.get(position);
        holder.getDayName().setText(weekDay.getDayName());
        holder.getDayCondition().setText(weekDay.getDayCondition());
        holder.getDayMaxValue().setText(weekDay.getDayMaxValue());
        holder.getDayMaxValueUnits().setText(weekDay.getDayMaxValueUnits());
        holder.getDayMinValue().setText(weekDay.getDayMinValue());
        holder.getDayMinValueUnits().setText(weekDay.getDayMaxValueUnits());

    }

    @Override
    public int getItemCount() {
        return weekForecast.size();
    }

    class WeekDayViewHolder extends RecyclerView.ViewHolder {

        private ImageView dayAnimation;
        private TextView dayName;
        private TextView dayCondition;
        private TextView dayMaxValue;
        private TextView dayMaxValueUnits;
        private TextView dayMinValue;
        private TextView dayMinValueUnits;

        public WeekDayViewHolder(View itemView, ImageView dayAnimation, TextView dayName, TextView dayCondition, TextView dayMaxValue, TextView dayMaxValueUnits, TextView dayMinValue, TextView dayMinValueUnits) {
            super(itemView);
            this.dayAnimation = dayAnimation;
            this.dayName = dayName;
            this.dayCondition = dayCondition;
            this.dayMaxValue = dayMaxValue;
            this.dayMaxValueUnits = dayMaxValueUnits;
            this.dayMinValue = dayMinValue;
            this.dayMinValueUnits = dayMinValueUnits;
        }

        public WeekDayViewHolder(View itemView) {
            super(itemView);
        }

        public ImageView getDayAnimation() {
            return dayAnimation;
        }

        public void setDayAnimation(ImageView dayAnimation) {
            this.dayAnimation = dayAnimation;
        }

        public TextView getDayName() {
            return dayName;
        }

        public void setDayName(TextView dayName) {
            this.dayName = dayName;
        }

        public TextView getDayCondition() {
            return dayCondition;
        }

        public void setDayCondition(TextView dayCondition) {
            this.dayCondition = dayCondition;
        }

        public TextView getDayMaxValue() {
            return dayMaxValue;
        }

        public void setDayMaxValue(TextView dayMaxValue) {
            this.dayMaxValue = dayMaxValue;
        }

        public TextView getDayMaxValueUnits() {
            return dayMaxValueUnits;
        }

        public void setDayMaxValueUnits(TextView dayMaxValueUnits) {
            this.dayMaxValueUnits = dayMaxValueUnits;
        }

        public TextView getDayMinValue() {
            return dayMinValue;
        }

        public void setDayMinValue(TextView dayMinValue) {
            this.dayMinValue = dayMinValue;
        }

        public TextView getDayMinValueUnits() {
            return dayMinValueUnits;
        }

        public void setDayMinValueUnits(TextView dayMinValueUnits) {
            this.dayMinValueUnits = dayMinValueUnits;
        }
    }

}



