package com.ff.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.ff.demo.custom_view.TouchEventLinearLayout;
import com.ff.demo.custom_view.TouchEventView;
import com.ff.demo.utils.MyDisplayMetrics;
import com.ff.demo.utils.TextViewLog;

public class TouchEventDispatchViewDemo extends Activity {
    TextViewLog textViewLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(linearLayout);

        textViewLog = new TextViewLog(this);
        textViewLog.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, MyDisplayMetrics.getDensitySize(250)));
        linearLayout.addView(textViewLog);
        TouchEventLinearLayout touchEventLinearLayout = new TouchEventLinearLayout(this);
        touchEventLinearLayout.setTextViewLog(textViewLog);
        linearLayout.addView(touchEventLinearLayout);
        TouchEventView v = new TouchEventView(this,textViewLog);
        v.setClickable(true);
        touchEventLinearLayout.addView(v);



    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        textViewLog.i("activity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        textViewLog.i("activity onTouchEvent");
        return super.onTouchEvent(event);
    }
}
