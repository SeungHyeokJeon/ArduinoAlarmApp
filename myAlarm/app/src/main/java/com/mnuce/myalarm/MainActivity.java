package com.mnuce.myalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    TextView timeTextView;
    Switch switchView;

    private Intent serviceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeTextView=(TextView)findViewById(R.id.time);
        switchView=(Switch)findViewById(R.id.onOff);

        timeTextView.setOnClickListener(this);
        switchView.setOnCheckedChangeListener(this);

    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onClick(View v) {
        if(v==timeTextView) {
            showToast("시간 클릭");
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isCheck) {
        if(buttonView==switchView) {
            showToast("switch is "+isCheck);
        }
    }
}
