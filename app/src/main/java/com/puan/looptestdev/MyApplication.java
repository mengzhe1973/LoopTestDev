package com.puan.looptestdev;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.puan.looptestdev.db.DbCore;

/**
 * Created by kiros on 2018/12/23.
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        DbCore.init(this);
        DbCore.enableQueryBuilderLog(); //开启调试 log
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
