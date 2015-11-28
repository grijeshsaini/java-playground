package com.learn.java.collection.set.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.learn.java.collection.Utilities.print;

/**
 * This class contains the basic operation on HashSet
 * Set doesn't contains any duplicate (can be violated with improper use of HashCode and Equals)
 * <p/>
 * default initial capacity (16) and load factor (0.75).
 * No guarantee of Order
 * <p/>
 * Internally set is implemented using HashMap
 * If you add any element in set it will be added as key in HashMap with empty object (new Object())
 * And as we cannot insert null key in hash map, so Set doesn't support NULL values
 * same HashMap doesn't support duplicate keys so set also doesn't support duplicate values
 * <p/>
 * From Java Docs - (HashSet)
 * <p>This class offers constant time performance for the basic operations
 * (<tt>add</tt>, <tt>remove</tt>, <tt>contains</tt> and <tt>size</tt>),
 * assuming the hash function disperses the elements properly among the
 * buckets.  Iterating over this set requires time proportional to the sum of
 * the <tt>HashSet</tt> instance's size (the number of elements) plus the
 * "capacity" of the backing <tt>HashMap</tt> instance (the number of
 * buckets).  Thus, it's very important not to set the initial capacity too
 * high (or the load factor too low) if iteration performance is important.
 * <p/>
 * Created by grijesh
 */
public class BasicOperation {

    public static void main(String... args) {
        Set<String> set = new HashSet<>();
        addOperation(set);
        getOperation(set);
        removeOperation(set);

    }


    /**
     * Add operation
     *
     * @param set - An empty set
     */
    private static void addOperation(Set<String> set) {
        /**
         * Added as key in Hash Map
         * Returns boolean value
         */
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");

        print(set, "Add Operation");
    }

    /**
     * Get operation
     * There is no direct get operation ,
     * we have to get the iterator then we have to traverse it
     * Internally it will give you iterator from map (map.keySet().iterator())
     *
     * @param set - A set with some dummy data
     */
    private static void getOperation(Set<String> set) {
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
    }

    /**
     * Remove Operation
     *
     * @param set - A set with some dummy data
     */
    private static void removeOperation(Set<String> set) {

        //remove will only accept object in set and used hashcode and equals to validate equality
        set.remove("One"); // Removed "One"
        print(set, "Remove Operation");

        set.clear(); //It will clear the set
        print(set, " Clear set");
    }

}
