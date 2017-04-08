package com.daowei.www.daoweitwo.view.category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.daowei.www.daoweitwo.MainActivity;
import com.daowei.www.daoweitwo.R;
import com.daowei.www.daoweitwo.SearchActivity;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.presenter.category.ICategoryPresenter;
import com.daowei.www.daoweitwo.presenter.category.impl.CategoryPresenter;
import com.daowei.www.daoweitwo.view.category.adapter.ContentAdapter;
import com.daowei.www.daoweitwo.view.category.adapter.TitleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by  on 2017/2/20 0020.
 */

public class CategoryFragment extends Fragment implements ICategoryPresenter.CatePresentCallBack{
    private ICategoryPresenter categoryPresenter;
    private Context context;
    @BindView(R.id.category_title_lv)
    ListView mTitleLv;
    @BindView(R.id.category_content_lv)
    ListView mContentLv;
    @BindView(R.id.fragment_category_search_btn)
    RadioButton radioButton;
    private int mCurrentPosition = 0;
    private List<CategoryBean.DataBean> mTitleList;
    private Map<Integer,List<String>> mContentMap;
    private TitleAdapter titleAdapter;
    private ContentAdapter contentAdapter;
    public  static int POSITION = 0;

    public static CategoryFragment newInstance(){
        return new CategoryFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryPresenter = new CategoryPresenter();
        categoryPresenter.queryData(context,this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        ButterKnife.bind(this,view);
        setViews();
        listener();
        return view;
    }

    private void listener() {
        mContentLv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem != mCurrentPosition){
                    mCurrentPosition = firstVisibleItem;
                    if(POSITION != mCurrentPosition){
                        POSITION = mCurrentPosition;
                        titleAdapter.notifyDataSetChanged();
                    }
                    mTitleLv.setSelection(mCurrentPosition);
                }
            }
        });
        mTitleLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mContentLv.setSelection(position);
            }
        });

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                startActivity(new Intent(mainActivity, SearchActivity.class));
            }
        });
    }

    private void setViews() {
        mTitleList = new ArrayList<>();
        mContentMap = new HashMap<>();
        titleAdapter = new TitleAdapter(context,mTitleList);
        contentAdapter = new ContentAdapter(context,mTitleList);
        mTitleLv.setAdapter(titleAdapter);
        mContentLv.setAdapter(contentAdapter);
    }

    /**created by hezijie 2017/2/21
     * @param categoryBean
     * 通过retrofit和rxjava获取的网络数据
     */
    @Override
    public void getData(CategoryBean categoryBean) {
        List<CategoryBean.DataBean> list = categoryBean.getData();
        mTitleList.addAll(list);
        titleAdapter.notifyDataSetChanged();
        contentAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDetais(List<ItemBean> list) {

    }

    @Override
    public void getSort(SortBean sortBean) {

    }

    @Override
    public void getAll(List<ItemBean> list) {

    }

    @Override
    public void getStoreAll(StoreAllBean storeAllBean) {

    }

    @Override
    public void getSearchGrid(SearchGridBean searchGridBean) {

    }

    @Override
    public void getSearchList(SearchGridBean searchGridBean) {

    }
}
