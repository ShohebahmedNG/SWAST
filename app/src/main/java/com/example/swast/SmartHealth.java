package com.example.swast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SmartHealth extends AppCompatActivity {
    LinearLayout calobtn,medrbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_health);
        calobtn = (LinearLayout) findViewById(R.id.caloriestimation_button);
        calobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SmartHealth.this,CalorieEstimation.class);
                SmartHealth.this.startActivity(intent);
            }
        });
        medrbtn = (LinearLayout) findViewById(R.id.medrem_button);
        medrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SmartHealth.this,MedicineReminder.class);
                SmartHealth.this.startActivity(intent);
            }
        });
    }
}