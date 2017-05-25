package com.ff.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ff.demo.R;
import com.ff.demo.services.SocketService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketDemoActivity extends AppCompatActivity implements View.OnClickListener {

    Button connect_to_server_btn,send_to_server_btn;
    private PrintWriter printWriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soket_demo);
        startService(new Intent(this, SocketService.class));
        connect_to_server_btn = (Button) findViewById(R.id.connect_to_server_btn);
        send_to_server_btn = (Button) findViewById(R.id.send_to_server_btn);
        connect_to_server_btn.setOnClickListener(this);
        send_to_server_btn.setOnClickListener(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket==null){
                    try {
                        socket = new Socket("localhost", 8688);
                        printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        while (!SocketDemoActivity.this.isFinishing()){
                            String s = bufferedReader.readLine();
                            if(s!=null){
                                Log.i("aa",android.os.Process.myPid() + "");
                                Log.i("aa","client accept: " + s);
                            }else {
                                Log.i("aa","client accept: null");
                            }
                        }
                        socket.close();
                    } catch (IOException e) {
                        Log.i("aa","connect failed retry" );
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                    Log.i("aa","client finish: " );
                }
            }
        }).start();
    }

    Socket socket;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.connect_to_server_btn:

                break;
            case R.id.send_to_server_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        printWriter.println("hello server!");
                    }
                }).start();
                break;
        }
    }
}
