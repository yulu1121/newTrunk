package com.daowei.www.daoweitwo.presenter.home.impl;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IRecommendModel;
import com.daowei.www.daoweitwo.module.home.bean.HomeRecommendBean;
import com.daowei.www.daoweitwo.module.home.impl.HomeRecommendModel;
import com.daowei.www.daoweitwo.presenter.IRecommendPresenter;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public class RecommendPresenter implements IRecommendPresenter,IRecommendModel.SendRecommendResult {
    private Context context;
    private SendRecommendData data;
    private IRecommendModel model;
    public RecommendPresenter(Context context,SendRecommendData data){
        this.context = context;
        this.data = data;
        model = new HomeRecommendModel();
    }
    @Override
    public void getRecommendData() {
        model.getRecommendResult(context,this);
    }


    @Override
    public void sendRecommendResult(HomeRecommendBean bean) {
        data.sendRecommendData(bean);
    }
}
