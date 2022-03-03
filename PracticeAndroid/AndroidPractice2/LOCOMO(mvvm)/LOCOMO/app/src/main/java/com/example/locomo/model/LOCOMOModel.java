package com.example.locomo.model;

public class LOCOMOModel {
    String dayEndTime;
    String dayStartTime;
    String extendedBreak;
    String mealEndTime;
    String mealStartTime;
    public  LOCOMOModel(){}
    public LOCOMOModel(String dayEndTime, String dayStartTime, String extendedBreak, String mealEndTime, String mealStartTime) {
        this.dayEndTime = dayEndTime;
        this.dayStartTime = dayStartTime;
        this.extendedBreak = extendedBreak;
        this.mealEndTime = mealEndTime;
        this.mealStartTime = mealStartTime;
    }

    public String getDayEndTime() {
        return dayEndTime;
    }

    public void setDayEndTime(String dayEndTime) {
        this.dayEndTime = dayEndTime;
    }

    public String getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(String dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public String getExtendedBreak() {
        return extendedBreak;
    }

    public void setExtendedBreak(String extendedBreak) {
        this.extendedBreak = extendedBreak;
    }

    public String getMealEndTime() {
        return mealEndTime;
    }

    public void setMealEndTime(String mealEndTime) {
        this.mealEndTime = mealEndTime;
    }

    public String getMealStartTime() {
        return mealStartTime;
    }

    public void setMealStartTime(String mealStartTime) {
        this.mealStartTime = mealStartTime;
    }
}
