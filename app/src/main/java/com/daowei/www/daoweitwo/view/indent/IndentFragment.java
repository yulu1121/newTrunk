package com.daowei.www.daoweitwo.view.indent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.daowei.www.daoweitwo.MainActivity;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.view.adapter.MyIndentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/20 0020.
 */

public class IndentFragment extends Fragment {
    Context context;
    @BindView(R.id.indent_view_pager)
    ViewPager viewPager;
    @BindView(R.id.indent_tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.title_cart)
    ImageButton btnCar;
    @BindView(R.id.title_msg)
    ImageButton btnMg;
    private FragmentManager fragmentManager;
    private List<Fragment> otherFragmentList = new ArrayList<>();


    public static IndentFragment newInstance() {
        return new IndentFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_indent, container, false);
        ButterKnife.bind(this, view);
        initIndentFragment();
        initTabAndViewPager();
        listener();
        return view;
    }

    private void listener() {
        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                startActivity(new Intent(mainActivity, TitleCarActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);

            }
        });
        btnMg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                startActivity(new Intent(mainActivity, TitleMsgActivity.class));
                mainActivity.overridePendingTransition(R.anim.zoomin, R.anim.zoomout);


            }
        });
    }

    public void initIndentFragment() {
        otherFragmentList.add(OtherFragment.newInstance());
        otherFragmentList.add(OtherFragment.newInstance());
        otherFragmentList.add(OtherFragment.newInstance());
        otherFragmentList.add(OtherFragment.newInstance());
        otherFragmentList.add(OtherFragment.newInstance());
    }

    public void initTabAndViewPager() {
        fragmentManager = getChildFragmentManager();
        MyIndentAdapter myIndentAdapter = new MyIndentAdapter(fragmentManager, otherFragmentList);
        viewPager.setAdapter(myIndentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


}

