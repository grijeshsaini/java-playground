package com.learn.java.time;

/**
 * Created by grijesh
 */
public enum DateFormats {

    FORMAT1("MM dd, yyyy - HH:mm");

    public final String format;

    DateFormats(String format) {
        this.format = format;
    }
}
