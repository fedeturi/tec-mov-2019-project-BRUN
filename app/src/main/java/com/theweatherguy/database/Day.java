package com.theweatherguy.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "week_forecast")

public class Day {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "day_name")
    private String dayName;

    @ColumnInfo(name = "day_condition")
    private String dayCondition;

    @ColumnInfo(name = "day_max")
    private String dayMaxValue;

    @ColumnInfo(name = "day_min")
    private String dayMinValue;

    public Day() {

    }


    public Day(@NonNull int id, String name, String cond, String max, String min) {
        this.id = id;
        this.dayName = name;
        this.dayCondition = cond;
        this.dayMaxValue = max;
        this.dayMinValue = min;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getDayName() {
        return dayName;
    }

    public void setDayName(@NonNull String dayName) {
        this.dayName = dayName;
    }

    public String getDayCondition() {
        return dayCondition;
    }

    public void setDayCondition(String dayCondition) {
        this.dayCondition = dayCondition;
    }

    public String getDayMaxValue() {
        return dayMaxValue;
    }

    public void setDayMaxValue(String dayMaxValue) {
        this.dayMaxValue = dayMaxValue;
    }

    public String getDayMinValue() {
        return dayMinValue;
    }

    public void setDayMinValue(String dayMinValue) {
        this.dayMinValue = dayMinValue;
    }
}
