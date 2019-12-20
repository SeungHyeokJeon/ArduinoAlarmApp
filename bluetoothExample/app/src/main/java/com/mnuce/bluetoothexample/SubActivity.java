package com.mnuce.bluetoothexample;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
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
    String signal="on";
    //MainActivity ma;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        sdata.signal="on";
//        Log.i("ma.signal 초기값",ma.signal);
//        if(signal.equals("alarmoff")) {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//        }

//        Thread th = new Thread(SubActivity.this);
//        th.start();

    }

    @Override
    public void run() {
        while(true) {
            Log.i("Thread sdata.signal",""+sdata.signal);
            if(sdata.signal.equals("alarmoff")) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}