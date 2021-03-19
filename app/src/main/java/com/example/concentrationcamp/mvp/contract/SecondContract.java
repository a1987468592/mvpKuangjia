package com.example.concentrationcamp.mvp.contract;

import com.example.concentrationcamp.mvp.basemvp.IBasePresenter;
import com.example.concentrationcamp.mvp.basemvp.IBaseView;

import okhttp3.Callback;


public interface SecondContract {
    interface ISecondModel {
        void requestBaidu(Callback callback);
    }

    interface ISecondView extends IBaseView {
        void showDialog();

        void succes(String content);
    }

    interface ISecondPresenter extends IBasePresenter {
        void handlerData();
    }
}