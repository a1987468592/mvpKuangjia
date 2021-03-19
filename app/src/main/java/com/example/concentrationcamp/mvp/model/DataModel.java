package com.example.concentrationcamp.mvp.model;

import com.example.concentrationcamp.mvp.contract.MainContract;
import com.example.concentrationcamp.mvp.basemvp.BaseModel;

import okhttp3.Callback;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class DataModel extends BaseModel implements MainContract.IMainModel {

    @Override
    public void requestBaiDu(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }

}
