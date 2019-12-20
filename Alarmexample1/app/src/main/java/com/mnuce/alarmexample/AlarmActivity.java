package com.mnuce.alarmexample;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

public class AlarmActivity extends AppCompatActivity {

    public static String signal;
    public static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        signal=null;
        // 알람음 재생
        AlarmActivity.mediaPlayer = MediaPlayer.create(this, R.raw.song);
        AlarmActivity.mediaPlayer.start();

        findViewById(R.id.btnClose).setOnClickListener(mClickListener);
//        MainActivity.listen();
//        if(signal=="alarmoff")  close();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        // MediaPlayer release
        if (AlarmActivity.mediaPlayer != null) {
            AlarmActivity.mediaPlayer.release();
            AlarmActivity.mediaPlayer = null;
        }
    }

    /* 알람 종료 */
    public void close() {
        if (AlarmActivity.mediaPlayer.isPlaying()) {
            AlarmActivity.mediaPlayer.stop();
            AlarmActivity.mediaPlayer.release();
            AlarmActivity.mediaPlayer = null;
        }

        finish();
    }

    View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnClose:
                    // 알람 종료
                    close();

                    break;
            }
        }
    };

}