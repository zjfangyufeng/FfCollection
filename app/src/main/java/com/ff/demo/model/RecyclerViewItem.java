package com.ff.demo.model;

/**
 * Created by wb-fangyufeng on 2015/8/27.
 */
public class RecyclerViewItem {
    String title;
    Class cls;

    public RecyclerViewItem(String title , Class cls) {
        this.cls = cls;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class getCls() {
        return cls;
    }

    public void setCls(Class cls) {
        this.cls = cls;
    }
}
