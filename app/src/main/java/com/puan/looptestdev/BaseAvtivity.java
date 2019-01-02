package com.puan.looptestdev;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by kiros on 2018/12/19.
 */

public class BaseAvtivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void toast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void toast(int resId){
        Toast.makeText(this, getResources().getText(resId), Toast.LENGTH_SHORT).show();
    }
}
