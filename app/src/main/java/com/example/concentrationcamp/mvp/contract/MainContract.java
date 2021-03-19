package com.example.concentrationcamp.mvp.contract;

import com.example.concentrationcamp.mvp.basemvp.IBasePresenter;
import com.example.concentrationcamp.mvp.basemvp.IBaseView;

import okhttp3.Callback;


public interface MainContract {
    interface  IMainModel {
        void requestBaiDu(Callback callback);
    }
    interface  IMainView extends IBaseView{
        void showDialog();
        void success(String content);
    }
    interface IMainPresenter extends IBasePresenter{
        void handlerData();
    }
}
