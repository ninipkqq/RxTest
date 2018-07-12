package com.dihmed.www.rxtest.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.dihmed.www.rxtest.di.modules.NetModule;
import com.dihmed.www.rxtest.model.api.Api;

import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by admin on 2018/3/24.
 */

public class MainPresenter implements MainContract.Presenter{
    private MainContract.View view;

    @Inject
    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void getPicture() {
        Retrofit re = NetModule.create();
        Api api = re.create(Api.class);
        api.getPicture("pm0036-3960oz.jpg")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap apply(@NonNull ResponseBody responseBody) throws Exception {
                        InputStream inputStream = responseBody.byteStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                        return bitmap;
                    }
                })
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Bitmap bitmap) {
                        view.showPicture(bitmap);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
