package com.ff.demo;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ff.demo.adapter.RecyclerDivider;
import com.ff.demo.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btn;
    RecyclerView recyclerView;
    List<String> list;
    RecyclerViewAdapter recyclerViewAdapter;
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
    StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4,LinearLayoutManager.VERTICAL);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        recyclerViewAdapter = new RecyclerViewAdapter(list);
        recyclerView.addItemDecoration(new RecyclerDivider(this,LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initData() {
        list = new ArrayList();
        for(int i=0;i<1000;i++)
            list.add("ff"+i);
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
        if(layoutManager instanceof LinearLayoutManager){
            recyclerView.setLayoutManager(gridLayoutManager);
        }else if(layoutManager instanceof GridLayoutManager){
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }else{
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }
}
