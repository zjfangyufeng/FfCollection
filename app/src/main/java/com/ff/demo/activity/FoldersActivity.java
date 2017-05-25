package com.ff.demo.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.ff.demo.R;

public class FoldersActivity extends ActionBarActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folders);
        tv = (TextView) findViewById(R.id.tv);
        tv.append("getFilesDir()   " + getFilesDir() + "\n");
        tv.append("Environment.getExternalStorageDirectory()   " + Environment.getExternalStorageDirectory() + "\n");
        tv.append("getExternalFilesDir(null)    " + getExternalFilesDir(null) + "\n");
        tv.append("getExternalCacheDir()    " + getExternalCacheDir() + "\n");
        tv.append("getExternalFilesDir(Environment.DIRECTORY_DCIM)    " + getExternalFilesDir(Environment.DIRECTORY_DCIM) + "\n");
    }
}
