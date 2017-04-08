package com.daowei.www.daoweitwo.view.myself.bottomactivity.myincome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyIncomeActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.withdraw_deposit)
    TextView withdrawDeposit;
    @BindView(R.id.get_money)
    RelativeLayout getMoney;
    @BindView(R.id.income_balance)
    RelativeLayout incomeBanlance;
    @BindView(R.id.income_details)
    RelativeLayout incomeDetails;
    @BindView(R.id.income_account)
    RelativeLayout incomeAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_income);
        ButterKnife.bind(this);
        withdrawDeposit.setOnClickListener(this);
        getMoney.setOnClickListener(this);
        incomeBanlance.setOnClickListener(this);
        incomeDetails.setOnClickListener(this);
        incomeAccount.setOnClickListener(this);
    }
    public void myIncomeBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.withdraw_deposit:
                startActivity(new Intent(MyIncomeActivity.this,IncomeBalanceActivity.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break;
            case R.id.get_money:
                startActivity(new Intent(MyIncomeActivity.this,GetMoney.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break;
            case R.id.income_balance:
                startActivity(new Intent(MyIncomeActivity.this,IncomeBalanceActivity.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break;
            case R.id.income_details:
                startActivity(new Intent(MyIncomeActivity.this,IncomeDetailsActivity.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break;
            case R.id.income_account:
                startActivity(new Intent(MyIncomeActivity.this,IncomeAccount.class));
                overridePendingTransition(R.anim.zoomin,R.anim.zoomout);
                break;
        }
    }
}
