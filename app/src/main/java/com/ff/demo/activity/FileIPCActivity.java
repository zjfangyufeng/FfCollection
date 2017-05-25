package com.ff.demo.activity;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ff.demo.R;
import com.ff.demo.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIPCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_ipc);
        User ff = new User(25, "ff", true);
        User qq = new User(11, "11", false);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "aa.txt")));
            objectOutputStream.writeObject(qq);
            objectOutputStream.writeObject(ff);
            objectOutputStream.close();
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(Environment.getExternalStorageDirectory(), "aa.txt")));
            User user = (User) objectInputStream.readObject();
            User q = (User) objectInputStream.readObject();
            Log.i("aa",user.toString()+q.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
