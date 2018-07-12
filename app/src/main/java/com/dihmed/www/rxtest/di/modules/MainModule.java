package com.dihmed.www.rxtest.di.modules;

import com.dihmed.www.rxtest.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by admin on 2018/3/24.
 */

@Module
public class MainModule {
    private MainContract.View view;

    public MainModule(MainContract.View view){
        this.view = view;
    }

    @Provides
    public MainContract.View inject(){
        return view;
    }
}
