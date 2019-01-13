package com.puan.looptestdev.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.puan.looptestdev.R;

/**
 * Created by kiros on 2019/1/13.
 */

public class CustomDialog extends Dialog {


    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private Context context;
        private String title;  //标题
        private String message;//提示消息
        private String negative_text;//消极的
        private String positive_text;//积极的
        private DialogInterface.OnClickListener negativeListener;//消极的监听
        private DialogInterface.OnClickListener positiveListener;//积极的监听

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            if (title == null) {
                this.title = "提醒";
            }
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            if (message == null) {
                this.message = "您没有填写提示信息哦";
            }
            this.message = message;
            return this;
        }

        public Builder setNegativeButton(String negative_text, DialogInterface.OnClickListener negativeListener) {
            if (negative_text == null) {
                this.negative_text = "取消";
            }
            this.negative_text = negative_text;
            this.negativeListener = negativeListener;

            return this;
        }

        public Builder setPositionButton(String positive_text, DialogInterface.OnClickListener positiveListener) {
            if (positive_text == null) {
                this.positive_text = "确定";
            }
            this.positive_text = positive_text;
            this.positiveListener = positiveListener;

            return this;
        }

        private TextView tv_title_custom_dialog;  //标题
        private TextView et_admin_custom_dialog;  //标题
        private TextView et_password_custom_dialog;  //标题
        private Button btn_negative_custom_dialog;//消极
        private Button btn_positive_custom_dialog;//积极


        public CustomDialog create() {
            final CustomDialog dialog = new CustomDialog(context);
            View view = LayoutInflater.from(context).inflate(R.layout.layout_dialog, null);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//加上这一句，取消原来的标题栏，没加这句之前，发现在三星的手机上会有一条蓝色的线
//            dialog.addContentView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            dialog.setContentView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tv_title_custom_dialog = view.findViewById(R.id.tv_title_custom_dialog);
            et_admin_custom_dialog = view.findViewById(R.id.et_admin_custom_dialog);
            et_password_custom_dialog = view.findViewById(R.id.et_password_custom_dialog);
            btn_negative_custom_dialog = view.findViewById(R.id.btn_negative_custom_dialog);
            btn_positive_custom_dialog = view.findViewById(R.id.btn_positive_custom_dialog);
            tv_title_custom_dialog.setText(title);
            btn_negative_custom_dialog.setText(negative_text);
            btn_positive_custom_dialog.setText(positive_text);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            btn_negative_custom_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    negativeListener.onClick(dialog, Dialog.BUTTON_NEGATIVE);
                }
            });
            btn_positive_custom_dialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    positiveListener.onClick(dialog, Dialog.BUTTON_POSITIVE);
                }
            });
            return dialog;
        }
    }
}
