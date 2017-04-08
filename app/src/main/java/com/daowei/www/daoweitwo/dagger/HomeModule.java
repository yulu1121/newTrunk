package com.daowei.www.daoweitwo.dagger;

import android.content.Context;

import com.daowei.www.daoweitwo.module.home.IHomeModel;
import com.daowei.www.daoweitwo.module.home.impl.HomeModel;
import com.daowei.www.daoweitwo.presenter.IHomePresenter;

import dagger.Module;
import dagger.Provides;

/**
 *
 * Created by yulu on 2017/2/21.
 */
@Module
public class HomeModule {
    private Context context;
    private IHomePresenter.SendHomeExpanbleData data;
    public HomeModule(Context context, IHomePresenter.SendHomeExpanbleData data){
        this.context =context;
        this.data = data;
    }

    @Provides
    IHomeModel getModel(){
        return new HomeModel();
    }
//    @Provides
//    IHomePresenter getPresenter(IHomeModel model, IHomePresenter.SendHomeExpanbleData data){
//        return new HomePresneter(context,data,model);
//    }
}
