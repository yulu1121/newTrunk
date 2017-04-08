package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IBannerItemModel;
import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;
import com.daowei.www.daoweitwo.module.home.impl.BannerItemModel;
import com.daowei.www.daoweitwo.presenter.IBannerItemPresenter;

/**
 *
 * Created by Administrator on 2017/2/27.
 */

public class BannerItemPresenter implements IBannerItemPresenter,IBannerItemModel.SendBannerItemResult{
    private Context context;
    private IBannerItemModel model;
    private String target;
    private SendBannerItemData data;
    public BannerItemPresenter(Context context,SendBannerItemData data,String target){
        this.context = context;
        this.target = target;
        this.data = data;
        this.model = new BannerItemModel();

    }

    @Override
    public void getBannerItemData() {
        model.getBannerItemResult(context,this,target);
    }

    @Override
    public void sendBannerResult(BannerItemBean bean) {
        data.sendBannerItemData(bean);
    }
}
