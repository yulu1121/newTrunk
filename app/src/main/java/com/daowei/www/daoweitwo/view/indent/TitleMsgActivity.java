package com.daowei.www.daoweitwo.view.indent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.daowei.www.daoweitwo.MainActivity;
import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TitleMsgActivity extends AppCompatActivity {
    @BindView(R.id.msg_to_indent)
    ImageButton msgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_msg);
        ButterKnife.bind(this);
        msgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);


            }
        });
    }

}
