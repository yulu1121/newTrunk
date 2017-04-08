package com.daowei.www.daoweitwo.module.home.impl;

import com.daowei.www.daoweitwo.module.home.CitiesModel;
import com.daowei.www.daoweitwo.module.home.bean.City;
import com.daowei.www.daoweitwo.utils.Constants;
import com.daowei.www.daoweitwo.utils.JsonLoader;
import com.google.gson.Gson;



/**
 *
 * Created by Administrator on 2017/1/25.
 */

public class CityModelImpl implements CitiesModel {
    private JsonLoader jsonLoader;
    private SendCityResult cityResult;
    public CityModelImpl(SendCityResult cityResult){
        this.cityResult = cityResult;
    }
    @Override
    public void getCityResult() {
        jsonLoader = new JsonLoader();
        jsonLoader.parseJson2String(Constants.CITY_URL, new JsonLoader.JsonListener() {
            @Override
            public void JsonComplete(String json) {
                Gson gson = new Gson();
                City city = gson.fromJson(json, City.class);
                cityResult.sendCityResult(city);
            }
        });
    }
}
