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
import android.widget.TextView;

import com.ff.demo.R;

import java.io.ByteArrayOutputStream;

public class BitmapCompressActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv;
    EditText et;
    ImageView iv1,iv2;
    Button btn_config ;
    Bitmap bitmap;
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    BitmapFactory.Options options = new BitmapFactory.Options();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_compress);
        tv = (TextView) findViewById(R.id.tv);
        et = (EditText) findViewById(R.id.et);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        findViewById(R.id.btn).setOnClickListener(this);
        findViewById(R.id.crop_bitmap).setOnClickListener(this);
        findViewById(R.id.btn_decode_bitmap).setOnClickListener(this);
        btn_config = (Button) findViewById(R.id.btn_config);
        btn_config.setOnClickListener(this);








    }

    int p;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_decode_bitmap:
                options.inPreferredConfig = getConfig();
                bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.b,options);
                setImage(bitmap);
                break;
            case R.id.crop_bitmap:
                bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
                setImage(bitmap);
                break;
            case R.id.btn:
                tv.setText("");
                String text = et.getText().toString();
                if(TextUtils.isEmpty(text))
                    text = "100";
                os.reset();
                bitmap.compress(Bitmap.CompressFormat.JPEG,Integer.parseInt(text),os);
                tv.append(bitmap.getByteCount()+" "+os.size()+" ");
                options.inPreferredConfig = getConfig();
                Bitmap b = BitmapFactory.decodeByteArray(os.toByteArray(),0,os.size(),options);
                setImage(b);
                break;
            case R.id.btn_config:
                String config = btn_config.getText().toString();
                if(config.equals("ARGB_8888")){
                    btn_config.setText("RGB_565");
                }else {
                    btn_config.setText("ARGB_8888");
                }
                break;
        }
    }

    void setImage(Bitmap bitmap){
        if(p%2==0){
            iv1.setImageBitmap(bitmap);
        }else {
            iv2.setImageBitmap(bitmap);
        }
        p++;
        tv.append(bitmap.getByteCount()+" ");
    }

    Bitmap.Config getConfig(){
        String config = btn_config.getText().toString();
        if(config.equals("ARGB_8888")){
            return Bitmap.Config.ARGB_8888;
        }else {
            return Bitmap.Config.RGB_565;
        }
    }
}
