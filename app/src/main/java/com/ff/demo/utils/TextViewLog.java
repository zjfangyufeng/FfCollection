package com.ff.demo.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ff.demo.R;

/**
 * Created by wb-fangyufeng on 2015/8/28.
 */
public class TextViewLog extends RelativeLayout{

    TextView textView;

    public TextViewLog(Context context,ViewGroup.LayoutParams lp) {
        super(context);
        this.setLayoutParams(lp);
        this.setBackgroundColor(Color.GRAY);
        View view = View.inflate(context,R.layout.textviewlog,this);

        textView = (TextView) view.findViewById(R.id.tv);
        view.findViewById(R.id.btn_clear).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(null);
            }
        });
    }


    public void i(String msg){
        textView.append(msg + "\n");
    }
}
