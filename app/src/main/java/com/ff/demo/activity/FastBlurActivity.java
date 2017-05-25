package com.ff.demo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.ff.demo.R;
import com.ff.demo.utils.FastBlur;

public class FastBlurActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv,iv_bg;
    Bitmap bitmap;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_blur);
        iv = (ImageView) findViewById(R.id.iv);
        iv_bg = (ImageView) findViewById(R.id.iv_bg);
        et = (EditText) findViewById(R.id.et);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.c,options);
        iv.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View v) {
        String s = et.getText().toString();
        long l = System.currentTimeMillis();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 10, bitmap.getHeight() / 10, true);
        Bitmap bitmap = FastBlur.doBlur(scaledBitmap, TextUtils.isEmpty(s)?10:Integer.parseInt(s), true);
        btn.setText("blur cast time "+ (System.currentTimeMillis()-l));
        iv_bg.setImageBitmap(bitmap);
    }
}
