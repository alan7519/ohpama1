package com.ohpama.www.ohpama1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.edit;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_rtn;
    private TextView tv_ignore;
    private ImageView iv_male;
    private ImageView iv_female;
    public static final String TAG = "AAAA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        //在一个textView中设置不同字体，span样式
        TextView gender = (TextView) findViewById(R.id.textView_sel_gender);
        SpannableString sel_gender = SpannableString.valueOf(getString(R.string.sel_gender));
        sel_gender.setSpan(
                new TextAppearanceSpan(this, R.style.style18ft),
                0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sel_gender.setSpan(
                new TextAppearanceSpan(this, R.style.style13ft),
                7, sel_gender.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        gender.setText(sel_gender, TextView.BufferType.SPANNABLE);

        //设置toolbar信息 在layout中添加了toolbar,  but  toolbar 在这里多余
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setLogo(R.drawable.ic_launcher);
//        toolbar.setTitle("My Title");
//        toolbar.setSubtitle("Sub title");
//        setSupportActionBar(toolbar);

        // 对<--添加监听点击
        btn_rtn = (ImageButton) findViewById(R.id.imageButton_rtn);
        btn_rtn.setOnClickListener(this);

        tv_ignore = (TextView) findViewById(R.id.textView_ignore);
//        tv_ignore.setClickable(true);
        tv_ignore.setFocusable(true);
        tv_ignore.setOnClickListener(this);

        iv_male = (ImageView) findViewById(R.id.imageView_male);
        iv_male.setOnClickListener(this);

        iv_female = (ImageView) findViewById(R.id.imageView_female);
        iv_female.setOnClickListener(this);
    }
//        btn_rtn.setOnClickListener(new View.OnClickListener() {
//            //            public static final String TAG = "AAAA";
//            @Override
//            public void onClick(View arg0) {
////                    Log.i(TAG, "onClick: ");
////                System.out.println("okokok");
//                Intent myIntent = new Intent();
//                myIntent = new Intent(GenderActivity.this, WelcomeActivity.class);
//                startActivity(myIntent);
//            }
//        });


        // 增加TextView的点击事件
//        tv_ignore.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent myIntent = new Intent();
//                myIntent = new Intent(GenderActivity.this, AgeActivity.class);
//                startActivity(myIntent);
//            }
//        });

        // 修改为添加统一的点击监听函数

    // shoule call  saveUserInfo();
    private void saveUserInfo(){
        SharedPreferences userInfo = getSharedPreferences("ohpama_info", MODE_PRIVATE);
        SharedPreferences.OnSharedPreferenceChangeListener changeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences preferences, String key) {
                //preferences被 编辑的SharedPreferences实例
                //该SharedPreferences中被编辑的条目所对应的key
            }
        };
        //userInfo注册监听事件
        userInfo.registerOnSharedPreferenceChangeListener(changeListener);
        SharedPreferences.Editor editor = userInfo.edit();//获取Editor
        //得到Editor后，写入需要保存的数据
        editor.putString("gender", "male");
//        editor.putInt("age", 20);
        editor.commit();//提交修改
        Log.i(TAG, "保存用户信息成功");
    }
// v对象为绑定的控件
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton_rtn: {
                //  intent to welcome_activity
                Intent myIntent = new Intent();
                myIntent = new Intent(GenderActivity.this, WelcomeActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.textView_ignore: {
                // intent to age_activity
                Intent myIntent = new Intent();
                myIntent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.imageView_female: {
                // save , intent to age_activity
                saveUserInfo();
                Intent myIntent = new Intent();
                myIntent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.imageView_male: {
                Toast.makeText(getApplicationContext(), "AAAAAAA", Toast.LENGTH_SHORT).show();

                saveUserInfo();
                Intent myIntent = new Intent();
                myIntent = new Intent(GenderActivity.this, AgeActivity.class);
                startActivity(myIntent);
                // save , intent to age_activity
                break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}