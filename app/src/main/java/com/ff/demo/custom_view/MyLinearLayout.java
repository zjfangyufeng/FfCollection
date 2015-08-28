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
public class MyLinearLayout extends LinearLayout {
    TextViewLog textViewLog;

    public MyLinearLayout(Context context,TextViewLog textViewLog) {
        super(context);
        this.textViewLog = textViewLog;
        setOrientation(VERTICAL);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
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


}
