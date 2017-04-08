package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public interface IServiceItemPresenter {
    void getServiceItemData();
    interface SendServiceItemData{
        void sendServiceItemData(ServiceItemBean bean);
    }
}
