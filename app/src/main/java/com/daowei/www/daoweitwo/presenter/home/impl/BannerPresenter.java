package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IBannerModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeBannerBean;
import com.daowei.www.daoweitwo.module.home.impl.BannerModel;
import com.daowei.www.daoweitwo.presenter.IBannerPresenter;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public class BannerPresenter implements IBannerPresenter,IBannerModel.SendHomeBannerResult {
    private IBannerModel model;
    private Context context;
    private SendHomeBannerData data;
    public BannerPresenter(Context context,SendHomeBannerData data){
        this.context = context;
        this.data = data;
        model = new BannerModel();
    }
    @Override
    public void getHomeBannerData() {
        model.getHomeBannerBeanResult(context,this);
    }

    @Override
    public void sendHomeBannerResult(HomeBannerBean bannerBean) {
        data.sendHomeBannerData(bannerBean);
    }
}
