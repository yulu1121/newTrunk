package com.daowei.www.daoweitwo.module.home;


import com.daowei.www.daoweitwo.module.home.bean.City;

;

/**
 *
 * Created by Administrator on 2017/1/25.
 */

public interface CitiesModel {
    void getCityResult();
    interface SendCityResult{
        void sendCityResult(City city);
    }
}
