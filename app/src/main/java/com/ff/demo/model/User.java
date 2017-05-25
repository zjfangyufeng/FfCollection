package com.ff.demo.model;

import java.io.Serializable;

/**
 * Created by fangyufeng on 2016/6/14.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1;

    int age;
    String name;
    boolean isMale;

    public User(int age, String name, boolean isMale) {
        this.age = age;
        this.name = name;
        this.isMale = isMale;
    }

    @Override
    public String toString() {
        return age+" "+name+" "+ isMale;
    }
}
