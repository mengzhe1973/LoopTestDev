package com.puan.looptestdev.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.puan.looptestdev.BaseAvtivity;
import com.puan.looptestdev.R;

/**
 * Created by kiros on 2019/1/2.
 * 注册界面
 */

public class AdminActivity extends BaseAvtivity{

    private TextView register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        initView();
    }

    private void initView() {
        register = findViewById(R.id.btn_login);
        register.setText("注册");
    }
}
