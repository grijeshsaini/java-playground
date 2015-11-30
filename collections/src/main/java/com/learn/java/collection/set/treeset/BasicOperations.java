package com.learn.java.collection.set.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static com.learn.java.collection.Utilities.print;

/**
 * Tree set is implemented using Tree Map
 * This implementation provides guaranteed log(n)
 * time cost for the basic operations (add, remove and contains).
 *
 * From Java Docs-
 * The elements are ordered using their Comparable natural
 * ordering, or by a {@link java.util.Comparator} provided at set creation
 * time, depending on which constructor is used.
 *
 *
 * You will choose TreeSet when the ordering is important for you
 * Created by grijesh
 */
public class BasicOperations {

    public static void main(String... args) {
        Set<Integer> set = new TreeSet<>();
        addOperation(set);
        getOperation(set);
        removeOperation(set);

    }


    /**
     * Add operation
     *
     * @param set - An empty set
     */
    private static void addOperation(Set<Integer> set) {
        /**
         * Added as key in Tree Map
         * Returns boolean value
         */
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);

        print(set, "Add Operation");
    }

    /**
     * Get operation
     * There is no direct get operation ,
     * we have to get the iterator then we have to traverse it
     * Internally it will give you iterator from map (map.navigableKeySet().iterator())
     *
     * @param set - A set with some dummy data
     */
    private static void getOperation(Set<Integer> set) {
        /**
         * From Java Docs -
         * The iterators returned by this class's iterator method are fail-fast:
         * if the set is modified at any time after the iterator is created,
         * in any way except through the iterator's own remove method, the Iterator
         * throws a ConcurrentModificationException.
         * Thus, in the face of concurrent modification, the iterator fails quickly and cleanly,
         * rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.
         */
        print(null, "Fail-Fast Iterator");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //One more way - It uses iterator only internally
        //set.forEach(System.out::println);
        print(set, "Different way to iterate");

        print(null, "Reverse Order");
        Iterator reverseIterator = ((TreeSet)set).descendingIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }

        print(((TreeSet)set).descendingSet(),"Descending Set");


    }

    /**
     * Remove Operation
     *
     * @param set - A set with some dummy data
     */
    private static void removeOperation(Set<Integer> set) {

        //remove will only accept object in set and used hashcode and equals to validate equality
        set.remove(1); // Removed "One"
        print(set, "Remove Operation");

        set.clear(); //It will clear the set
        print(set, " Clear set");
    }
}
