package com.example.concentrationcamp.mvp.model;

import com.example.concentrationcamp.mvp.basemvp.BaseModel;
import com.example.concentrationcamp.mvp.contract.SecondContract;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class SecondModel extends BaseModel implements SecondContract.ISecondModel {

    @Override
    public void requestBaidu(Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com/")
                .build();
        client.newCall(request).enqueue(callback);
    }
}
