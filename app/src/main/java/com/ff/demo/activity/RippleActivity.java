package com.ff.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ff.demo.R;
import com.ff.demo.custom_view.RippleBackground;

public class RippleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ripple);

        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);

        rippleBackground.startRippleAnimation();
    }

}
