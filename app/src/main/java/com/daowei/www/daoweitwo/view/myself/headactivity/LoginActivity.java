package com.daowei.www.daoweitwo.view.myself.headactivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.user_password_login)
    TextView userPasswordLogin;
    @BindView(R.id.phone_number_login)
    TextView phoneNumberLogin;
    @BindView(R.id.img_clean1)
    ImageView imgClean1;
    @BindView(R.id.img_clean2)
    ImageView imgClean2;
    @BindView(R.id.get_code)
    TextView getCode;
    @BindView(R.id.standby_singal)
    TextView standbySingal;
    @BindView(R.id.forget_password)
    TextView forgetPassword;
    @BindView(R.id.edit1)
    EditText edit1;
    @BindView(R.id.edit2)
    EditText edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        listener();
    }
    public void btnBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

    public void listener(){
        userPasswordLogin.setTextColor(getResources().getColor(R.color.PressAccountTextColor));
        getCode.setVisibility(View.INVISIBLE);
        standbySingal.setVisibility(View.INVISIBLE);
        userPasswordLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColor();
                userPasswordLogin.setTextColor(getResources().getColor(R.color.PressAccountTextColor));
                getCode.setVisibility(View.INVISIBLE);
                standbySingal.setVisibility(View.INVISIBLE);
                forgetPassword.setVisibility(View.VISIBLE);
                edit1.setHint("手机号码或账号昵称");
                edit2.setHint("输入密码");
                edit1.setText("");
                edit2.setText("");


            }
        });

        phoneNumberLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setColor();
                phoneNumberLogin.setTextColor(getResources().getColor(R.color.PressAccountTextColor));
                getCode.setVisibility(View.VISIBLE);
                standbySingal.setVisibility(View.VISIBLE);
                forgetPassword.setVisibility(View.INVISIBLE);
                edit1.setHint("手机号码");
                edit2.setHint("请输入获取的验证码");
                edit1.setText("");
                edit2.setText("");

            }
        });
    }

    public void setColor(){
        userPasswordLogin.setTextColor(getResources().getColor(R.color.login_type));
        phoneNumberLogin.setTextColor(getResources().getColor(R.color.login_type));

    }


  }





