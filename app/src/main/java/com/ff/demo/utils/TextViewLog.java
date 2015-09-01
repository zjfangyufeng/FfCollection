package com.ff.demo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
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

    public TextViewLog(Context context) {
        super(context);
        init(context);
    }

    public TextViewLog(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TextViewLog(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        this.setBackgroundColor(Color.GRAY);
        View view = View.inflate(context, R.layout.textviewlog,this);

        textView = (TextView) view.findViewById(R.id.tv);
        view.findViewById(R.id.btn_clear).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(null);
            }
        });

        view.findViewById(R.id.btn_desc).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(v.getContext()).setMessage(
                        "触摸事件先传递到顶层可见activity中dispatchTouchEvent，" +
                                "然后从rootview（ViewGroup）开始dispatchTouchEvent，" +
                                "viewGroup中的dispatchTouchEvent在分发前会判断是否interceptTouchEvent，如果true，" +
                                "则不再分发事件，到了自己的ontouch中执行，" +
                                "如果为false，则循环所有子view，判断event坐标是否在子view区域中，" +
                                "如果是，调用子view的dispatch分发事件，以上是viewGroup类型分发逻辑，接下来说view的分发逻辑。" +
                                "view中的dispatchTouchEvent，首先判断是否有onTouchListener，有则执行，然后如果OnTouchListener" +
                                "返回false，继续执行view本身的OnTouchEvent，" +
                                "view本身的onTouchEvent先调用mTouchDelegate，如果delegate未消费" +
                                "判断是否clickable或longClickable，如果为是则消费此事件，否则返回false，" +
                                "当所有view都未消费此事件，则倒序得将此事件传递到ontouch事件，最后回归到activity的ontouch事件中").create().show();
            }
        });
    }


    public void i(String msg){
        textView.append(msg + "\n");
    }
}
