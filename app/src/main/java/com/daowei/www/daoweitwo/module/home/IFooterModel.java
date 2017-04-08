package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.HomeFooterBean;

/**
 *
 * Created by yulu on 2017/2/23.
 */

public interface IFooterModel {
    void getFooterResult(Context context,SendFooterResult result);
    interface SendFooterResult{
        void sendFooterResult(HomeFooterBean bean);
    }
}
