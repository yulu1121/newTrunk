package com.daowei.www.daoweitwo.view.myself.bottomactivity.myincome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IncomeBalanceActivity extends AppCompatActivity {
    @BindView(R.id.check_zfb)
    ImageView checkZfb;
    @BindView(R.id.check_balance)
    ImageView checkBalance;
    @BindView(R.id.check_bank)
    ImageView checkBank;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.edit_money)
    EditText editMoney;
    @BindView(R.id.money_num)
    TextView moneyNum;
    @BindView(R.id.withdraw_deposit_all)
    TextView withdrawDepositAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_balance);
        ButterKnife.bind(this);
        checkBalance.setImageResource(R.drawable.img_regist_checkbox_checked);
       listener();
    }

    public void btnBack(View view) {
        finish();
        overridePendingTransition(R.anim.zoomcarin, R.anim.zoomcarout);
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.check_zfb:
                checkZfb.setImageResource(R.drawable.img_regist_checkbox_checked);
                checkBalance.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                checkBank.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                break;
            case R.id.check_balance:
                checkZfb.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                checkBalance.setImageResource(R.drawable.img_regist_checkbox_checked);
                checkBank.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                break;
            case R.id.check_bank:
                checkZfb.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                checkBalance.setImageResource(R.drawable.img_regist_checkbox_unchecked);
                checkBank.setImageResource(R.drawable.img_regist_checkbox_checked);
                break;

            case R.id.button:
                String num = editMoney.getText().toString();
                if (num == null || num.equals("")) {
                    Toast.makeText(this, "请输入提现金额", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "提现成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void listener() {
        withdrawDepositAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String money = moneyNum.getText().toString();
                float parseFloat = Float.parseFloat(money);
                if (parseFloat<=0){
                    Toast.makeText(IncomeBalanceActivity.this, "余额不足", Toast.LENGTH_SHORT).show();
                }else {
                    editMoney.setText(moneyNum.getText());
                    moneyNum.setText("0.00");
                }

            }
        });
    }


}
