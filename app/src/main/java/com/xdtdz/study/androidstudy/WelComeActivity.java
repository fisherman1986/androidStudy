package com.xdtdz.study.androidstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE) //exends Activity;
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();  //extends AppCompatActivity
        Handler handler = new Handler();
        //当计时结束,跳转至主界面
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, FirstActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 2000);

    }
}
