package com.puan.looptestdev.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.puan.looptestdev.BaseAvtivity;

import java.util.UUID;

import cn.com.heaton.blelibrary.ble.Ble;
import cn.com.heaton.blelibrary.ble.BleDevice;
import cn.com.heaton.blelibrary.ble.callback.BleScanCallback;

/**
 * Created by kiros on 2019/1/14.
 */

public class MainActivity extends BaseAvtivity{
    private Ble<BleDevice> mBle;

    BleScanCallback<BleDevice> scanCallback = new BleScanCallback<BleDevice>() {
        @Override
        public void onLeScan(final BleDevice device, int rssi, byte[] scanRecord) {
            Toast.makeText(MainActivity.this, "ssss", Toast.LENGTH_SHORT).show();
            synchronized (mBle.getLocker()) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        toast(device.getBleName());
                    }
                });
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBle();
        mBle.startScan(scanCallback);

    }

    private void initBle() {
        mBle = Ble.options()
                .setLogBleExceptions(true)//设置是否输出打印蓝牙日志（非正式打包请设置为true，以便于调试）
                .setThrowBleException(true)//设置是否抛出蓝牙异常
                .setAutoConnect(true)//设置是否自动连接
                .setConnectFailedRetryCount(3)
                .setConnectTimeout(10 * 1000)//设置连接超时时长（默认10*1000 ms）
                .setScanPeriod(12 * 1000)//设置扫描时长（默认10*1000 ms）
                .setUuid_service(UUID.fromString("0000fee9-0000-1000-8000-00805f9b34fb"))//主服务的uuid
                .setUuid_write_cha(UUID.fromString("d44bc439-abfd-45a2-b575-925416129600"))//可写特征的uuid
                .create(getApplicationContext());
    }
}
