package com.example.swast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddNewFood extends AppCompatActivity {
    Button addbtn,viewbtn;
    ImageButton homebtn;
    EditText fdnametxt,fdtypetxt,calorietxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_food);
        fdnametxt = (EditText) findViewById(R.id.foodNameTextbox);
        fdtypetxt = (EditText) findViewById(R.id.foodTypeTextbox);
        calorietxt = (EditText) findViewById(R.id.calorieTextbox);
        addbtn = (Button) findViewById(R.id.add_button2);
        viewbtn = (Button) findViewById(R.id.viewlall_button2);
        homebtn = (ImageButton) findViewById(R.id.home_button2);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalorieModel calorieModel;

                try {
                    calorieModel = new CalorieModel(fdnametxt.getText().toString(),fdtypetxt.getText().toString(),Integer.parseInt(calorietxt.getText().toString()));
                }
                catch (Exception ex) {
                    Toast.makeText(AddNewFood.this, "Error adding food",Toast.LENGTH_SHORT).show();
                    calorieModel = new CalorieModel("error","error",0);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(AddNewFood.this);
                boolean success = dataBaseHelper.addOne(calorieModel);
                Toast.makeText(AddNewFood.this,"Success = " + success,Toast.LENGTH_SHORT).show();
            }
        });
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewFood.this,ViewFoodChart.class);
                AddNewFood.this.startActivity(intent);
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewFood.this,MainActivity.class);
                AddNewFood.this.startActivity(intent);
            }
        });
    }
}