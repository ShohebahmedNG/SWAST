package com.example.swast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchFood extends AppCompatActivity implements View.OnClickListener {
    Button searchbtn;
    ImageButton homebtn;
    RecyclerView rv;
    AutoCompleteTextView actv;
    DataBaseHelper db;
    ArrayList<String> calorie, foodname, foodtype;
    SearchCalorieAdapter caloriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food);
        searchbtn = (Button) findViewById(R.id.search_button2);
        homebtn = (ImageButton) findViewById(R.id.home_button3);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchFood.this,MainActivity.class);
                SearchFood.this.startActivity(intent);
            }
        });
        rv = findViewById(R.id.rv_search);
        actv = findViewById(R.id.actv);
        calorie = new ArrayList<>();
        foodname = new ArrayList<>();
        foodtype = new ArrayList<>();
        searchbtn.setOnClickListener(this);
        caloriesAdapter = new SearchCalorieAdapter(SearchFood.this, calorie, foodname, foodtype);
        rv.setAdapter(caloriesAdapter);
        rv.setLayoutManager(new LinearLayoutManager(SearchFood.this));
    }

    public void onClick(View view) {
        if(view.equals(searchbtn)) {
            String fdname = actv.getText().toString();
            try {
                db = new DataBaseHelper(SearchFood.this);
                Cursor cursor = db.search(fdname);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getBaseContext(), "No Data exists for " + fdname, Toast.LENGTH_SHORT).show();
                } else {
                    while (cursor.moveToNext()) {
                        calorie.add(cursor.getString(2));
                        foodname.add(cursor.getString(0));
                        foodtype.add(cursor.getString(1));
                    }
                }

            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Data of " + fdname + " does'nt exist", Toast.LENGTH_SHORT).show();
            }
        }
    }
}