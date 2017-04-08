package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IBannerItemModel;
import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/2/27.
 */

public class BannerItemModel implements IBannerItemModel {
    @Override
    public void getBannerItemResult(Context context, final SendBannerItemResult result, String target) {
        float latitude = SharedPreferenceUtils.getFloat(context, "latitude");
        float longitude = SharedPreferenceUtils.getFloat(context, "longitude");
        MyApplication application= (MyApplication) context.getApplicationContext();
        AppHttpService httpService = application.getRetrofit().create(AppHttpService.class);
        httpService.getBannerItemBean(target,null,longitude,latitude)
                    .map(new Func1<BannerItemBean,BannerItemBean>() {
                        @Override
                        public BannerItemBean call(BannerItemBean bean) {
                            return bean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<BannerItemBean>() {
                        @Override
                        public void call(BannerItemBean bean) {
                            result.sendBannerResult(bean);
                        }
                    });
    }
}
