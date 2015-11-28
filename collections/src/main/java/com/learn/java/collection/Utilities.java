package com.learn.java.collection;

import java.util.Collection;

/**
 * This class contains some function which will be used across the project
 * <p/>
 * Created by grijesh
 */
public class Utilities {

    @SuppressWarnings("unchecked")
    public static void print(Collection collection, String description) {
        System.out.println(new StringBuilder("#########").append(description).append("###########"));
        //noinspection unchecked
        if (collection != null)
            collection.stream().forEach(System.out::println);
    }

}
