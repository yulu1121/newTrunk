package com.daowei.www.daoweitwo.presenter.category.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.category.ICategoryModule;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.module.category.impl.CategoryModule;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;
import com.daowei.www.daoweitwo.presenter.category.ICategoryPresenter;

import java.util.List;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public class CategoryPresenter implements ICategoryPresenter,ICategoryModule.CateModuleCallback {
    private CategoryModule categoryModule;
    private CatePresentCallBack callBack;
    public CategoryPresenter(){
        categoryModule = new CategoryModule();
    }
    @Override
    public void queryData(Context context, CatePresentCallBack callBack) {
        categoryModule.queryData(context,this);
        this.callBack = callBack;
    }

    @Override
    public void querydetails(Context context,int size, String category, String tag, String sort_by, CatePresentCallBack callBack) {
        categoryModule.querydetails(context,size, category, tag, sort_by, this);
        this.callBack = callBack;
    }


    @Override
    public void querySort(Context context, String category, String tag, String sort_by,  CatePresentCallBack callBack) {
        categoryModule.querySort(context, category, tag, sort_by, this);
        this.callBack = callBack;
    }

    @Override
    public void queryAll(Context context, int size, String category, String sort_by, CatePresentCallBack callBack) {
        categoryModule.queryAll(context,size,category,sort_by,this);
        this.callBack = callBack;
    }

    @Override
    public void queryStoreAll(Context context, int size, String category, String sort_by, CatePresentCallBack callBack) {
        categoryModule.queryStoreAll(context,size,category,sort_by,this);
        this.callBack = callBack;
    }

    @Override
    public void querySearchGrid(Context context, CatePresentCallBack callBack) {
        categoryModule.querySearchGrid(context,this);
        this.callBack = callBack;
    }

    @Override
    public void querySearchList(Context context, String word, CatePresentCallBack callBack) {
        categoryModule.querySearchList(context,word,this);
        this.callBack = callBack;
    }

    @Override
    public void getData(CategoryBean categoryBean) {
        callBack.getData(categoryBean);
    }

    @Override
    public void getDetais(List<ItemBean> list) {
        callBack.getDetais(list);
    }

    @Override
    public void getSort(SortBean sortBean) {
        callBack.getSort(sortBean);
    }

    @Override
    public void getAll(List<ItemBean> list) {
        callBack.getAll(list);
    }

    @Override
    public void getStoreAll(StoreAllBean storeAllBean) {
        callBack.getStoreAll(storeAllBean);
    }

    @Override
    public void getSearchGrid(SearchGridBean searchGridBean) {
        callBack.getSearchGrid(searchGridBean);
    }

    @Override
    public void getSearchList(SearchGridBean searchGridBean) {
        callBack.getSearchList(searchGridBean);
    }
}
