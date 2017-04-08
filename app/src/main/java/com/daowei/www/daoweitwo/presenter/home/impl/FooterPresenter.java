package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IFooterModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;
import com.daowei.www.daoweitwo.module.home.impl.FooterModel;
import com.daowei.www.daoweitwo.presenter.IFooterPresenter;

/**
 *
 * Created by yulu on 2017/2/23.
 */

public class FooterPresenter implements IFooterPresenter,IFooterModel.SendFooterResult {
    private Context context;
    private IFooterModel model;
    private SendFooterBeanData data;
    public FooterPresenter(Context context,SendFooterBeanData data){
        this.context = context;
        this.data = data;
        model = new FooterModel();
    }
    @Override
    public void getFooterBeanData() {
        model.getFooterResult(context,this);
    }

    @Override
    public void sendFooterResult(HomeFooterBean bean) {
        data.sendFooterBeanData(bean);
    }
}
