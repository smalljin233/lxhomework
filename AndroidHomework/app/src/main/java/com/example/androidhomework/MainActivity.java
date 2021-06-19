package com.example.androidhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showChinaView(View view) {
        Intent intent = new Intent(MainActivity.this,ChinaScenery.class);
        startActivity(intent);
    }

    public void showChinaCulture(View view) {
        Intent intent = new Intent(MainActivity.this,ChinaCulture.class);
        startActivity(intent);
    }

    public void showChinaFood(View view) {
        Intent intent = new Intent(MainActivity.this,ChinaFood.class);
        startActivity(intent);
    }

    public void enterMyDinary(View view) {
        Intent intent = new Intent(MainActivity.this,MyDinary.class);
        startActivity(intent);
    }
}