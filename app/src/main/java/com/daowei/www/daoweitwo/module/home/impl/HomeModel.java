package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IHomeModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/2/20.
 */

public class HomeModel implements IHomeModel {
    //http://api.daoway.cn/daoway/rest/service_items/recommend_top?start=0&size=10&lot=114.32044324876&lat=30.580713370154&manualCity=%E6%AD%A6%E6%B1%89&imei=133524447081935&includeNotInScope=true&udid=133524447081935&appVersion=4.9.2
    @Override
    public void getHomeExpanbleResult(final Context context, final SendHomeExpanbleResult result) {
//        JsonLoader jsonLoader = new JsonLoader();
//        String url = "http://api.daoway.cn/daoway/rest/service_items/recommend_top?start=0&size=10&lot=114.32044324876&lat=30.580713370154&manualCity=%E6%AD%A6%E6%B1%89";
//        jsonLoader.parseJson2String(url, new JsonLoader.JsonListener() {
//            @Override
//            public void JsonComplete(String json) {
//                Gson gson = new Gson();
//                HomeExpanbleBean bean = gson.fromJson(json, HomeExpanbleBean.class);
//                result.sendHomeExpanbleResult(bean);
//            }
//        });
        String city = SharedPreferenceUtils.getString(context, "city");
        float latitude = SharedPreferenceUtils.getFloat(context, "latitude");
        float longitude = SharedPreferenceUtils.getFloat(context, "longitude");
        MyApplication myApplication = (MyApplication) context.getApplicationContext();
        final AppHttpService httpService = myApplication.getRetrofit().create(AppHttpService.class);
        httpService.getHomeExpanbleBean(0,10,longitude,latitude,city)
                    .map(new Func1<HomeExpanbleBean, HomeExpanbleBean>() {
                        @Override
                        public HomeExpanbleBean call(HomeExpanbleBean bean) {
                            return bean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<HomeExpanbleBean>() {
                        @Override
                        public void call(HomeExpanbleBean bean) {
                            result.sendHomeExpanbleResult(bean);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }, new Action0() {
                        @Override
                        public void call() {
                        }
                    });
    }


}
