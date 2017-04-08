package com.daowei.www.daoweitwo.dagger;

import com.daowei.www.daoweitwo.view.home.HomeFragment;

import dagger.Component;

/**
 *
 * Created by yulu on 2017/2/21.
 */
@Component(modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeFragment fragment);
}
