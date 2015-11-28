package com.learn.java.collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains basic operation over ArrayList
 *
 * When we initialize array list the default capacity would be 10
 * Created by grijesh
 */
public class BasicOperations {

    public static void main(String... args) {
        List<String> list = new ArrayList<>();
        addOperation(list);
        getOperation(list);
        removeOperation(list);

    }


    /**
     * Add operation
     * @param list - An empty list
     */
    private static void addOperation(List<String> list){
        /**
         * Appends the specified element to the end of this list.
         */
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        print(list, "Add Operation");
        /**
         * Index based addition
         *
         * As per java docs -
         * Inserts the specified element at the specified position in this
         * list. Shifts the element currently at that position (if any) and
         * any subsequent elements to the right (adds one to their indices).
         */
        list.add(2, "Five");
        print(list," Index Based Addition");
    }

    /**
     * Get operation
     * @param list - A list with some dummy data
     */
    private static void getOperation(List<String> list) {
        list.get(0); // One
        list.get(2); // Five
    }

    /**
     * Remove Operation
     * @param list - A list with some dummy data
     */
    private static void removeOperation(List<String> list){

        //remove element from specified index
        list.remove(0); // Removed "One"
        print(list, "Remove Operation");

        /**
         * Returns boolean value and use equals method to check the equality
         * If remove all used on custom object then need to define equals carefully
         */
        list.remove("Five");
        print(list, "Remove(Object) operation");

        list.clear(); //It will clear the list
        print(list," Clear list");
    }

    private static void print(List list, String description) {
        System.out.println(new StringBuilder("#########").append(description).append("###########"));
        //noinspection unchecked
        list.stream().forEach(System.out::println);
    }

}
