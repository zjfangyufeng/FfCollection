package com.ff.demo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.ff.demo.utils.Log;

public class AppInstallReceiver extends BroadcastReceiver {
    public AppInstallReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String packageName = getPackageName(intent.getDataString());
        Log.i("aa",System.currentTimeMillis()+"Ff"+action+intent.getDataString());
    }

    private String getPackageName(String s) {
        if (!TextUtils.isEmpty(s)) {
            int i = "package:".length();
            int j = s.indexOf("package:") + i;
            if (j >= i) {
                int k = s.length();
                if (j < k)
                    s = s.substring(j);
            }
        }
        return s;
    }

}
