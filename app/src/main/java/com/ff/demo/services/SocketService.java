package com.ff.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketService extends Service {
    public SocketService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(8688);
                    while (true){
                        Socket accept = serverSocket.accept();
                        handleSocket(accept);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void handleSocket(final Socket accept) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                    PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(accept.getOutputStream())),true);
                    while (true){
                        String s;
                        if((s = bufferedReader.readLine())!=null){
                            Log.i("aa","server accept: " + s);
                            printWriter.println( android.os.Process.myPid() + " server accept: " + s);
                        }else {
                            Log.i("aa","server accept: null");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("aa","server finish: " );
            }
        }).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
