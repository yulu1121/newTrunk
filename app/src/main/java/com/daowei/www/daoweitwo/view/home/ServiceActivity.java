package com.daowei.www.daoweitwo.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.androidkun.xtablayout.XTabLayout;
import com.daowei.www.daoweitwo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceActivity extends AppCompatActivity {
    @BindView(R.id.service_tab)
    XTabLayout tabLayout;
    @BindView(R.id.service_vp)
    ViewPager viewPager;
    @BindView(R.id.service_toolbar)
    Toolbar toolbar;
    private FragViewPagerAdapter adapter;
    private List<Fragment> mlist = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private String itemID;
    private String serviceId;
    ServiceFraOne fraOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("formation");
        itemID = bundle.getString("itemId");
        serviceId=bundle.getString("serviceId");
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
        setTitle("");
        initFrag();
        initView();
    }
    private void initFrag(){
        ServiceFraTwo fraTwo = ServiceFraTwo.newInstance(itemID);
        fraOne = ServiceFraOne.newInstance(itemID);
        mlist.add(fraOne);
        mlist.add(fraTwo);
        mlist.add(ServiceFraThree.newInstance(serviceId));
        fraOne.setOnButtonClick(new ServiceFraOne.OnButtonClick() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1,true);
            }
        });
        titleList.add("服务");
        titleList.add("详情");
        titleList.add("评价");
    }
    private void initView() {
        adapter = new FragViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void endThis(View view) {
        finish();
    }

    public void onClickShare(View view) {
        fraOne.share();
    }
    class FragViewPagerAdapter extends FragmentPagerAdapter{

        public FragViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public int getCount() {
            return null==mlist?0:mlist.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }
}
