package com.theweatherguy;

public class WeekDay {

    private int dayAnimation;
    private String dayName;
    private String dayCondition;
    private String dayMaxValue;
    private String dayMaxValueUnits;
    private String dayMinValue;
    private String dayMinValueUnits;

    public WeekDay(int dayAnimation, String dayName, String dayCondition, String dayMaxValue, String dayMaxValueUnits, String dayMinValue, String dayMinValueUnits) {
        this.dayAnimation = dayAnimation;
        this.dayName = dayName;
        this.dayCondition = dayCondition;
        this.dayMaxValue = dayMaxValue;
        this.dayMaxValueUnits = dayMaxValueUnits;
        this.dayMinValue = dayMinValue;
        this.dayMinValueUnits = dayMinValueUnits;
    }

    public int getDayAnimation() {
        return dayAnimation;
    }

    public void setDayAnimation(int dayAnimation) {
        this.dayAnimation = dayAnimation;
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

    public String getDayMaxValue() {
        return dayMaxValue;
    }

    public void setDayMaxValue(String dayMaxValue) {
        this.dayMaxValue = dayMaxValue;
    }

    public String getDayMaxValueUnits() {
        return dayMaxValueUnits;
    }

    public void setDayMaxValueUnits(String dayMaxValueUnits) {
        this.dayMaxValueUnits = dayMaxValueUnits;
    }

    public String getDayMinValue() {
        return dayMinValue;
    }

    public void setDayMinValue(String dayMinValue) {
        this.dayMinValue = dayMinValue;
    }

    public String getDayMinValueUnits() {
        return dayMinValueUnits;
    }

    public void setDayMinValueUnits(String dayMinValueUnits) {
        this.dayMinValueUnits = dayMinValueUnits;
    }
}
