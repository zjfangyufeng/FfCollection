package com.ff.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ff.demo.R;
import com.ff.demo.annotation.FruitName;

import java.lang.reflect.Field;

public class AnnotationActivity extends AppCompatActivity {

    @FruitName("apple")
    String fruitName = "pear";

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        tv = (TextView) findViewById(R.id.tv);

        tv.setText("fruitName "+fruitName+" annotation fruitName " + getAnnotationValue());
    }

    public static String getAnnotationValue(){
        try {
            Field fruitName = AnnotationActivity.class.getDeclaredField("fruitName");
            if (fruitName.isAnnotationPresent(FruitName.class)) {
                FruitName annotation = fruitName.getAnnotation(FruitName.class);
                return annotation.value();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
