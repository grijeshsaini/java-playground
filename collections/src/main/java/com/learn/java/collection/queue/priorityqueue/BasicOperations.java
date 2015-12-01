package com.learn.java.collection.queue.priorityqueue;

import com.learn.java.collection.Utilities;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Default capacity is 11
 * From Java-Docs
 * Priority queue represented as a balanced binary heap: the two
 * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
 * priority queue is ordered by comparator, or by the elements'
 * natural ordering, if comparator is null: For each node n in the
 * heap and each descendant d of n, n <= d.  The element with the
 * lowest value is in queue[0], assuming the queue is nonempty.
 * Created by grijesh.
 */
public class BasicOperations {

    public static void main(String... args) {
        Queue<String> queue = new PriorityQueue<>();
        addOperation(queue);
        getOperation(queue);
        removeOperation(queue);
    }


    /**
     * Java-Docs
     * /**
     * Inserts the specified element into this priority queue.
     *
     * If comparator are not provided then it will use natural ordering
     */
    private static void addOperation(Queue<String> queue) {
        queue.add("b");
        queue.add("a");
        queue.add("d");
        queue.add("c");
    }

    private static void getOperation(Queue<String> queue) {
        //Head Element
        System.out.println(queue.peek());
        Utilities.print(queue,"Get Operation");
    }

    private static void removeOperation(Queue<String> queue) {
        //Remove
        queue.poll();
        Utilities.print(queue,"After remove Operation");
    }



}
