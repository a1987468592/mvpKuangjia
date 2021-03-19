package com.example.concentrationcamp.mvp.view;

import androidx.annotation.NonNull;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.concentrationcamp.R;
import com.example.concentrationcamp.mvp.contract.MainContract;
import com.example.concentrationcamp.mvp.basemvp.BaseActivity;
import com.example.concentrationcamp.mvp.basemvp.InjectPresenter;
import com.example.concentrationcamp.mvp.contract.SecondContract;
import com.example.concentrationcamp.mvp.presenter.MainPresenter;

import java.time.Instant;

public class MainActivity extends BaseActivity implements  MainContract.IMainView{
    private TextView tv;
    private Button button;

    @InjectPresenter
    private MainPresenter mPresenter;

    @Override
    protected void initLayout(@NonNull Bundle savedInstanceStace) {
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void initView() {
        tv = $(R.id.tv);
        button = $(R.id.tiao);
    }

    @Override
    protected void initData() {
        mPresenter.handlerData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void showDialog() {
        ProgressDialog dialog = new ProgressDialog(getContext());
        dialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 1500);
    }

    @Override
    public void success(String content) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), "" + content, Toast.LENGTH_SHORT).show();
                tv.setText(content);
            }
        });
    }


}



