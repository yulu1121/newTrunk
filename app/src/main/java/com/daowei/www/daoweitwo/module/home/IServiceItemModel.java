package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.ServiceItemBean;

/**
 *
 * Created by yulu on 2017/2/28.
 */

public interface IServiceItemModel {
    void getServiceItemResult(Context context,SendServiceItemResult result,String serviceId);
    interface SendServiceItemResult{
        void sendServiceItemResult(ServiceItemBean itemBean);
    }
}
