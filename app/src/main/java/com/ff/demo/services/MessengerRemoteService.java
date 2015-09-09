package com.ff.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.widget.Toast;

import com.ff.demo.activity.IsServiceActivityInOneThread;
import com.ff.demo.model.MyObject;

public class MessengerRemoteService extends Service{
    public MessengerRemoteService() {
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case IsServiceActivityInOneThread.CONNECTED:
                    Messenger messenger = msg.replyTo;
                    Message message = Message.obtain();
                    message.what = IsServiceActivityInOneThread.CONNECTED;
                    message.obj = new MyObject(getProcessInfo());
                    try {
                        messenger.send(message);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    Messenger messenger = new Messenger(handler);

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    public String getProcessInfo(){
        String result= "pid:"+android.os.Process.myPid()+"uid:"+android.os.Process.myUid()+"tid:"+android.os.Process.myTid();
        return result;
    }
}