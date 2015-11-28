package com.learn.java.collection.list;

import java.util.List;

/**
 * This class contains some function which will be used across the project
 *
 * Created by grijesh
 */
public class Utilities {

    public static void print(List list, String description) {
        System.out.println(new StringBuilder("#########").append(description).append("###########"));
        //noinspection unchecked
        list.stream().forEach(System.out::println);
    }

}
