package com.daowei.www.daoweitwo.view.myself.headactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SetPassWordActivity extends AppCompatActivity {
    @BindView(R.id.back_to_left)
    ImageButton setPassWordBack;
    @BindView(R.id.new_password)
    EditText newPassWord;
    @BindView(R.id.again_paddword)
    EditText againPassWord;
    @BindView(R.id.btn_sure)
    Button sureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pass_word);
        ButterKnife.bind(this);
        listener();
    }

    public void listener(){
        setPassWordBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
            }
        });
    }
}
