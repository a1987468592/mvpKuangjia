package com.example.concentrationcamp.mvp.basemvp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.concentrationcamp.mvp.proxy.ProxyActivity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity implements IBaseView{

    private ProxyActivity mProxyActivity;

    protected  abstract void initLayout(@NonNull Bundle savedInstanceStace);

    protected  abstract void initView();

    protected  abstract void initData();


    @SuppressWarnings("SameParameterValue")
    protected <T extends View> T $(@IdRes int viewId){
        return findViewById(viewId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout(savedInstanceState);

        mProxyActivity = createProxyActivity();
        mProxyActivity.bindPresenter();

        initView();
        initData();
    }

    @SuppressWarnings("unchecked")
    private ProxyActivity createProxyActivity() {
        if (mProxyActivity == null) {
            return new ProxyActivity(this);
        }
        return mProxyActivity;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑P层 防止内存泄漏
        mProxyActivity.unbindPresenter();
    }
    @Override
    public Context getContext() {
        return this;
    }


}
