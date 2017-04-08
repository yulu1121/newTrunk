package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IServiceModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;
import com.daowei.www.daoweitwo.module.home.impl.ServiceModel;
import com.daowei.www.daoweitwo.presenter.IServicePresenter;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public class ServicePresenter implements IServicePresenter,IServiceModel.SendServiceResult{
    private Context context;
    private SendServiceData data;
    private IServiceModel model;
    public ServicePresenter(Context context,SendServiceData data){
        this.data = data;
        this.context = context;
        model = new ServiceModel();
    }
    @Override
    public void getServiceData() {
        model.getServiceResult(context,this);
    }

    @Override
    public void sendServiceResult(HomeServiceBean bean) {
        data.sendServiceData(bean);
    }
}
