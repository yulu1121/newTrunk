package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.HomeRecommendBean;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public interface IRecommendPresenter {
    void getRecommendData();
    interface SendRecommendData{
        void sendRecommendData(HomeRecommendBean bean);
    }
}
