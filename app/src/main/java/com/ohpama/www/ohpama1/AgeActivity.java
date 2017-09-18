package com.ohpama.www.ohpama1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class AgeActivity extends AppCompatActivity {
    private TextView tv_sel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        tv_sel = (TextView)findViewById(R.id.textView_sel_gender);
        tv_sel.setText(R.string.sel_age);
        tv_sel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);



    }
}
