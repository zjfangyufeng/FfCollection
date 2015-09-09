package com.ff.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.*;

public class LocalService extends Service {
    public LocalService() {
    }

    MyBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        public LocalService getIntance(){
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getProcessInfo(){
        String result= "pid:"+android.os.Process.myPid()+"uid:"+android.os.Process.myUid()+"tid:"+android.os.Process.myTid();
        return result;
    }
}
