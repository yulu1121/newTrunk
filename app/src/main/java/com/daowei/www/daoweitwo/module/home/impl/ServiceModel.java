package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IServiceModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *  获取头部视图中分类服务的信息
 * Created by yulu on 2017/2/22.
 */

public class ServiceModel implements IServiceModel {
    @Override
    public void getServiceResult(Context context, final SendServiceResult data) {
        String city = SharedPreferenceUtils.getString(context,"city");
        MyApplication application = (MyApplication) context.getApplicationContext();
        final AppHttpService httpService = application.getRetrofit().create(AppHttpService.class);
        httpService.getServiceBean(city)
                .map(new Func1<HomeServiceBean, HomeServiceBean>() {
                    @Override
                    public HomeServiceBean call(HomeServiceBean bean) {
                        return bean;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeServiceBean>() {
                    @Override
                    public void call(HomeServiceBean bean) {
                        data.sendServiceResult(bean);
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
