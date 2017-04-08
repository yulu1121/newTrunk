package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IHomeModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;
import com.daowei.www.daoweitwo.module.home.impl.HomeModel;
import com.daowei.www.daoweitwo.presenter.IHomePresenter;

/**
 *
 * Created by Administrator on 2017/2/21.
 */

public class HomePresneter implements IHomePresenter,IHomeModel.SendHomeExpanbleResult {
    private IHomeModel model;
    private Context context;
    private SendHomeExpanbleData data;
    public HomePresneter(Context context,SendHomeExpanbleData data){
        this.context = context;
        this.data = data;
        model = new HomeModel();
    }
    @Override
    public void getHomeExpanbleData() {
        model.getHomeExpanbleResult(context,this);
    }


    @Override
    public void sendHomeExpanbleResult(HomeExpanbleBean bean) {
        data.sendHomeExpanbleData(bean);
    }

}
