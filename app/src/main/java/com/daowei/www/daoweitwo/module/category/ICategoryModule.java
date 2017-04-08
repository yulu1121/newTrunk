package com.daowei.www.daoweitwo.module.category;

import android.content.Context;

import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;

import java.util.List;

import static android.R.attr.data;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

public interface ICategoryModule {

    /**
     * @param context
     * @param callback
     * 分类页面首页的数据获取
     */
    void queryData(Context context,CateModuleCallback callback);
    void querydetails(Context context,int size,String category,String tag,String sort_by,CateModuleCallback callback);
    void querySort(Context context,String category,String tag,String sort_by,CateModuleCallback callback);
    void queryAll(Context context,int size, String category, String sort_by,  CateModuleCallback callback);
    void queryStoreAll(Context context,int size, String category, String sort_by,  CateModuleCallback callback);
    void querySearchGrid(Context context,CateModuleCallback callback);
    void querySearchList(Context context,String word,CateModuleCallback callback);

    public interface CateModuleCallback{
        /**
         * @param categoryBean
         * 网络请求，分类页面首页数据
         */
        void getData(CategoryBean categoryBean);
        void getDetais(List<ItemBean> list);
        void getSort(SortBean sortBean);
        void getAll(List<ItemBean> list);
        void getStoreAll(StoreAllBean storeAllBean);
        void getSearchGrid(SearchGridBean searchGridBean);
        void getSearchList(SearchGridBean searchGridBean);
    }
}
