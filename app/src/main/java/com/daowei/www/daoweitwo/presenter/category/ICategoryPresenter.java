package com.daowei.www.daoweitwo.presenter.category;

import android.content.Context;

import com.daowei.www.daoweitwo.module.category.ICategoryModule;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;

import java.util.List;


/**
 * Created by Administrator on 2017/2/21 0021.
 */

public interface ICategoryPresenter {


    void queryData(Context context,CatePresentCallBack callBack);
    void querydetails(Context context,int size,String category,String tag,String sort_by,CatePresentCallBack callBack);
    void querySort(Context context,String category,String tag,String sort_by,CatePresentCallBack callBack);
    void queryAll(Context context,int size, String category, String sort_by, CatePresentCallBack callBack);
    void queryStoreAll(Context context,int size, String category, String sort_by,  CatePresentCallBack callBack);
    void querySearchGrid(Context context, CatePresentCallBack callBack);
    void querySearchList(Context context,String word, CatePresentCallBack callBack);
    public interface CatePresentCallBack{
        void getData(CategoryBean categoryBean);
        void getDetais(List<ItemBean> list);
        void getSort(SortBean sortBean);
        void getAll(List<ItemBean> list);
        void getStoreAll(StoreAllBean storeAllBean);
        void getSearchGrid(SearchGridBean searchGridBean);
        void getSearchList(SearchGridBean searchGridBean);
    }
}
