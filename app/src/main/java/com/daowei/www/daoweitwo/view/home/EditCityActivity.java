package com.daowei.www.daoweitwo.view.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;
import com.daowei.www.daoweitwo.view.adapter.MapPoiAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditCityActivity extends AppCompatActivity {
    @BindView(R.id.edit_city_real)
    EditText inputCity;
    @BindView(R.id.search_edit_list)
    ListView listView;
    private MapPoiAdapter adapter;
    private List<PoiInfo> mlsit = new ArrayList<>();
    private PoiSearch poiSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_city);
        ButterKnife.bind(this);
        initPoiSearch();
        initView();
    }

    private void initView() {
        inputCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int start, int before, int count) {
                String cityName=SharedPreferenceUtils.getString(EditCityActivity.this,"city");
                if (cs == null || cs.length() <= 0) {
                    return;
                }
//发起搜索请求
                poiSearch.searchInCity((new PoiCitySearchOption())
                        .city(cityName).keyword(cs.toString()).pageNum(0)
                        .pageCapacity(20));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        adapter = new MapPoiAdapter(this,mlsit);
        listView.setAdapter(adapter);
    }
        private void initPoiSearch(){
        //获得poisearch对象
        poiSearch = PoiSearch.newInstance();
        //定义获得结果的监听
        poiSearch.setOnGetPoiSearchResultListener(new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult result) {
                if (result == null
                        || result.error == SearchResult.ERRORNO.RESULT_NOT_FOUND) {
                    return;
                }
                if (result.error == SearchResult.ERRORNO.NO_ERROR) {
                    List<PoiInfo> list = result.getAllPoi();
                    if (list != null && list.size() > 0) {
                        mlsit.clear();
                        mlsit.addAll(list);
                        adapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        });
    }
    public void end_edit(View view) {
        finish();
    }
}
