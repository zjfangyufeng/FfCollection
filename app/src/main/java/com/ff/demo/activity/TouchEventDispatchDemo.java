package com.ff.demo.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ff.demo.R;
import com.ff.demo.custom_view.MyLinearLayout;
import com.ff.demo.utils.MyDisplayMetrics;
import com.ff.demo.utils.TextViewLog;

public class TouchEventDispatchDemo extends Activity {
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

        textViewLog = new TextViewLog(this,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,MyDisplayMetrics.getDensitySize(250)));
        linearLayout.addView(textViewLog);
        linearLayout.addView(new MyLinearLayout(this, textViewLog));




    }


}
