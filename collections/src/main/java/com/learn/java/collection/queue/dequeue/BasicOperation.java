package com.learn.java.collection.queue.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * It represents a queue where you can insert and remove elements from both ends of the queue.
 * Thus, "Deque" is short for "Double Ended Queue" and is pronounced "deck", like a deck of cards.
 *
 * This can be used as a stack or queue
 *
 * Created by grijesh.
 */
public class BasicOperation {

    public static void main(String ...args){
        /**
         * Constructs an empty array deque with an initial capacity
         * sufficient to hold 16 elements.
         */
        Deque<String> deque = new ArrayDeque<>();
        addOperation(deque);
        getOperation(deque);
        removeOperation(deque);
    }

    private static void addOperation(Deque<String> deque) {
        /**
         * By default it will add the element to the last
         * add is equivalent to addLast
         */
        deque.add("Saini");
        /**
         * Adding the element on the front
         */
        deque.addFirst("Grijesh");
    }

    private static void getOperation(Deque<String> deque) {
        //If result is null no such element exception will be thrown
        deque.getFirst(); //Grijesh

        deque.getLast(); //Saini
        //Retrieves and removes the head of the queue represented by this deque
        //It will not throw exception if deque is empty
        deque.poll(); //Grijesh

        //Retrieves, but does not remove, the head of the queue represented by this deque
        deque.peek();
        //Will give the iterator
        deque.iterator();
    }

    private static void removeOperation(Deque<String> deque) {
        /**
         * Retrieves and removes the head of the queue represented by this deque.
         *
         * This method differs from poll only in that it throws an
         * exception if this deque is empty.
         *
         */
        deque.remove();

    }

}
