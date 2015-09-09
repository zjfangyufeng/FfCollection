package com.ff.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;

import com.ff.demo.IRemoteServiceAidlInterface;

import java.net.BindException;

public class AIDLRemoteService extends Service {

//    Messenger messenger = new Messenger();
    public AIDLRemoteService() {
    }

    IRemoteServiceAidlInterface.Stub stub = new IRemoteServiceAidlInterface.Stub() {
        @Override
        public String getProcessInfo() throws RemoteException {
            String result= "pid:"+android.os.Process.myPid()+"uid:"+android.os.Process.myUid()+"tid:"+android.os.Process.myTid();
            return result;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

}
