package com.daowei.www.daoweitwo.presenter;


import com.daowei.www.daoweitwo.module.home.bean.City;

/**
 *
 * Created by Administrator on 2017/1/25.
 */

public interface CitiesPresenter {
    void sendCityData();
    interface SendCity2View{
        void sendCity2View(City city);
    }
}
