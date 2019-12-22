package com.mnuce.bluetoothexample;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;

import static android.os.SystemClock.sleep;

public class SubActivity extends AppCompatActivity implements Runnable {
    Data sdata = new Data();
    public String signal="on";
    public String activity="off";
    //MainActivity ma;
    public static Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        mContext = this;

        signal="on";
//        Log.i("ma.signal 초기값",ma.signal);
//        if(signal.equals("alarmoff")) {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//        }

        Thread th = new Thread(SubActivity.this);
        th.start();

    }

    @Override
    public void run() {
        while (true) {
            Log.i("Thread sdata.signal", "" + signal);
            if(signal.equals("alarmoff")) {
                close();
                break;
            }
            sleep(500);
        }
    }

    public void close() {
        finish();
    }

    public void setSignal (String string) {
        signal = string;
    }
    public String getSignal() { return signal; }
    public void setActivity (String string) {   activity=string;    }
    public String getActivity() { return signal; }
}