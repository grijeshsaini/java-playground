package com.learn.java.hashmap;

import java.util.HashMap;
import java.util.Map;

import static com.learn.java.Utilities.print;

/**
 * This class contain basic operation on HashMap
 * <p>
 * HashMap doesn't guarantee of the order.
 * <p>
 * Now in Java-8 hashmap is using Node<K,V> class instead of Entry class.
 * Node class is child of Entry and have same attribute as Entry
 * <p>
 * HashMap
 * - DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
 * - MAXIMUM_CAPACITY = 1 << 30; // 2^30
 * -DEFAULT_LOAD_FACTOR = 0.75f;
 * Improvement in Java-8
 * Buckets containing a large number of colliding keys will store their entries in a balanced tree
 * instead of a linked list after certain threshold(8) is reached.
 * <p>
 * Previously when collision happened the element used to be store inside LinkedList
 * So the effect of that in worst case the complexity of get() becomes O(n)
 * <p>
 * To improve the performance , in java8 after certain limit or threshold
 * element used to be placed inside Balanced Tree so in worst case also complexity will be O(logn)
 * which is better than O(n)
 * <p>
 * Created by grijesh.
 */
public class BasicOperation {

    public static void main(String... args) {

        Map<String, Integer> map = new HashMap<>();
        addOperation(map);
        getOperation(map);
        removeOperation(map);
        extraOperations(map);

    }

    private static void addOperation(Map<String, Integer> map) {
        String first = "FIRST";
        String second = "SECOND";
        String third = "THIRD";
        print(null, "HashCode");
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        System.out.println(third.hashCode());

        map.put(first, 1);
        map.put(second, 2);
        map.put(third, 3);
    }

    private static void getOperation(Map<String, Integer> map) {
        map.get("THIRD"); //3
        print(null, "Key & Value pair");
        //HashMap support BiConsumer to print the key and value pair
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    private static void removeOperation(Map<String, Integer> map) {
        map.remove("THIRD");
        print(null, "After remove 3");
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    private static void extraOperations(Map<String, Integer> map) {
        print(null, "extra operation(Default)");
        //Returns the value to which the specified key is mapped, or
        // defaultValue if this map contains no mapping for the key.
        System.out.println(map.getOrDefault("FOURTH", 4));

        /**
         * From java-docs
         *  * If the specified key is not already associated with a value (or is mapped
         * to {@code null}), attempts to compute its value using the given mapping
         * function and enters it into this map unless {@code null}.
         *
         * <p>If the function returns {@code null} no mapping is recorded. If
         * the function itself throws an (unchecked) exception, the
         * exception is rethrown, and no mapping is recorded.  The most
         * common usage is to construct a new object serving as an initial
         * mapped value or memoized result, as in:
         *
         * <pre> {@code
         * map.computeIfAbsent(key, k -> new Value(f(k)));
         * }</pre>
         *
         * <p>Or to implement a multi-value map, {@code Map<K,Collection<V>>},
         * supporting multiple values per key:
         *
         * <pre> {@code
         * map.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
         * }</pre>
         *
         */
        map.computeIfAbsent("FOURTH", value -> 4);

        print(null, "After adding 4");
        map.forEach((key, value) -> System.out.println(key + ":" + value));


        /**
         * From Java-Docs
         * If the value for the specified key is present and non-null, attempts to
         * compute a new mapping given the key and its current mapped value.
         *
         * <p>If the function returns {@code null}, the mapping is removed.  If the
         * function itself throws an (unchecked) exception, the exception is
         * rethrown, and the current mapping is left unchanged.
         */
        map.computeIfPresent("FOURTH", (K, V) -> 5);

        print(null, "After modifying 4");
        map.forEach((key, value) -> System.out.println(key + ":" + value));

    }

}
