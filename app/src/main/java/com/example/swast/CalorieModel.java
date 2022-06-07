package com.example.swast;

public class CalorieModel {
    private String food_name;
    private String food_type;
    private int calories;

    public CalorieModel(String food_name, String food_type, int calories) {

        this.food_name = food_name;
        this.food_type = food_type;
        this.calories = calories;
    }
    public CalorieModel() {

    }

    @Override
    public String toString() {
        return "CalorieModel{" +
                "food_name='" + food_name + '\'' +
                ", food_type='" + food_type + '\'' +
                ", calories=" + calories +
                '}';
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_type() {
        return food_type;
    }

    public void setFood_type(String food_type) {
        this.food_type = food_type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
