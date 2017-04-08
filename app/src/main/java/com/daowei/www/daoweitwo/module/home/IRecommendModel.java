package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.HomeRecommendBean;

/**
 *
 * Created by yulu on 2017/2/22.
 */

public interface IRecommendModel {
    void getRecommendResult(Context context,SendRecommendResult result);
    interface SendRecommendResult{
        void sendRecommendResult(HomeRecommendBean bean);
    }
}
