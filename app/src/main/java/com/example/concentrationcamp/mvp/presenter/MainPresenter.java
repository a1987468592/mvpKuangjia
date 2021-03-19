package com.example.concentrationcamp.mvp.presenter;

import androidx.annotation.NonNull;

import com.example.concentrationcamp.mvp.contract.MainContract;
import com.example.concentrationcamp.mvp.basemvp.BasePresenter;
import com.example.concentrationcamp.mvp.model.DataModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainPresenter extends BasePresenter<MainContract.IMainView,DataModel> implements  MainContract.IMainPresenter{

    @Override
    public void handlerData() {
        getView().showDialog();
        getModel().requestBaiDu(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
            }
            @Override
            public void onResponse(@NonNull Call call,@NonNull Response response) throws IOException {
                String content = response.body().string();
                    getView().success(content);
            }
        });
    }

    @Override
    public void detach() {
        super.detach();
        //释放内存 关闭网络请求 关闭线程
    }
}
