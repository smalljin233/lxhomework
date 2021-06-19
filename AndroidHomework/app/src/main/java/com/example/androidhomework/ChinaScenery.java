package com.example.androidhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChinaScenery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_china_scenery);
    }

    public void showTianjinScenery(View view) {
        Intent intent = new Intent(ChinaScenery.this,TianjinScenery.class);
        startActivity(intent);
    }

    public void showXiamengScenery(View view) {
        Intent intent = new Intent(ChinaScenery.this,XiamengScenery.class);
        startActivity(intent);
    }

    public void showXingjiangScenery(View view) {
        Intent intent = new Intent(ChinaScenery.this,XinjiangScenery.class);
        startActivity(intent);
    }
}