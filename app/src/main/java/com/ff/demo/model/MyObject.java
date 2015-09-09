package com.ff.demo.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wb-fangyufeng on 2015/9/8.
 */
public class MyObject extends Object implements Parcelable {
    String s;

    public MyObject(String s) {
        this.s = s;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(s);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel source) {
            return new MyObject(source.readString());
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

}
