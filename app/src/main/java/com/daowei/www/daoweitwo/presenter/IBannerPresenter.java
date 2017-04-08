package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.HomeBannerBean;

/**
 *
 * Created by Administrator on 2017/2/22.
 */

public interface IBannerPresenter {
    void getHomeBannerData();
    interface SendHomeBannerData{
        void sendHomeBannerData(HomeBannerBean bean);
    }
}
