package com.daowei.www.daoweitwo.view.myself.middleactivity.myfocus;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.androidkun.xtablayout.XTabLayout;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.view.adapter.MyFocusAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyFocusActivity extends AppCompatActivity {
    @BindView(R.id.focus_xtablayout)
    XTabLayout focusXTablayout;
    @BindView(R.id.focus_viewPager)
    ViewPager focusViewPager;
    private FragmentManager fm;
    private List<Fragment> focusFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_focus);
        ButterKnife.bind(this);
        initFragment();
        initTabAndViewPager();
    }

    public void myFocusBack(View view){
        finish();
        overridePendingTransition(R.anim.zoomcarin,R.anim.zoomcarout);
    }

    public void initFragment(){
        focusFragmentList.add(FocusServiceFragment.newInstance());
        focusFragmentList.add(FocusShopFragment.newInstance());

    }



    public void initTabAndViewPager(){
        fm = getSupportFragmentManager();
        MyFocusAdapter myFocusAdapter = new MyFocusAdapter(fm,focusFragmentList);
        focusViewPager.setAdapter(myFocusAdapter);
        focusXTablayout.setupWithViewPager(focusViewPager);

    }
}
