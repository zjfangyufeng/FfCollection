package com.ff.demo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ff.demo.R;

public class PopupwindowActivity extends ActionBarActivity {
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);
        view = findViewById(R.id.tv);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                showPopupWindow();
            }
        },1000);

    }

    private void showPopupWindow() {
        PopupWindow popupWindow = new PopupWindow(this);
        TextView textView = new TextView(this);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2,-2));
        textView.setText("aa");
        textView.setTextColor(Color.parseColor("#ff0000"));
        popupWindow.setContentView(textView);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.showAsDropDown(view);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}
