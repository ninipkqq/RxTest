package com.dihmed.www.rxtest.view.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.dihmed.www.rxtest.R;
import com.dihmed.www.rxtest.di.components.DaggerMainComponent;
import com.dihmed.www.rxtest.di.modules.MainModule;
import com.dihmed.www.rxtest.presenter.MainContract;
import com.dihmed.www.rxtest.presenter.MainPresenter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    @BindView(R.id.iv)
    ImageView iv;
    @Inject
    MainPresenter presenter;

    private String Tag = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
//        presenter = new MainPresenter(this);
        //依赖注入
        presenter = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .getPresenter();
        presenter.getPicture();
    }

    private void init(){
//        iv = (ImageView) findViewById(R.id.iv);
//        getCurrentTimeZone();
    }

    @Override
    public void showPicture(Bitmap bitmap) {
        iv.setImageBitmap(bitmap);
    }


    /**
     * 获取当前时区
     * @return
     */
    public static String getCurrentTimeZone() {
        Long time = System.currentTimeMillis();
        int eightTimeChange = 28800000;
        TimeZone tz = TimeZone.getDefault();
        int currentTimeChange = tz.getRawOffset();
        int timeChange = eightTimeChange-currentTimeChange;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd.HHmmss", Locale.getDefault());
        Date date = new Date(time+timeChange);
        String dateTime = format.format(date);
        Log.e("aaa",dateTime);
//        TimeZone tz = TimeZone.getDefault();
//        Log.e("aaa",tz.toString());
//        int rawOffset = tz.getRawOffset();
//        Log.e("aaa","rawOffset"+rawOffset);
        String strTz = tz.getDisplayName(false, TimeZone.SHORT);
//        Log.e("aaa",strTz);
        return strTz;
//1522205811400
    }
}
