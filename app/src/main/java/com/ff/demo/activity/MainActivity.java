package com.ff.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.ff.demo.R;
import com.ff.demo.adapter.RecyclerViewDivider;
import com.ff.demo.adapter.RecyclerViewAdapter;
import com.ff.demo.model.RecyclerViewItem;
import com.ff.demo.utils.MyDisplayMetrics;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn;
    RecyclerView recyclerView;
    List<RecyclerViewItem> list;
    RecyclerViewAdapter recyclerViewAdapter;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,LinearLayoutManager.HORIZONTAL);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        MyDisplayMetrics.init(this);
        recyclerViewAdapter = new RecyclerViewAdapter(list);
        recyclerView.addItemDecoration(new RecyclerViewDivider(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }


    private void initData() {
        list = new ArrayList();
        list.add(new RecyclerViewItem("alarm",Alarm.class));
        list.add(new RecyclerViewItem("TouchEvent事件分发机制",TouchEventDispatchMainActivity.class));
        list.add(new RecyclerViewItem("TouchDelegate",TouchDelegateActivity.class));
        list.add(new RecyclerViewItem("IsServiceActivityInOneThread",IsServiceActivityInOneThread.class));
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                switchLayoutManager();
                break;
        }
    }

    private void switchLayoutManager() {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }else if(layoutManager instanceof LinearLayoutManager){
            recyclerView.setLayoutManager(gridLayoutManager);
        }else{
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
