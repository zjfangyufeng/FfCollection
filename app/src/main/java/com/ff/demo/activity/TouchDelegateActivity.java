package com.ff.demo.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.ff.demo.R;
import com.ff.demo.utils.MyDisplayMetrics;

public class TouchDelegateActivity extends Activity {
    Button btn,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_delegate);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        ((View)btn.getParent()).setTouchDelegate(new TouchDelegate(new Rect(0, 0,
                MyDisplayMetrics.getInstance().widthPixels / 2, MyDisplayMetrics.getInstance().heightPixels / 2), btn));
        btn2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                btn2.setTouchDelegate(new TouchDelegate(
                        new Rect(btn2.getLeft(), btn.getTop(), btn2.getRight(), btn2.getBottom()), btn3));
            }
        });

    }


}
