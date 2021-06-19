package com.example.androidhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChinaFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_food);
    }

    public void showBeijingFood(View view) {
        Intent intent = new Intent(this,BeijingFood.class);
        startActivity(intent);
    }

    public void showChengduFood(View view) {
        Intent intent = new Intent(this,ChengduFood.class);
        startActivity(intent);
    }

    public void showXianFood(View view) {
        Intent intent = new Intent(this,XianFood.class);
        startActivity(intent);
    }
}