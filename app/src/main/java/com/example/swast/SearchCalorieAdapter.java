package com.example.swast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchCalorieAdapter extends RecyclerView.Adapter<SearchCalorieAdapter.ViewHolder> {
    Context context;
    ArrayList calories, foodname, foodtype;
    List<CalorieModel> calorieModelList;
    RecyclerView rv;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView calories,foodname,foodtype;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            calories = itemView.findViewById(R.id.calorieTextbox);
            foodname = itemView.findViewById(R.id.foodNameTextbox);
            foodtype = itemView.findViewById(R.id.foodTypeTextbox);
        }
    }

    SearchCalorieAdapter(Context context, ArrayList calories, ArrayList foodname, ArrayList foodtype) {
        this.context = context;
        this.calories = calories;
        this.foodname = foodname;
        this.foodtype = foodtype;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.one_line_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.calories.setText(String.valueOf(calories.get(position)));
        viewHolder.foodname.setText(String.valueOf(foodname.get(position)));
        viewHolder.foodtype.setText(String.valueOf(foodtype.get(position)));
    }

    @Override
    public int getItemCount() {
        return foodname.size();
    }
}

