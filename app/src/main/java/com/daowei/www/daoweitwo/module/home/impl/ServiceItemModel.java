package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IServiceItemModel;
import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public class ServiceItemModel implements IServiceItemModel {
    @Override
    public void getServiceItemResult(Context context, final SendServiceItemResult result, String serviceId) {
        MyApplication application= (MyApplication) context.getApplicationContext();
        AppHttpService httpService = application.getRetrofit().create(AppHttpService.class);
        String city = SharedPreferenceUtils.getString(context, "city");
        float latitude = SharedPreferenceUtils.getFloat(context, "latitude");
        float longitude = SharedPreferenceUtils.getFloat(context, "longitude");
        httpService.getServiceItemBean(serviceId,latitude,longitude,city)
                    .map(new Func1<ServiceItemBean, ServiceItemBean>() {
                        @Override
                        public ServiceItemBean call(ServiceItemBean itemBean) {
                            return itemBean;
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<ServiceItemBean>() {
                        @Override
                        public void call(ServiceItemBean itemBean) {
                            result.sendServiceItemResult(itemBean);
                        }
                    });
    }
}
