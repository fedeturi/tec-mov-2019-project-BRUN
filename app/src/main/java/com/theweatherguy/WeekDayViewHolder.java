package com.theweatherguy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.theweatherguy.R;

public class WeekDayViewHolder extends RecyclerView.ViewHolder {

    private LottieAnimationView weatherAnimation = null;
    private ImageView weatherImageDebugging;
    private TextView dayName;
    private TextView dayCondition;
    private TextView maxTemperature;
    private TextView minTemperature;
    private TextView maxUnits;
    private TextView minUnits;


    public WeekDayViewHolder(@NonNull View itemView) {
        super(itemView);
        weatherImageDebugging = itemView.findViewById(R.id.list_item_animation);
        dayName = itemView.findViewById(R.id.list_item_title);
        dayCondition = itemView.findViewById(R.id.list_item_subtitle);
        maxTemperature = itemView.findViewById(R.id.list_item_max_value);
        maxUnits = itemView.findViewById(R.id.list_item_max_units);
        minTemperature = itemView.findViewById(R.id.list_item_min_value);
        minUnits = itemView.findViewById(R.id.list_item_min_units);
    }

    public LottieAnimationView getWeatherAnimation() {
        return weatherAnimation;
    }

    public void setWeatherAnimation(LottieAnimationView weatherAnimation) {
        this.weatherAnimation = weatherAnimation;
    }

    public ImageView getWeatherImageDebugging() {
        return weatherImageDebugging;
    }

    public void setWeatherImageDebugging(ImageView weatherImageDebugging) {
        this.weatherImageDebugging = weatherImageDebugging;
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

    public TextView getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(TextView maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public TextView getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(TextView minTemperature) {
        this.minTemperature = minTemperature;
    }

    public TextView getMaxUnits() {
        return maxUnits;
    }

    public void setMaxUnits(TextView maxUnits) {
        this.maxUnits = maxUnits;
    }

    public TextView getMinUnits() {
        return minUnits;
    }

    public void setMinUnits(TextView minUnits) {
        this.minUnits = minUnits;
    }


}
