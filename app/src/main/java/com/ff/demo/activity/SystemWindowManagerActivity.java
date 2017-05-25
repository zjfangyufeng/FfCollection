package com.ff.demo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.ff.demo.R;

public class SystemWindowManagerActivity extends Activity implements View.OnClickListener {
    WindowManager windowManager;
    WindowManager.LayoutParams params;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_window_manager);
        findViewById(R.id.tv).setOnClickListener(this);
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        params  = new WindowManager.LayoutParams();

        tv = new TextView(this);
        tv.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        tv.setText("ff");
        tv.setTextColor(Color.parseColor("#ff0000"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                windowManager.addView(tv,params);
                break;
            default:
                break;
        }

    }
}
