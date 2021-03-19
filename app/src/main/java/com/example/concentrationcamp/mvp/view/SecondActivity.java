package com.example.concentrationcamp.mvp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.concentrationcamp.R;
import com.example.concentrationcamp.mvp.view.fragment.SecondFragment;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /**
         * 开启一个 fragment
         */
        getSupportFragmentManager().beginTransaction().replace(R.id.second_container, new SecondFragment()).commit();
    }
}