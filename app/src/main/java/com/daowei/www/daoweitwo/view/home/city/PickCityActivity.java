package com.daowei.www.daoweitwo.view.home.city;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.module.home.bean.City;
import com.daowei.www.daoweitwo.presenter.CitiesPresenter;
import com.daowei.www.daoweitwo.presenter.home.impl.CitiesPresenterImpl;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.home.MapActivity;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.indexablerv.EntityWrapper;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;
import me.yokeyword.indexablerv.SimpleHeaderAdapter;


/**
 * 选择城市
 * Created by YoKey on 16/10/7.
 */
public class PickCityActivity extends AppCompatActivity implements CitiesPresenter.SendCity2View{
    private List<CityEntity> mDatas=new ArrayList<>();
    private SearchFragment mSearchFragment;
    private SearchView mSearchView;
    private FrameLayout mProgressBar;
    private CitiesPresenter presenter;
    public static final int RESULT_CODE=1;
    CityAdapter adapter;
    private List<CityEntity> hotCityList = new ArrayList<>();
    private List<City.ResultBean.CityListBean> hotCityListing = new ArrayList<>();
    private List<City.ResultBean.CityListBean> cityListBeen = new ArrayList<>();
    private IndexableLayout  indexableLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_city);
        presenter = new CitiesPresenterImpl(this);
        presenter.sendCityData();
        adapter = new CityAdapter(this);
        mSearchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
        indexableLayout = (IndexableLayout) findViewById(R.id.indexableLayout);
        mSearchView = (SearchView) findViewById(R.id.searchview);
        mProgressBar = (FrameLayout) findViewById(R.id.progress);
        // set Datas
        indexableLayout.setAdapter(adapter);
        indexableLayout.setCompareMode(IndexableLayout.MODE_FAST);
        // set Center OverlayView
        indexableLayout.setOverlayStyle_Center();

        // set Listener
        adapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<CityEntity>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, CityEntity entity) {
                if (originalPosition >= 0) {
                    Intent intent = new Intent(PickCityActivity.this, MapActivity.class);
                    intent.putExtra("cityName",entity.getName());
                    PickCityActivity.this.setResult(RESULT_CODE,intent);
                    finish();
                } else {
                    Intent intent = new Intent(PickCityActivity.this, MapActivity.class);
                    intent.putExtra("cityName",entity.getName());
                    PickCityActivity.this.setResult(RESULT_CODE,intent);
                    finish();
                }
            }
        });

        adapter.setOnItemTitleClickListener(new IndexableAdapter.OnItemTitleClickListener() {
            @Override
            public void onItemClick(View v, int currentPosition, String indexTitle) {

            }
        });

    }
    private List<CityEntity> initDatas(List<City.ResultBean.CityListBean> cityList) {
        List<CityEntity> list = new ArrayList<>();
        for (int i = 0; i < cityList.size(); i++) {
            City.ResultBean.CityListBean bean = cityList.get(i);
            CityEntity entity = new CityEntity();
            entity.setId(bean.getCity_id());
            entity.setName(bean.getCity_name());
            list.add(entity);
        }
        return list;
    }

    private List<CityEntity> iniyHotCityDatas(List<City.ResultBean.CityListBean> hotCityListing) {
        List<CityEntity> list = new ArrayList<>();
        for (int i = 0; i < hotCityListing.size(); i++) {
            City.ResultBean.CityListBean bean = hotCityListing.get(i);
            CityEntity entity = new CityEntity();
            entity.setId(bean.getCity_id());
            entity.setName(bean.getCity_name());
            list.add(entity);
        }
        return list;
    }

    private List<CityEntity> iniyGPSCityDatas() {
        List<CityEntity> list = new ArrayList<>();
        list.add(new CityEntity("定位中..."));
        return list;
    }

    private void initSearch() {
        getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();

        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.trim().length() > 0) {
                    if (mSearchFragment.isHidden()) {
                        getSupportFragmentManager().beginTransaction().show(mSearchFragment).commit();
                    }
                } else {
                    if (!mSearchFragment.isHidden()) {
                        getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();
                    }
                }

                mSearchFragment.bindQueryText(newText);
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (!mSearchFragment.isHidden()) {
            // 隐藏 搜索
            mSearchView.setQuery(null, false);
            getSupportFragmentManager().beginTransaction().hide(mSearchFragment).commit();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void sendCity2View(City city) {
        List<City.ResultBean> cityResult = city.getResult();
        for (int i = 0; i <cityResult.size(); i++) {
            City.ResultBean bean = cityResult.get(i);
            if(bean.getBegin_key().equals("hot")){
                hotCityListing.addAll(bean.getCity_list());
            }else {
                cityListBeen.addAll(bean.getCity_list());
            }
        }
        List<CityEntity> cityEntities1 = iniyHotCityDatas(hotCityListing);
        hotCityList.addAll(cityEntities1);
        indexableLayout.addHeaderAdapter(new SimpleHeaderAdapter<>(adapter, "热", "热门城市",hotCityList));
        // 定位
        final List<CityEntity> gpsCity = iniyGPSCityDatas();
        final SimpleHeaderAdapter gpsHeaderAdapter = new SimpleHeaderAdapter<>(adapter, "定", "当前城市", gpsCity);
        indexableLayout.addHeaderAdapter(gpsHeaderAdapter);

        // 模拟定位
        indexableLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                String city = SharedPreferenceUtils.getString(PickCityActivity.this, "city");
                gpsCity.get(0).setName(city);
                gpsHeaderAdapter.notifyDataSetChanged();
            }
        }, 3000);
        List<CityEntity> cityEntities = initDatas(cityListBeen);
        mDatas.addAll(cityEntities);
        // set Datas
        adapter.setDatas(mDatas, new IndexableAdapter.IndexCallback<CityEntity>() {
            @Override
            public void onFinished(List<EntityWrapper<CityEntity>> datas) {
                // 数据处理完成后回调
                mSearchFragment.bindDatas(mDatas);
                mProgressBar.setVisibility(View.GONE);
                adapter.notifyDataSetChanged();
            }
        });
        initSearch();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.BUTTON_BACK:
                String city = SharedPreferenceUtils.getString(this, "city");
                Intent intent = new Intent(this,MapActivity.class);
                intent.putExtra("cityName",city);
                setResult(RESULT_CODE,intent);
                finish();
                break;
        }
        return super.onTouchEvent(event);
    }

    public void onClickFinishCity(View view) {
        String city = SharedPreferenceUtils.getString(this, "city");
        Intent intent = new Intent(this,MapActivity.class);
        intent.putExtra("cityName",city);
        setResult(RESULT_CODE,intent);
        finish();
    }
}
