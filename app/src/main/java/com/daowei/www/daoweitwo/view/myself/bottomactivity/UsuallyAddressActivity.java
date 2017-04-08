package com.daowei.www.daoweitwo.view.myself.bottomactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsuallyAddressActivity extends AppCompatActivity {
    @BindView(R.id.new_add)
    TextView newAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usually_address);
        ButterKnife.bind(this);
    }

    public void usuallyAddressBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }
}
