package com.ff.demo.custom_view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ff.demo.R;
import com.ff.demo.utils.TextViewLog;

/**
 * TODO: document your custom view class.
 */
public class TouchEventView extends View {
    TextViewLog textViewLog;

    public TouchEventView(Context context, TextViewLog textViewLog) {
        super(context);
        this.textViewLog = textViewLog;
        setBackgroundColor(Color.RED);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(200,200);
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        setLayoutParams(new ViewGroup.LayoutParams(200, 200));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = super.dispatchTouchEvent(ev);
        textViewLog.i(this.getClass().getSimpleName()+" dispatchTouchEvent " + b+ ev.getAction());
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean b = super.onTouchEvent(event);
        textViewLog.i(this.getClass().getSimpleName()+" onTouchEvent " + b+ event.getAction());
        return b;
    }


}
