package com.dihmed.www.rxtest.di.components;

import com.dihmed.www.rxtest.di.modules.MainModule;
import com.dihmed.www.rxtest.presenter.MainPresenter;

import dagger.Component;

/**
 * Created by admin on 2018/3/24.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    MainPresenter getPresenter();
}
