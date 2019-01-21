package com.puan.looptestdev.view;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.puan.looptestdev.BaseAvtivity;
import com.puan.looptestdev.R;
import com.puan.looptestdev.adapter.BleAdapter;
import com.puan.looptestdev.entity.Device;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kiros on 2019/1/14.
 */

public class MainActivity extends BaseAvtivity {

    private Button connect;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BTClient.class));
            }
        });
    }


    private void initView() {
        connect = findViewById(R.id.connect);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
