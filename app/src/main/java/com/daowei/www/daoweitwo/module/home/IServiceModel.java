package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.HomeServiceBean;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public interface IServiceModel {
    void getServiceResult(Context context,SendServiceResult data);
    interface SendServiceResult{
        void sendServiceResult(HomeServiceBean bean);
    }
}
