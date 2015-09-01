package com.ff.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ff.demo.R;
import com.ff.demo.adapter.RecyclerViewAdapter;
import com.ff.demo.model.RecyclerViewItem;

import java.util.ArrayList;
import java.util.List;

public class TouchEventDispatchMainActivity extends Activity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_dispatch_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(recyclerViewAdapter);

        list.add(new RecyclerViewItem("view", TouchEventDispatchViewDemo.class));
        list.add(new RecyclerViewItem("button", TouchEventDispatchButtonDemo.class));
    }


}
