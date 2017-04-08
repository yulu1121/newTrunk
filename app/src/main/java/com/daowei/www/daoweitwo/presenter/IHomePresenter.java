package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public interface IHomePresenter {
    void  getHomeExpanbleData();
    interface SendHomeExpanbleData{
        void sendHomeExpanbleData(HomeExpanbleBean bean);
    }
}
