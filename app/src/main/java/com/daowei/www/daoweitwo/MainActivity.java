package com.daowei.www.daoweitwo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.daowei.www.daoweitwo.utils.DesityUtil;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.category.CategoryFragment;
import com.daowei.www.daoweitwo.view.home.HomeFragment;
import com.daowei.www.daoweitwo.view.indent.IndentFragment;
import com.daowei.www.daoweitwo.view.myself.MyselfFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private List<Fragment> fragmentList;
    @BindView(R.id.main_rg)
    RadioGroup mRadioGroup;
    @BindView(R.id.main_home_button)
    RadioButton homeRadioBtn;
    @BindView(R.id.main_category_button)
    RadioButton categoryRadioBtn;
    @BindView(R.id.main_indent_button)
    RadioButton indentRadioBtn;
    @BindView(R.id.main_mysekf_button)
    RadioButton myRadioBtn;
    private HomeFragment mHomefragment;
    private CategoryFragment mCategoryFra;
    private IndentFragment mIndentFra;
    private MyselfFragment mMyFra;
    private Fragment mCurrentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initScreen();
        //初始化butterknife
        ButterKnife.bind(this);
        initFragments();
        initClick();
        listener();
    }
    private void initClick() {
        fragmentManager.beginTransaction().add(R.id.main_frame_layout,mHomefragment).commit();
        homeRadioBtn.setTextColor(Color.RED);
        homeRadioBtn.setChecked(true);
    }
    /**
     * 获取屏幕宽度
     */
    public  void initScreen(){
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dp = DesityUtil.px2dip(this, width);
        SharedPreferenceUtils.saveInt(this,"width",dp);
        SharedPreferenceUtils.saveInt(this,"height",height);
    }
    private void initFragments() {
        fragmentList = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
        mHomefragment = HomeFragment.newInstance();
        mCategoryFra = CategoryFragment.newInstance();
        mIndentFra = IndentFragment.newInstance();
        mMyFra = MyselfFragment.newInstance();
        fragmentList.add(mHomefragment);
        fragmentList.add(mCategoryFra);
        fragmentList.add(mIndentFra);
        fragmentList.add(mMyFra);
        mCurrentFragment = mHomefragment;}


    private void listener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_home_button:
                        setFragment(mHomefragment);
                        setColor();
                        homeRadioBtn.setTextColor(Color.RED);
                        break;
                    case R.id.main_category_button:
                        setColor();
                        categoryRadioBtn.setTextColor(Color.RED);
                        setFragment(mCategoryFra);
                        break;
                    case R.id.main_indent_button:
                        setColor();
                        indentRadioBtn.setTextColor(Color.RED);
                        setFragment(mIndentFra);
                        break;
                    case R.id.main_mysekf_button:
                        setColor();
                        myRadioBtn.setTextColor(Color.RED);
                        setFragment(mMyFra);
                        break;
                }
            }
        });
    }

        private void setColor(){
        homeRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
        categoryRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
        indentRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
        myRadioBtn.setTextColor(ContextCompat.getColor(this,R.color.colorOfRadioBtn));
    }

    private void setFragment(Fragment fragment){
        if(!fragment.isAdded()){
            fragmentManager.beginTransaction().hide(mCurrentFragment).add(R.id.main_frame_layout,fragment).commit();
        }else{
            fragmentManager.beginTransaction().hide(mCurrentFragment).show(fragment).commit();
        }
        mCurrentFragment = fragment;
    }

}
