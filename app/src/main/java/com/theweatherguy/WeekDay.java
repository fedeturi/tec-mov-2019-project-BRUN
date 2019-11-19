package com.theweatherguy;

public class WeekDay {

    private String dayName;
    private String dayCondition;
    private int maxTemp;
    private int minTemp;

    public WeekDay(String dayName, String dayCondition, int maxTemp, int minTemp) {
        this.dayName = dayName;
        this.dayCondition = dayCondition;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayCondition() {
        return dayCondition;
    }

    public void setDayCondition(String dayCondition) {
        this.dayCondition = dayCondition;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }
}
