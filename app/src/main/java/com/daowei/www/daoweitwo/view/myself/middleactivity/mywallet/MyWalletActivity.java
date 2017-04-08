package com.daowei.www.daoweitwo.view.myself.middleactivity.mywallet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daowei.www.daoweitwo.R;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyWalletActivity extends AppCompatActivity {
    @BindView(R.id.img_wx)
    ImageView img_wx;
    @BindView(R.id.img_zfb)
    ImageView img_zfb;
    @BindView(R.id.img_ywt)
    ImageView img_ywt;
    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.cz_text)
    TextView czText;
    @BindView(R.id.wallet_details)
    TextView walletDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_wallet);
        ButterKnife.bind(this);
        //默认微信为首选付款方式
        img_wx.setImageResource(R.drawable.img_regist_checkbox_checked);
        listener();

    }


    public void myWalletBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

    public void onClick(View v){

        int id = v.getId();
        switch (id){
            case R.id.img_wx:
                img_wx.setImageResource(R.drawable.img_regist_checkbox_checked);
                img_zfb.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                img_ywt.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                break;
            case R.id.img_zfb:
                img_zfb.setImageResource(R.drawable.img_regist_checkbox_checked);
                img_ywt.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                img_wx.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                break;
            case R.id.img_ywt:
                img_ywt.setImageResource(R.drawable.img_regist_checkbox_checked);
                img_zfb.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                img_wx.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                break;
        }

    }

    public void listener(){
        czText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = editText.getText().toString();
                if (num==null||num.equals("")){
                    Toast.makeText(MyWalletActivity.this, "请输入充值金额", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MyWalletActivity.this, "已充值", Toast.LENGTH_SHORT).show();
                }
            }
        });
        walletDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyWalletActivity.this,WalletDetalisActivity.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
            }
        });

    }


}
