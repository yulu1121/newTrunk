package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public interface IServicePresenter {
    void getServiceData();
    interface SendServiceData{
        void sendServiceData(HomeServiceBean bean);
    }
}
