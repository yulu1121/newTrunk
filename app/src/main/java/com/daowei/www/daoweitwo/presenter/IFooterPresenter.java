package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;

/**
 *
 * Created by yulu on 2017/2/23.
 */

public interface IFooterPresenter {
    void getFooterBeanData();
    interface SendFooterBeanData{
        void sendFooterBeanData(HomeFooterBean bean);
    }
}
