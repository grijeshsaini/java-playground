package com.learn.java;

import java.util.Collection;

/**
 * This class contains some function which will be used across the project
 * <p/>
 * Created by grijesh
 */
public class Utilities {

    @SuppressWarnings("unchecked")
    public static void print(Collection collection, String description) {
        System.out.println("#########" + description + "###########");
        if (collection != null)
            collection.forEach(System.out::println);
    }

}
