package com.ff.demo.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ff.demo.R;
import com.ff.demo.utils.TextViewLog;

/**
 * TODO: document your custom view class.
 */
public class TouchEventLinearLayout extends LinearLayout {
    TextViewLog textViewLog;

    public TouchEventLinearLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(Color.BLUE);
    }

    public TouchEventLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TouchEventLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }




    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        textViewLog.i(this.getClass().getSimpleName()+" dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        textViewLog.i(this.getClass().getSimpleName()+" onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        textViewLog.i(this.getClass().getSimpleName()+" onTouchEvent");
        return super.onTouchEvent(event);
    }

    public TextViewLog getTextViewLog() {
        return textViewLog;
    }

    public void setTextViewLog(TextViewLog textViewLog) {
        this.textViewLog = textViewLog;
    }
}
