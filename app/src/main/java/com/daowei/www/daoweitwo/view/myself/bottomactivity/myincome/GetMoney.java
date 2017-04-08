package com.daowei.www.daoweitwo.view.myself.bottomactivity.myincome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daowei.www.daoweitwo.R;

public class GetMoney extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_money);
    }

    public void btnBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }
}
