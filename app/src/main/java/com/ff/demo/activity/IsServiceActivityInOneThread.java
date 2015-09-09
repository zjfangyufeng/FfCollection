package com.ff.demo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ff.demo.IRemoteServiceAidlInterface;
import com.ff.demo.R;
import com.ff.demo.services.LocalService;
import com.ff.demo.services.AIDLRemoteService;
import com.ff.demo.services.MessengerRemoteService;

public class IsServiceActivityInOneThread extends ActionBarActivity implements View.OnClickListener{

    TextView main_info,local_info,remote_info,messenger_remote_info;
    Button local_btn,remote_btn,btn_remoteService_messenger;
    LocalService localService;
    IRemoteServiceAidlInterface iRemoteServiceAidlInterface;
    Messenger sMessenger;
    Messenger cMessenger = new Messenger(new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            messenger_remote_info.setText(msg.obj+"--");
        }
    });


    public static final int CONNECTED = 110;

    ServiceConnection localServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LocalService.MyBinder myBinder = (LocalService.MyBinder) service;
            localService = myBinder.getIntance();
            local_info.setText(localService.getProcessInfo());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            localService = null;
        }
    };

    ServiceConnection remoteServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iRemoteServiceAidlInterface = IRemoteServiceAidlInterface.Stub.asInterface(service);
            try {
                remote_info.setText(iRemoteServiceAidlInterface.getProcessInfo());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iRemoteServiceAidlInterface =null;
        }
    };

    ServiceConnection messengerRemoteServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            sMessenger = new Messenger(service);
            try {
                Message message= Message.obtain();
                message.what = CONNECTED;
                message.replyTo = cMessenger;
                sMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            sMessenger = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_service_activity_in_one_thread);
        main_info = (TextView) findViewById(R.id.main_info);
        local_info = (TextView) findViewById(R.id.lacal_info);
        remote_info = (TextView) findViewById(R.id.remote_info);
        messenger_remote_info = (TextView) findViewById(R.id.messenger_remote_info);
        local_btn = (Button) findViewById(R.id.btn_localService);
        remote_btn = (Button) findViewById(R.id.btn_remoteService);
        btn_remoteService_messenger = (Button) findViewById(R.id.btn_remoteService_messenger);
        local_btn.setOnClickListener(this);
        remote_btn.setOnClickListener(this);
        btn_remoteService_messenger.setOnClickListener(this);
        String result= "pid:"+android.os.Process.myPid()+"uid:"+android.os.Process.myUid()+"tid:"+android.os.Process.myTid();
        main_info.setText("mainThreadInfo:"+result);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_localService:
                bindService(new Intent(this, LocalService.class), localServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_remoteService:
                bindService(new Intent(this, AIDLRemoteService.class), remoteServiceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_remoteService_messenger:
                bindService(new Intent(this, MessengerRemoteService.class), messengerRemoteServiceConnection,BIND_AUTO_CREATE);
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(localServiceConnection);
        unbindService(remoteServiceConnection);
        unbindService(messengerRemoteServiceConnection);
    }
}
