package com.daowei.www.daoweitwo.presenter.home.impl;


import com.daowei.www.daoweitwo.module.home.CitiesModel;
import com.daowei.www.daoweitwo.module.home.bean.City;
import com.daowei.www.daoweitwo.module.home.impl.CityModelImpl;
import com.daowei.www.daoweitwo.presenter.CitiesPresenter;

/**
 *
 * Created by Administrator on 2017/1/25.
 */

public class CitiesPresenterImpl implements CitiesPresenter,CitiesModel.SendCityResult{
    private SendCity2View sendCity2View;
    private CitiesModel model;
    public CitiesPresenterImpl(SendCity2View sendCity2View){
        this.sendCity2View = sendCity2View;
        model = new CityModelImpl(this);
    }
    @Override
    public void sendCityData() {
        model.getCityResult();
    }

    @Override
    public void sendCityResult(City city) {
        sendCity2View.sendCity2View(city);
    }
}
