package com.everywhere.trip.ui.main.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.everywhere.trip.R;
import com.everywhere.trip.base.Constants;
import com.everywhere.trip.util.SpUtil;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {
    private int time = 2;
    private Timer timer;
    private static final String TAG = "SplashActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.e(TAG, "onCreate: Mytoken"+SpUtil.getParam(Constants.TOKEN,"") );
        startTimer();
    }

    public void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump(time);
            }
        }, 1500);
    }

    private void jump(int time) {
        timer.cancel();

        if (!TextUtils.isEmpty((String) SpUtil.getParam(Constants.TOKEN, ""))) {
            startActivity(new Intent(this, MainActivity.class));
        } else if ((boolean) SpUtil.getParam("isPagerOpened", false)) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            startActivity(new Intent(this, PagerActivity.class));
        }
        finish();
    }

}
