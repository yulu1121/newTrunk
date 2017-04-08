package com.daowei.www.daoweitwo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.view.category.CommonFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CateDetailsActivity extends AppCompatActivity {
    private static final String TAG = "111";
    @BindView(R.id.activity_cate_details_tl)
    TabLayout mTablayout;
    @BindView(R.id.activity_cate_details_vp)
    ViewPager mFragmentVP;
    @BindView(R.id.activity_cate_details_btn1)
    RadioButton mRadioBtn1;
    @BindView(R.id.activity_cate_details_btn2)
    RadioButton mRadioBtn2;
    @BindView(R.id.activity_cate_details_rg)
    RadioGroup mRadioGroup;
    @BindView(R.id.activity_cate_details_back)
    ImageView mBackBtn;
    //当前tablayout 被选中的tab的位置
    private int mCurrentPosition;
    //tablayout 标题集合
    private List<String> mTabList;
    //按钮一所对应的fragment集合
    private List<CommonFragment> mLeftFragList;
    //按钮二所对应的fragment集合
    private List<CommonFragment> mRightFragList;
    //传递给viewpager的集合
    private List<CommonFragment> mListOfAll;
    private FragmentManager supportFragmentManager;
    private MyFragmentAdapter fragmentAdapter;
    private List<Boolean> fragmentsUpdateFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate_details);
        ButterKnife.bind(this);
        mRadioBtn1.setChecked(true);
        mRadioBtn1.setTextColor(Color.WHITE);
        mRadioBtn2.setTextColor(ContextCompat.getColor(CateDetailsActivity.this,R.color.category_item_radio_btn));
        initDatas();
        listener();
    }

    private void listener() {
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.activity_cate_details_btn1 :
                        //当点击左边的button时，刷新tablayout
                        mListOfAll.clear();
                        mListOfAll.addAll(mLeftFragList);
                        fragmentAdapter.notifyDataSetChanged();
                        mRadioBtn1.setTextColor(Color.WHITE);
                        mRadioBtn2.setTextColor(ContextCompat.getColor(CateDetailsActivity.this,R.color.category_item_radio_btn));
                        break;                                                                                                                                                                                                          
                    case R.id.activity_cate_details_btn2:
                        //当点击右边的button时，加载商家的内容到tablayout上
                        mListOfAll.clear();
                        mListOfAll.addAll(mRightFragList);
                        fragmentAdapter.notifyDataSetChanged();
                        mRadioBtn2.setTextColor(Color.WHITE);
                        mRadioBtn1.setTextColor(ContextCompat.getColor(CateDetailsActivity.this,R.color.category_item_radio_btn));
                        break;
                }
            }
        });
    }

    private void initDatas() {
        fragmentsUpdateFlag = new ArrayList<>();
        mLeftFragList = new ArrayList<>();
        mRightFragList = new ArrayList<>();
        mListOfAll = new ArrayList<>();
        mTabList = new ArrayList<>();
        supportFragmentManager = getSupportFragmentManager();
        //通过intent获取传递过来的值
        Intent intent = this.getIntent();
        Bundle extras = intent.getExtras();
        String name1 = extras.getString("name");
        mRadioBtn1.setText(name1);
        List<CategoryBean.DataBean.TagsBean> list = (List<CategoryBean.DataBean.TagsBean>)extras.getSerializable("list");
        mTabList.add("全部");
        mLeftFragList.add(CommonFragment.newInstance("left",list,0));
        mRightFragList.add(CommonFragment.newInstance("right",list,0));
        fragmentsUpdateFlag.add(false);
        //获得gridview中被点击的视图的位置
        int position = extras.getInt("position");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String name = list.get(i).getName();
            mTabList.add(name);
            fragmentsUpdateFlag.add(false);
            mLeftFragList.add(CommonFragment.newInstance("left",list,i+1));
            mRightFragList.add(CommonFragment.newInstance("right",list,i+1));
        }
        //第一次跳转进入这个activity时tablayout所拥有的内容
        mListOfAll.addAll(mLeftFragList);
        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        fragmentAdapter = new MyFragmentAdapter(supportFragmentManager);
        mFragmentVP.setAdapter(fragmentAdapter);
        mTablayout.setupWithViewPager(mFragmentVP);
        TabLayout.Tab tab = mTablayout.getTabAt(position+1);
        tab.select();
        mCurrentPosition = position+1;
    }

    class MyFragmentAdapter extends FragmentStatePagerAdapter{
        FragmentManager fm;
        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return mListOfAll.get(position);
        }

        @Override
        public int getCount() {
            return mListOfAll == null ? 0 : mListOfAll.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        /**此方法来源于http://blog.csdn.net/z13759561330/article/details/40737381
         * @param
         * @param position
         * @return
         */
//        @Override
//        public Object instantiateItem(ViewGroup container, int position) {
//            Fragment fragment = (Fragment) super.instantiateItem(container, position);
//            String fragmentTag = fragment.getTag();
//            if (fragmentsUpdateFlag.get(position)) {
//                //如果这个fragment需要更新
//                FragmentTransaction ft = fm.beginTransaction();
//                //移除旧的fragment
//                ft.remove(fragment);
//                //换成新的fragment
//                fragment = mListOfAll.get(position);
//                //添加新fragment时必须用前面获得的tag，这点很重要
//                if(!fragment.isAdded()){
//                    ft.add(container.getId(), fragment,fragmentTag);
//                    ft.attach(fragment);
//                    ft.commitAllowingStateLoss();
//                }
//                //复位更新标志
//                fragmentsUpdateFlag.set(position,false);
//            }
//            return fragment;
//        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTabList.get(position);
        }
    }
}
