package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IBannerModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeBannerBean;
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
 * 获取头部广告视图数据的类
 */

public class BannerModel implements IBannerModel {
    @Override
    public void getHomeBannerBeanResult(Context context, final SendHomeBannerResult result) {
        String city = SharedPreferenceUtils.getString(context, "city");
        MyApplication myApplication = (MyApplication) context.getApplicationContext();
        final AppHttpService httpService = myApplication.getRetrofit().create(AppHttpService.class);
        httpService.getBannerBean(city)
                    .map(new Func1<HomeBannerBean, HomeBannerBean>() {
                        @Override
                        public HomeBannerBean call(HomeBannerBean bannerBean) {
                            return bannerBean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<HomeBannerBean>() {
                        @Override
                        public void call(HomeBannerBean bannerBean) {
                                result.sendHomeBannerResult(bannerBean);
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

