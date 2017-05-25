package com.ff.demo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.ff.demo.R;
import com.ff.demo.utils.Log;

public class AnimActivity extends AppCompatActivity implements View.OnClickListener {
    View view1,view2,view3;
    AnimationSet set;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        findViewById(R.id.btn).setOnClickListener(this);
        View v = findViewById(R.id.view);
//        View view1 = findViewById(R.id.view1);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
//        View view3 = findViewById(R.id.view3);
//        View view4 = findViewById(R.id.view4);
        TranslateAnimation animation = new TranslateAnimation(0,-200,0,0);
        animation.setDuration(1000);
        v.startAnimation(animation);

        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 5, 1, 5, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation.setRepeatCount(Animation.INFINITE);
//        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1, 10, 1, 10, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        scaleAnimation2.setStartOffset(5000);
//        AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        set = new AnimationSet(true);
        set.addAnimation(scaleAnimation);
//        set.addAnimation(scaleAnimation2);
//        set.addAnimation(alphaAnimation);
        set.setDuration(3000);

    }

    int positon;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        switch (positon){
                            case 0:
                                view1.startAnimation(set);
                                Log.i("aa","1");
                                break;
                            case 1:
                                view2.startAnimation(set);
                                Log.i("aa","2");
                                break;
                            case 2:
                                view3.startAnimation(set);
                                Log.i("aa","3");
                                break;
                            default:
                                positon = 0;
                                view1.startAnimation(set);
                                Log.i("aa","1");
                                break;
                        }
                        positon++;
                    }
                });
                break;
        }
    }
}
