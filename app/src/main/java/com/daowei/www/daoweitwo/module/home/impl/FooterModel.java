package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.IFooterModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;
import com.daowei.www.daoweitwo.utils.SharedPreferenceUtils;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/2/23.
 */

public class FooterModel implements IFooterModel {
    @Override
    public void getFooterResult(Context context, final SendFooterResult result) {
        //保留下面被注释的代码，是为了后期检测JSON数据的格式，added by yulu 2017年2月23日 16:24:43
//        String url = "http://api.daoway.cn/daoway/rest/services?start=0&size=20&lot=111.3254318237305&lat=30.73299980163574&manualCity=%E6%AD%A6%E6%B1%89";
//        JsonLoader jsonLoader = new JsonLoader();
//        jsonLoader.parseJson2String(url, new JsonLoader.JsonListener() {
//            @Override
//            public void JsonComplete(String json) {
//                Gson gson = new Gson();
//                HomeFooterBean footerBean = gson.fromJson(json, HomeFooterBean.class);
//                result.sendFooterResult(footerBean);
//            }
//        });
        String city = SharedPreferenceUtils.getString(context, "city");
        float latitude = SharedPreferenceUtils.getFloat(context, "latitude");
        float longitude = SharedPreferenceUtils.getFloat(context, "longitude");
        MyApplication application = (MyApplication) context.getApplicationContext();
        AppHttpService service = application.getRetrofit().create(AppHttpService.class);
        service.getFooterBean(0,20,longitude,latitude,city)
                .map(new Func1<HomeFooterBean, HomeFooterBean>() {
                         @Override
                         public HomeFooterBean call(HomeFooterBean bean) {
                             return bean;
                         }
                     }
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<HomeFooterBean>() {
                    @Override
                    public void call(HomeFooterBean bean) {
                        result.sendFooterResult(bean);
                    }
                });
    }
}
