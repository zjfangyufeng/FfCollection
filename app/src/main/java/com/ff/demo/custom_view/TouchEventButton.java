package com.ff.demo.custom_view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ff.demo.utils.TextViewLog;

/**
 * TODO: document your custom view class.
 */
public class TouchEventButton extends Button {
    TextViewLog textViewLog;

    public TouchEventButton(Context context) {
        super(context);
    }

    public TouchEventButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchEventButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        textViewLog.i(this.getClass().getSimpleName() + " dispatchTouchEvent --- " +b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        textViewLog.i(this.getClass().getSimpleName() + " onTouchEvent --- " +b);
        return b;
    }

    public void setTextViewLog(TextViewLog textViewLog) {
        this.textViewLog = textViewLog;
    }
}
