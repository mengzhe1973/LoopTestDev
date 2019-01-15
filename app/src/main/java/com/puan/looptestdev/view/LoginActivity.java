package com.puan.looptestdev.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.puan.looptestdev.BaseAvtivity;
import com.puan.looptestdev.R;
import com.puan.looptestdev.db.DbUtil;
import com.puan.looptestdev.db.UserHelper;
import com.puan.looptestdev.entity.User;
import com.puan.looptestdev.widget.CustomDialog;

import java.util.List;

/**
 * 登录界面
 */
public class LoginActivity extends BaseAvtivity implements View.OnClickListener {

    private EditText et_user_name, et_user_pwd;
    private Button btn_login;
    private ImageView add_user;
    private String userName, userPwd;
    private Dialog dialog;
    private EditText dialog_admin, dialog_pwd;
    private UserHelper userHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        login();
        addUser();

        userHelper = DbUtil.getDriverHelper();

        List<User> users = userHelper.queryAll();

        for (User user : users){
            Log.d("user", user.getPhone());
        }
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

                if (TextUtils.isEmpty(userName)) {
                    toast("用户名为空");
                }
                if (TextUtils.isEmpty(userPwd)) {
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
                showDialog();
            }
        });
    }

    //点击按钮，弹出圆角对话框
    public void showDialog() {
        dialog = new Dialog(this, R.style.dialog);
        Window window = dialog.getWindow();
        View contentView = this.getLayoutInflater().inflate(R.layout.layout_dialog, null);
        dialog_admin = contentView.findViewById(R.id.et_admin_custom_dialog);
        dialog_pwd = contentView.findViewById(R.id.et_password_custom_dialog);
        TextView tv_title = contentView.findViewById(R.id.tv_title_custom_dialog);
        Button tv_cancel = contentView.findViewById(R.id.btn_negative_custom_dialog);
        Button tv_positive = contentView.findViewById(R.id.btn_positive_custom_dialog);
        dialog.setContentView(contentView);
        tv_title.setText("管理员登录");
        tv_cancel.setOnClickListener(LoginActivity.this);
        tv_positive.setOnClickListener(LoginActivity.this);
        dialog.show();
    }

    @Override
    public void onClick(View v) {
        String str_admin = dialog_admin.getText().toString().trim();
        String str_password = dialog_pwd.getText().toString().trim();
        switch (v.getId()) {
            case R.id.btn_negative_custom_dialog:
                dialog.dismiss();
                break;
            case R.id.btn_positive_custom_dialog:
                if (TextUtils.isEmpty(str_admin)) {
                    toast("请输入管理员账号");
                }
                if (TextUtils.isEmpty(str_password)) {
                    toast("请输入密码");
                }
                if (TextUtils.equals(str_admin, "admin") && TextUtils.equals(str_password, "123456")) {
                    Intent intent = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(intent);
                    dialog.dismiss();
                } else {
                    toast("账号或者密码错误");
                }
                break;
        }
    }
}
