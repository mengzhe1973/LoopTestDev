package com.puan.looptestdev.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.puan.looptestdev.BaseAvtivity;
import com.puan.looptestdev.R;
import com.puan.looptestdev.db.DbUtil;
import com.puan.looptestdev.db.UserHelper;
import com.puan.looptestdev.entity.User;

/**
 * Created by kiros on 2019/1/2.
 * 注册界面
 */

public class AdminActivity extends BaseAvtivity{

    private Button register;
    private EditText et_user, et_password;
    private UserHelper userHelper;
    private String userName, password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        initView();

        userHelper = DbUtil.getDriverHelper();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = et_user.getText().toString();
                password = et_password.getText().toString();

                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)){
                    long id = userHelper.count();
                    User user = new User(id, userName, password);
                    userHelper.save(user);
                } else {
                    if (TextUtils.isEmpty(userName)) {
                        toast("请输入用户名");
                    }
                    if (TextUtils.isEmpty(password)) {
                        toast("请输入密码");
                    }
                }
            }
        });
    }

    private void initView() {
        register = findViewById(R.id.btn_login);
        et_user = findViewById(R.id.et_user_name);
        et_password = findViewById(R.id.et_user_pwd);
        register.setText("注册");
    }
}
