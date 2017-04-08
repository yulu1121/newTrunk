package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IRecommendModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeRecommendBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public class HomeRecommendModel implements IRecommendModel {
    @Override
    public void getRecommendResult(Context context, final SendRecommendResult result) {
//        String url = "http://api.daoway.cn/daoway/rest/indexEvent/all?city=%E6%AD%A6%E6%B1%89&market=false&version=v2&serviceMinLimit=4&type=all&marketMinLimit=2&udid=133524447081935&appVersion=4.9.2";
//        JsonLoader jsonLoader = new JsonLoader();
//        jsonLoader.parseJson2String(url, new JsonLoader.JsonListener() {
//            @Override
//            public void JsonComplete(String json) {
//                Gson gson = new Gson();
//                HomeRecommendBean bean = gson.fromJson(json, HomeRecommendBean.class);
//                result.sendRecommendResult(bean);
//            }
//        });
        String city = SharedPreferenceUtils.getString(context, "city");
        MyApplication myApplication = (MyApplication) context.getApplicationContext();
        final AppHttpService httpService = myApplication.getRetrofit().create(AppHttpService.class);
        httpService.getRecommendBean(city,false,"v2",4,"all",2,"133524447081935","4.9.2")
                    .map(new Func1<HomeRecommendBean, HomeRecommendBean>() {
                        @Override
                        public HomeRecommendBean call(HomeRecommendBean bean) {
                            return bean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<HomeRecommendBean>() {
                        @Override
                        public void call(HomeRecommendBean bean) {
                            result.sendRecommendResult(bean);
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
