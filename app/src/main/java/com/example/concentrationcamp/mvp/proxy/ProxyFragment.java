package com.example.concentrationcamp.mvp.proxy;

import com.example.concentrationcamp.mvp.basemvp.IBaseView;

public class ProxyFragment<V extends IBaseView> extends Proxylmpl {

    public ProxyFragment(V view){
        super(view);
    }
}
