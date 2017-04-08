package com.daowei.www.daoweitwo.view.myself.bottomactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daowei.www.daoweitwo.R;

public class LixiKefuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lixi_kefu);
    }

    public void lixiKefuBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

    public void call(View view){

    }
}
