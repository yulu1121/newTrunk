package com.daowei.www.daoweitwo;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {
    private boolean isFirst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        isFirst = getSharedPreferences("Lanren", Context.MODE_PRIVATE).getBoolean("isFirst",true);
        if (isFirst) {
            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            getSharedPreferences("Lanren", Context.MODE_PRIVATE).edit().putBoolean("isFirst", false).commit();
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        },4000);
    }
}
