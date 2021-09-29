package com.learn.java.queue.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * In below class we are trying to solve the producer/consumer problem using blocking queue concept
 *
 * BlockingQueue is an interface and it have multiple implementation
 * We are going to use ArrayBlockingQueue
 *
 * Created by grijesh.
 */
public class ProducerConsumerProblem {

    public static void main(String ...args){
        BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);
        new Thread(new Producer(sharedQueue)).start();
        new Thread(new Consumer(sharedQueue)).start();
    }


    static class Producer implements Runnable{

        private final BlockingQueue<Integer> blockingQueue;

        public Producer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            int i=0;
            while(true){
                try {
                    System.out.println("PUT: "+ i);
                    // same as add but put is a blocking method
                    blockingQueue.put(i);
                    i++;
                    //Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private final BlockingQueue<Integer> blockingQueue;

        public Consumer(BlockingQueue<Integer> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(1000L);
                    //same as poll() but take is a blocking operation
                    System.out.println("GET: "+blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
