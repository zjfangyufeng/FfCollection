package com.ff.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.ff.demo.R;
import com.ff.demo.custom_view.TouchEventButton;
import com.ff.demo.custom_view.TouchEventLinearLayout;
import com.ff.demo.custom_view.TouchEventView;
import com.ff.demo.utils.TextViewLog;

public class TouchEventDispatchButtonDemo extends Activity {
    TextViewLog textViewLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_button);

        textViewLog = (TextViewLog) findViewById(R.id.textviewlog);
        TouchEventLinearLayout touchevent_ll = (TouchEventLinearLayout) findViewById(R.id.touchevent_ll);
        touchevent_ll.setTextViewLog(textViewLog);

        TouchEventButton touchEventButton = (TouchEventButton) findViewById(R.id.touchevent_btn);
        touchEventButton.setTextViewLog(textViewLog);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        textViewLog.i("activity dispatchTouchEvent --- "+b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        textViewLog.i("activity onTouchEvent --- "+b);
        return b;
    }
}
