package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.HomeBannerBean;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public interface IBannerModel {
    /**
     * 获得Banner数据的方法
     */
    void getHomeBannerBeanResult(Context context, SendHomeBannerResult result);

    interface SendHomeBannerResult{
        void sendHomeBannerResult(HomeBannerBean bannerBean);
    }
}
