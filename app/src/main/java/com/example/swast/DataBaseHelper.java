package com.example.swast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_CALORIE = "CALORIE";
    public static final String CALORIE_TABLE = COLUMN_CALORIE + "_TABLE";
    public static final String COLUMN_FOOD_TYPE = "FOOD_TYPE";
    public static final String COLUMN_FOOD_NAME = "FOOD_NAME";
    List<CalorieModel> calorieModelList = new ArrayList<>();

    public DataBaseHelper(@Nullable Context context) {
        super(context, "calories.db", null, 1);
    }

    //This is used first time a database is accessed.There should be code in here to create a new database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + CALORIE_TABLE + " (" + COLUMN_FOOD_NAME + " TEXT PRIMARY KEY, " + COLUMN_FOOD_TYPE + " TEXT, " + COLUMN_CALORIE + " INTEGER)";
        db.execSQL(createTableStatement);
    }

    //This is called if the database version number changes. It prevents previous user's aps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
    public boolean addOne(CalorieModel calorieModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FOOD_NAME, calorieModel.getFood_name());
        cv.put(COLUMN_FOOD_TYPE, calorieModel.getFood_type());
        cv.put(COLUMN_CALORIE, calorieModel.getCalories());

        long insert = db.insert(CALORIE_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*public List<CalorieModel> getAllFood() {
        List<CalorieModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + CALORIE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()) {
            do {
                String FoodName = cursor.getString(0);
                String FoodType = cursor.getString(1);
                int Calorie = cursor.getInt(2);

                CalorieModel newCalorie = new CalorieModel(FoodName,FoodType,Calorie);
                returnList.add(newCalorie);
            }while(cursor.moveToNext());
        }
        else {

        }
        cursor.close();
        db.close();
        return returnList;
    }*/

    Cursor readAllData() {
        String query = "SELECT * FROM " + CALORIE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null) {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

   Cursor search(String foodName) {
        String query = "SELECT * FROM " + CALORIE_TABLE + " WHERE " + COLUMN_FOOD_NAME + " = '" + foodName + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
       if(db!=null) {
           cursor = db.rawQuery(query,null);
       }
       return cursor;
    }

}
