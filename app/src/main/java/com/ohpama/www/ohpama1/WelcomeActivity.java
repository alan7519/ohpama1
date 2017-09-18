package com.ohpama.www.ohpama1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    private ImageButton btn_rtn;
    private TextView tv_ignore;
    private TextView tv_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // 隐藏不必要的元素，设置元素新信息
        btn_rtn = (ImageButton)findViewById(R.id.imageButton_rtn);
        btn_rtn.setVisibility(View.INVISIBLE);
        tv_ignore = (TextView)findViewById(R.id.textView_ignore);
        tv_ignore.setVisibility(View.INVISIBLE);
        //设置元素新信息
        tv_version = (TextView)findViewById(R.id.textView_yizhanshi);
        tv_version.setText(R.string.version);
        tv_version.setTextColor(Color.parseColor("#ff757575"));

        tv_version = (TextView)findViewById(R.id.textView_sel_gender);
        tv_version.setText("Landing");
        tv_version.setTextColor(Color.parseColor("#ff757575"));
        tv_version.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

//通过click事件跳转
//        button = (Button) findViewById(R.id.bt1);
//        button.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //显示方式声明Intent，直接启动SecondActivity
//                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
//            }
//        });
// 这里暂时用wait3秒跳转
        this.getGenderActivity();
    }

    private void getGenderActivity() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, GenderActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        };
        timer.schedule(task, 2500);
    }


}
