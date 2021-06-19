package com.example.androidhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChinaCulture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_culture);
    }

    public void showBianlian(View view) {
        Intent intent = new Intent(this,Bianlian.class);
        startActivity(intent);
    }

    public void showYueju(View view) {
        Intent intent = new Intent(this,Yueju.class);
        startActivity(intent);
    }

    public void showChuitang(View view) {
        Intent intent = new Intent(this,Chuitangren.class);
        startActivity(intent);
    }
}