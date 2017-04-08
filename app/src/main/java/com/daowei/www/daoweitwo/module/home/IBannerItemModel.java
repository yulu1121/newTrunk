package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;

/**
 *
 * Created by yulu on 2017/2/27.
 */

public interface IBannerItemModel {
    void getBannerItemResult(Context context,SendBannerItemResult result,String target);
    interface SendBannerItemResult{
        void sendBannerResult(BannerItemBean bean);
    }
}
