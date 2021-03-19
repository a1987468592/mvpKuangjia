package com.example.concentrationcamp.mvp.presenter;

import com.example.concentrationcamp.mvp.basemvp.BasePresenter;
import com.example.concentrationcamp.mvp.contract.SecondContract;
import com.example.concentrationcamp.mvp.model.SecondModel;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SecondPresenter extends BasePresenter<SecondContract.ISecondView, SecondModel> implements SecondContract.ISecondPresenter {
    @Override
    public void handlerData() {
        getView().showDialog();
        getModel().requestBaidu(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String content = response.body().string();
                getView().succes(content);
            }
        });
    }
}
