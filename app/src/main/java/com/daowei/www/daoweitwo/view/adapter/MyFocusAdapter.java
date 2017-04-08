package com.daowei.www.daoweitwo.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by douwei on 2017/2/28.
 */
public class MyFocusAdapter extends FragmentPagerAdapter {
    private int num = 0;

    private String tabTitles[]={"我关注的服务("+num+")","我关注的商家("+num+")"};
    private List<Fragment> focusOtherFragment;

    public MyFocusAdapter(FragmentManager fm, List<Fragment> focusOtherFragment) {
        super(fm);
        this.focusOtherFragment = focusOtherFragment;
    }

    public MyFocusAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return focusOtherFragment.get(position);
    }

    @Override
    public int getCount() {
        return focusOtherFragment == null ? 0 :focusOtherFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
