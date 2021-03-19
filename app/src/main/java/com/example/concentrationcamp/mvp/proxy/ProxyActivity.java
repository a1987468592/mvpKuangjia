package com.example.concentrationcamp.mvp.proxy;

import com.example.concentrationcamp.mvp.basemvp.IBaseView;

import java.lang.reflect.Proxy;

public class ProxyActivity <V extends IBaseView> extends Proxylmpl {

    public  ProxyActivity(V view){
        super(view);
    }
}
