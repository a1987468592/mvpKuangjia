package com.example.concentrationcamp.mvp.basemvp;

public interface IBasePresenter <V extends IBaseView>{
    void attach(V view);

    void detach();
}
