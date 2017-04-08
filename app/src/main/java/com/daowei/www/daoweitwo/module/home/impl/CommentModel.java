package com.daowei.www.daoweitwo.module.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.MyApplication;
import com.daowei.www.daoweitwo.module.home.ICommentModel;
import com.daowei.www.daoweitwo.module.home.bean.CommentBean;
import com.daowei.www.daoweitwo.utils.AppHttpService;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * Created by yulu on 2017/3/1.
 */

public class CommentModel implements ICommentModel {
    @Override
    public void getCommentResult(Context context, final SendCommentResult result, String serviceId,int start,int size) {
        MyApplication myApplication = (MyApplication) context.getApplicationContext();
        final AppHttpService httpService = myApplication.getRetrofit().create(AppHttpService.class);
        httpService.getCommentBean(serviceId,start,size,"all")
                            .map(new Func1<CommentBean, CommentBean>() {
                                @Override
                                public CommentBean call(CommentBean bean) {
                                    return bean;
                                }
                            })
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<CommentBean>() {
                                @Override
                                public void call(CommentBean bean) {
                                    result.sendCommentResult(bean);
                                }
                            });

    }
}
