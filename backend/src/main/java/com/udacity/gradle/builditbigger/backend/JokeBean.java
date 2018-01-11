package com.udacity.gradle.builditbigger.backend;


/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private String mData;

    public String getData() {
        return mData;
    }

    public void setData(String data) {
        this.mData = data;
    }
}