package com.dihmed.www.rxtest.presenter;

import android.graphics.Bitmap;

/**
 * Created by admin on 2018/3/24.
 */

public interface MainContract {
    //数据交换等逻辑处理
    interface Presenter{
        void getPicture();
    }
    //用于操作view层变化
    interface View{
        void showPicture(Bitmap bitmap);
    }
}
