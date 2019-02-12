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
import com.puan.looptestdev.widget.MarkerShowCmpt;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by kiros on 2019/1/14.
 */

public class MainActivity extends BaseAvtivity {

    private Button connect;
    private MarkerShowCmpt u1, u2, u3, i1, i2, i3;
//    private String content = "$U1:12.395V$U2:12.242V$U3:12.205V$I1:39.304mA$I2:38.416mA$I3:38.720mAFU1:0.00FU2:119.84FU3:239.90FI1:0.00FI2:119.84FI3:239.90 F:49.93.trim()";
    private String content = "$U1:12.223V$U2:12.437V$U3:12.241V$I1:39.298mA$I2:38.332mA$I3:38.769mAFU1:0.00FU2:239.92FU3:120.00FI1:59.94FI2:359.92FI3:120.00 F:49.93".trim();
    String U1, U2, U3, I1, I2, I3, rotationU1, rotationU2, rotationU3, rotationI1, rotationI2, rotationI3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        U1 = subString(content, "$U1:", "V$U2:");
        U2 = subString(content, "$U2:", "V$U3:");
        U3 = subString(content, "$U3:", "V$I1:");
        I1 = subString(content, "$I1:", "mA$I2:");
        I2 = subString(content, "$I2:", "mA$I3:");
        I3 = subString(content, "$I3:", "mAFU1:");

        rotationU1 = subString(content, "FU1:", "FU2:");
        rotationU2 = subString(content, "FU2:", "FU3:");
        rotationU3 = subString(content, "FU3:", "FI1:");
        rotationI1 = subString(content, "FI1:", "FI2:");
        rotationI2 = subString(content, "FI2:", "FI3:");
        rotationI3 = subString(content, "FI3:", "F:");


        Log.d("aaaaaaa", U1 + "-" + U2 + "-" + U3 + "-" + I1 + "-" + I2 + "-" + I3
        + "-" + rotationU1 + "-" + rotationU2 + "-" + rotationU3 + "-" + rotationI1 + "-" + rotationI2 + "-" + rotationI3);

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
        u1 = findViewById(R.id.u1);
        u2 = findViewById(R.id.u2);
        u3 = findViewById(R.id.u3);
        i1 = findViewById(R.id.i1);
        i2 = findViewById(R.id.i2);
        i3 = findViewById(R.id.i3);

        u1.setVisibility(View.VISIBLE);
        u1.setRotation(Float.valueOf(rotationU1));
        u1.setValue(Float.valueOf(U1));
        u1.setText("U1");

        u2.setVisibility(View.VISIBLE);
        u2.setRotation(Float.valueOf(rotationU2));
        u2.setValue(Float.valueOf(U2));
        u2.setText("U2");

        u3.setVisibility(View.VISIBLE);
        u3.setRotation(Float.valueOf(rotationU3));
        u3.setValue(Float.valueOf(U3));
        u3.setText("U3");

        i1.setVisibility(View.VISIBLE);
        i1.setRotation(Float.valueOf(rotationI1));
        i1.setValue(Float.valueOf(I1));
        i1.setText("I1");

        i2.setVisibility(View.VISIBLE);
        i2.setRotation(Float.valueOf(rotationI2));
        i2.setValue(Float.valueOf(I2));
        i2.setText("I2");

        i3.setVisibility(View.VISIBLE);
        i3.setRotation(Float.valueOf(rotationI3));
        i3.setValue(Float.valueOf(I3));
        i3.setText("I3");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 截取字符串str中指定字符 strStart、strEnd之间的字符串
     *
     * @param str
     * @param strStart
     * @param strEnd
     * @return
     */
    public static String subString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }
        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }
}
