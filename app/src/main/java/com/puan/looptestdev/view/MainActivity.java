package com.puan.looptestdev.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.puan.looptestdev.BaseAvtivity;
import com.puan.looptestdev.R;


public class MainActivity extends BaseAvtivity {

    private EditText et_user_name, et_user_pwd;
    private Button btn_login;
    private ImageView add_user;
    private String userName, userPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        login();
        addUser();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        et_user_name = findViewById(R.id.et_user_name);
        et_user_pwd = findViewById(R.id.et_user_pwd);
        btn_login = findViewById(R.id.btn_login);
        add_user = findViewById(R.id.add_user);
    }

    /**
     * 登录
     */
    private void login() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = et_user_name.getText().toString().trim();
                userPwd = et_user_pwd.getText().toString().trim();

                if (TextUtils.isEmpty(userName)){
                    toast("用户名为空");
                }
                if (TextUtils.isEmpty(userPwd)){
                    toast("密码为空");
                }
            }
        });
    }

    /**
     * 增加用户
     */
    private void addUser() {
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}
