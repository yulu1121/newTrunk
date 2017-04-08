package com.daowei.www.daoweitwo.module.home;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.bean.HomeExpanbleBean;

/**
 *
 * Created by yulu on 2017/2/20.
 */

public interface IHomeModel {
    //获得分组数据的方法
    void getHomeExpanbleResult(Context context,SendHomeExpanbleResult result);

    /**
     * 向presener层传送数据的接口
     */
    interface SendHomeExpanbleResult{
        void sendHomeExpanbleResult(HomeExpanbleBean bean);
    }
}
