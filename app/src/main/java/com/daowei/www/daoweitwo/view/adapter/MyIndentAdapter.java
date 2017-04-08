package com.daowei.www.daoweitwo.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daowei.www.daoweitwo.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by douwei on 2017/2/20.
 */
public class MyIndentAdapter extends FragmentPagerAdapter {

    private String titles[]  = {"全部", "待付款", "待确认", "进行中", "待评价"};
//    private int[] imageView = {R.drawable.orderlist_header_1, R.drawable.orderlist_header_2, R.drawable.orderlist_header_3,
//            R.drawable.orderlist_header_4, R.drawable.orderlist_header_5};
    private List<Fragment> otherFragmentList;

    public MyIndentAdapter(FragmentManager fm,List<Fragment> otherFragmentList) {
        super(fm);
        int length = titles.length;
        this.otherFragmentList = otherFragmentList;
    }


    public MyIndentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return otherFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return otherFragmentList == null ? 0:otherFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    //    public View getTabView(int position) {
//        View v = LayoutInflater.from(context).inflate(R.layout.indent_tab_view, null);
//        ImageView tabImage = (ImageView) v.findViewById(R.id.tab_image);
//        tabImage.setImageResource(imageView[position]);
//        TextView tabText = (TextView) v.findViewById(R.id.tab_text);
//        tabText.setText(titles[position]);
//        return v;
//
//    }
}
