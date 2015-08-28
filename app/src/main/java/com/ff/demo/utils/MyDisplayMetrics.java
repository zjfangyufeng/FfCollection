package com.ff.demo.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by wb-fangyufeng on 2015/8/28.
 */
public class MyDisplayMetrics {

    public static DisplayMetrics metric;

    public synchronized static DisplayMetrics init(Activity c){
        if(metric == null){
            metric = new DisplayMetrics();
            c.getWindowManager().getDefaultDisplay().getMetrics(metric);
        }
        return metric;
    }

    public static DisplayMetrics getInstance(){
        return metric;
    }

    public static float getDensity(){
        return metric.density;
    }

    public static int getDensitySize(int s){
        return (int) (metric.density*s);
    }
}
