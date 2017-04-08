package com.daowei.www.daoweitwo.view.myself.bottomactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreActivity extends AppCompatActivity {
    @BindView(R.id.give_our_evaluate)
    RelativeLayout giveOurEvaluate;
    @BindView(R.id.user_agreement)
    RelativeLayout userAgreement;
    @BindView(R.id.clean_picture)
    RelativeLayout cleanPicture;
    @BindView(R.id.about_our)
    RelativeLayout aboutOur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
    }

    public void moreBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

}
