package com.daowei.www.daoweitwo.presenter;

import com.daowei.www.daoweitwo.module.home.bean.BannerItemBean;

/**
 *
 * Created by yulu on 2017/2/27.
 */

public interface IBannerItemPresenter {
    void getBannerItemData();
    interface SendBannerItemData{
        void sendBannerItemData(BannerItemBean bean);
    }
}
