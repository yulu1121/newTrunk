package com.daowei.www.daoweitwo.module.category.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.category.ICategoryModule;
import com.daowei.www.daoweitwo.module.category.bean.CategoryBean;
import com.daowei.www.daoweitwo.module.category.bean.ItemBean;
import com.daowei.www.daoweitwo.module.category.bean.SearchGridBean;
import com.daowei.www.daoweitwo.module.category.bean.SortBean;
import com.daowei.www.daoweitwo.module.category.bean.StoreAllBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidstudy.hezijie.com.okhttp_tool.OkHttpTools;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by Administrator on 2017/2/21 0021.
 */

public class CategoryModule implements ICategoryModule{

    @Override
    public void queryData(Context context, final CateModuleCallback callback) {
        AppHttpService  httpService = ((MyApplication) context.getApplicationContext()).getRetrofit().create(AppHttpService.class);
        httpService.getCategoryBean(SharedPreferenceUtils.getString(context, "city"), 279969, false, "133524447081935", "4.9.2")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<CategoryBean>() {
            @Override
            public void call(CategoryBean categoryBean) {
                callback.getData(categoryBean);
            }
        });
    }
    //http://api.daoway.cn/daoway/rest/service_items/filter?start=0&size=20&lot=114.32044324876&
    // lat=30.580713370154&imei=133524447081935&category=20&tag=%E6%B7%B1%E5%BA%A6%E4%BF%9D%E6%B4%81&
    // manualCity=%E6%AD%A6%E6%B1%89&sort_by=recommend&udid=133524447081935&appVersion=4.9.2
    @Override
    public void querydetails(Context context,int size, String category, String tag, String sort_by, final CateModuleCallback callback) {
        String detailsPath = "http://api.daoway.cn/daoway/rest/service_items/filter?" +
                "start=0&size="+size+"&lot="+SharedPreferenceUtils.getFloat(context,"longitude")+
                "&lat="+SharedPreferenceUtils.getFloat(context,"latitude")+
                "&imei=133524447081935&category="+category+"&tag="+tag+
                "&manualCity="+SharedPreferenceUtils.getString(context,"city")+
                "&sort_by="+sort_by+"&udid=133524447081935&appVersion=4.9.2";

        OkHttpTools.Builder().url(detailsPath).get().callBack(new OkHttpTools.OkHttpCallBack() {
            @Override
            public void getData(String data) {
                callback.getDetais(json2Java(data));
            }
        });
        //        AppHttpService  httpService = ((MyApplication) context.getApplicationContext()).getRetrofit().create(AppHttpService.class);
//        httpService.getCategoryDetails(0,20,
//                SharedPreferenceUtils.getFloat(context,"longitude"),
//                SharedPreferenceUtils.getFloat(context,"latitude"),
//                category,
//                "133524447081935",
//                tag,SharedPreferenceUtils.getString(context,"city"),sort_by,"133524447081935","4.9.2")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<HomeExpanbleBean.DataBean>() {
//                    @Override
//                    public void call(HomeExpanbleBean.DataBean dataBean) {
//                        callback.getDetais(dataBean);
//                    }
//                });
    }

    /**
     * @param context
     * @param category
     * @param tag
     * @param sort_by
     * @param callback
     * http://api.daoway.cn/daoway/rest/services/filter?start=0&size=20&lot=114.43604618483677&
     * lat=30.424651061321562&category=20&tags=%E5%B0%8F%E6%97%B6%E5%B7%A5&manualCity=%E6%AD%A6%E6%B1%89&
     * imei=865931028521318&includeNotInScope=true&userId=ffde4e5800494a048bc383e3c5c051dc&
     * udid=865931028521318&appVersion=4.10.0
     */
    @Override
    public void querySort(Context context, String category, String tag, String sort_by, final CateModuleCallback callback) {
        AppHttpService  httpService = ((MyApplication) context.getApplicationContext()).getRetrofit().create(AppHttpService.class);
        httpService.getSortBean(0,20,SharedPreferenceUtils.getFloat(context,"longitude"),
                SharedPreferenceUtils.getFloat(context,"latitude"),category,tag,
                SharedPreferenceUtils.getString(context,"city"),"865931028521318",true,
                "ffde4e5800494a048bc383e3c5c051dc","865931028521318","4.10.0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SortBean>() {
                    @Override
                    public void call(SortBean sortBean) {
                        callback.getSort(sortBean);
                    }
                });

    }

    /**http://api.daoway.cn/daoway/rest/service_items/filter?start=0&size=20&lot=114.43604618483677&
     * lat=30.424651061321562&imei=865931028521318&category=20&userId=ffde4e5800494a048bc383e3c5c051dc&
     * manualCity=%E6%AD%A6%E6%B1%89&sort_by=recommend&udid=865931028521318&appVersion=4.10.0
     * @param context
     * @param category
     * @param
     * @param sort_by
     * @param callback
     */
    @Override
    public void queryAll(Context context,int size, String category, String sort_by, final CateModuleCallback callback) {
        String detailsPath = "http://api.daoway.cn/daoway/rest/service_items/filter?" +
                "start=0&size="+size+"&lot="+SharedPreferenceUtils.getFloat(context,"longitude")+
                "&lat="+SharedPreferenceUtils.getFloat(context,"latitude")+
                "&imei=865931028521318&category="+category+"&userId=ffde4e5800494a048bc383e3c5c051dc"+
                "&manualCity="+SharedPreferenceUtils.getString(context,"city")+
                "&sort_by="+sort_by+"&udid=133524447081935&appVersion=4.9.2";

        OkHttpTools.Builder().url(detailsPath).get().callBack(new OkHttpTools.OkHttpCallBack() {
            @Override
            public void getData(String data) {
                callback.getAll(json2Java(data));
            }
        });
    }

    @Override
    public void queryStoreAll(Context context, int size, String category, String sort_by, final CateModuleCallback callback) {
        AppHttpService  httpService = ((MyApplication) context.getApplicationContext()).getRetrofit().create(AppHttpService.class);
        httpService.getStoreAllBean(0,20,SharedPreferenceUtils.getFloat(context,"longitude"),
                SharedPreferenceUtils.getFloat(context,"latitude"),category,
                SharedPreferenceUtils.getString(context,"city"),"865931028521318",true,
                "ffde4e5800494a048bc383e3c5c051dc","865931028521318","4.10.0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<StoreAllBean>() {
                    @Override
                    public void call(StoreAllBean storeAllBean) {
                        callback.getStoreAll(storeAllBean);
                    }
                });
    }

    /**
     * @param context
     * @param callback
     * http://api.daoway.cn/daoway/rest/services/hot_search?userId=ffde4e5800494a048bc383e3c5c051dc&
     * lot=114.43604618483677&lat=30.424651061321562&udid=865931028521318&appVersion=4.10.0
     */
    @Override
    public void querySearchGrid(Context context, final CateModuleCallback callback) {
        AppHttpService  httpService = ((MyApplication) context.getApplicationContext()).getRetrofit().create(AppHttpService.class);
        httpService.getSearchGrid("ffde4e5800494a048bc383e3c5c051dc",SharedPreferenceUtils.getFloat(context,"longitude"),
                SharedPreferenceUtils.getFloat(context,"latitude"),"865931028521318","4.10.0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchGridBean>() {
                    @Override
                    public void call(SearchGridBean searchGridBean) {
                        callback.getSearchGrid(searchGridBean);
                    }
                });
    }

    /**
     * @param context
     * @param word
     * @param callback
     * http://api.daoway.cn/daoway/rest/services/auto_complete_words?word=%E6%B4%97%E8%A1%A3&
     * udid=865931028521318&appVersion=4.10.0
     */
    @Override
    public void querySearchList(Context context, String word, final CateModuleCallback callback) {
        AppHttpService  httpService = ((MyApplication) context.getApplicationContext()).getRetrofit().create(AppHttpService.class);
        httpService.getSearchList(word,"865931028521318","4.10.0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchGridBean>() {
                    @Override
                    public void call(SearchGridBean searchGridBean) {
                        callback.getSearchList(searchGridBean);
                    }
                });
    }

    private List<ItemBean> json2Java(String data) {
        List<ItemBean> list = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONObject dataObject = jsonObject.getJSONObject("data");
            JSONArray itemsArr = dataObject.getJSONArray("items");
            int length = itemsArr.length();
            for (int i = 0; i < length; i++) {
                JSONObject o = (JSONObject) itemsArr.get(i);
                ItemBean itemBean = new ItemBean();
                list.add(itemBean);
                itemBean.setId(o.getString("id"));
                itemBean.setServiceId(o.getString("serviceId"));
                itemBean.setServiceTitle(o.getString("serviceTitle"));
                itemBean.setSalesNum(o.getInt("salesNum"));
                itemBean.setName(o.getString("name"));
                itemBean.setDescription(o.getString("description"));
                itemBean.setPic_url(o.getString("pic_url"));
                itemBean.setPrice(o.getInt("price"));
                itemBean.setPrice_unit(o.getString("price_unit"));
                itemBean.setTags(o.getString("tags"));
                itemBean.setOriginalPrice(o.getInt("originalPrice"));
                itemBean.setPositiveCommentRate(o.getString("positiveCommentRate"));
                itemBean.setInDistanceScope(o.getBoolean("inDistanceScope"));
                itemBean.setAheadHours(o.getInt("aheadHours"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
