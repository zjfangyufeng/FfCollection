package com.ff.demo.utils;

/**
 * Created by wb-fangyufeng on 2015/8/28.
 */
public class Log {

    static final boolean log = true;

    public static void i(String tag,String msg){
        if(log){
            android.util.Log.i(tag,msg);
        }
    }
}
