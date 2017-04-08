package com.daowei.www.daoweitwo.view.myself.middleactivity.useablechit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UseableChitActivty extends AppCompatActivity {
    @BindView(R.id.get_chit_central)
    TextView get_chit_central;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useable_chit_activty);
        ButterKnife.bind(this);
        listener();
    }

    public void useableBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

    public void listener(){
        get_chit_central.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UseableChitActivty.this,GetChitCenter.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
            }
        });
    }
}
