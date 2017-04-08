package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IServiceItemModel;
import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;
import com.daowei.www.daoweitwo.module.home.impl.ServiceItemModel;
import com.daowei.www.daoweitwo.presenter.IServiceItemPresenter;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public class ServiceItemPresenter implements IServiceItemPresenter,IServiceItemModel.SendServiceItemResult{
    private Context context;
    private SendServiceItemData data;
    private IServiceItemModel model;
    private String serviceId;
    public ServiceItemPresenter(Context context,SendServiceItemData data,String serviceId){
        this.context = context;
        this.data = data;
        this.serviceId = serviceId;
        model = new ServiceItemModel();
    }
    @Override
    public void getServiceItemData() {
        model.getServiceItemResult(context,this,serviceId);
    }

    @Override
    public void sendServiceItemResult(ServiceItemBean itemBean) {
        data.sendServiceItemData(itemBean);
    }
}
