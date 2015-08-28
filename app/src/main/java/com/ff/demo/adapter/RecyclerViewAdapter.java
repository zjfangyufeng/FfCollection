package com.ff.demo.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ff.demo.R;
import com.ff.demo.model.RecyclerViewItem;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> implements View.OnClickListener{

    List<RecyclerViewItem> list;

    public RecyclerViewAdapter(List<RecyclerViewItem> list) {
        this.list = list;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  v = View.inflate(parent.getContext(),R.layout.recyclerview_item,null);
        v.setOnClickListener(RecyclerViewAdapter.this);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RecyclerViewItem recyclerViewItem = list.get(position);
        holder.getRoot().setTag(R.id.TAG_NOE,holder);
        holder.setRecyclerViewItem(recyclerViewItem);
        holder.getTv().setText(recyclerViewItem.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) v.getTag(R.id.TAG_NOE);
        v.getContext().startActivity(new Intent(v.getContext(),recyclerViewHolder.getRecyclerViewItem().getCls()));
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        RecyclerViewItem recyclerViewItem;
        View root;
        TextView tv;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            tv = (TextView) itemView.findViewById(R.id.tv);
        }

        public TextView getTv() {
            return tv;
        }

        public RecyclerViewItem getRecyclerViewItem() {
            return recyclerViewItem;
        }

        public void setRecyclerViewItem(RecyclerViewItem recyclerViewItem) {
            this.recyclerViewItem = recyclerViewItem;
        }

        public View getRoot() {
            return root;
        }

        public void setRoot(View root) {
            this.root = root;
        }
    }
}
