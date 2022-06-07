package com.example.swast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalorieEstimation extends AppCompatActivity {

    Button searchbtn, addbtn, viewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_estimation);
        searchbtn = (Button) findViewById(R.id.search_button);
        addbtn = (Button) findViewById(R.id.add_button);
        viewbtn = (Button) findViewById(R.id.viewlall_button);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalorieEstimation.this,AddNewFood.class);
                CalorieEstimation.this.startActivity(intent);
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalorieEstimation.this,ViewFoodChart.class);
                CalorieEstimation.this.startActivity(intent);
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalorieEstimation.this,SearchFood.class);
                CalorieEstimation.this.startActivity(intent);
            }
        });
    }
}