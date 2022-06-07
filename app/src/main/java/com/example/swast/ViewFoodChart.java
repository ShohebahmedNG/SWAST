package com.example.swast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewFoodChart extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    RecyclerView rv;
    ArrayList<String> calorie, foodname, foodtype;
    CaloriesAdapter caloriesAdapter;

    ImageButton homebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food_chart);
        homebtn = (ImageButton) findViewById(R.id.home_button);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewFoodChart.this,MainActivity.class);
                ViewFoodChart.this.startActivity(intent);
            }
        });
        rv = findViewById(R.id.rv_viewall);
        dataBaseHelper = new DataBaseHelper(ViewFoodChart.this);
        calorie = new ArrayList<>();
        foodname = new ArrayList<>();
        foodtype = new ArrayList<>();
        storeDataInArrays();

        caloriesAdapter = new CaloriesAdapter(ViewFoodChart.this, calorie, foodname, foodtype);
        rv.setAdapter(caloriesAdapter);
        rv.setLayoutManager(new LinearLayoutManager(ViewFoodChart.this));
    }

    void storeDataInArrays() {
        Cursor cursor = dataBaseHelper.readAllData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext()) {
                calorie.add(cursor.getString(2));
                foodname.add(cursor.getString(0));
                foodtype.add(cursor.getString(1));

            }
        }
    }
}