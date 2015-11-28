package com.learn.java.collection.list.benchmarking;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class contains the benchmarking of List operations on Array list and Linked List
 * Here , I have used JMH to do benchmarking
 * To run this class first run clean and build task, Then tun this class directly
 *
 * Created by grijesh
 */
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkListImplementations {

    @State(Scope.Benchmark)
    public static class DummyDataHolder {
        public static List<Integer> dummyArrayList() {
            List<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
            return arrayList;
        }

        public static List<Integer> dummyLinkedList() {
            List<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < 1000; i++) {
                linkedList.add(i);
            }
            return linkedList;
        }
    }

    @Benchmark
    public void addOperationOnArrayList() {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
        }
    }

    @Benchmark
    public void addOperationOnLinkedList() {
        List<Integer> linkedList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            linkedList.add(i);
        }
    }

    @Benchmark
    public void getOperationOnArrayList() {
        for (int i = 0; i < 1000; i++) {
            DummyDataHolder.dummyArrayList().get(i);
        }
    }

    @Benchmark
    public void getOperationOnLinkedList() {
        for (int i = 0; i < 1000; i++) {
            DummyDataHolder.dummyLinkedList().get(i);
        }
    }

    @Benchmark
    public void removeOperationOnArrayList() {
        for (int i = 0; i < 1000; i++) {
            DummyDataHolder.dummyArrayList().remove(i);
        }
    }

    @Benchmark
    public void removeOperationOnLinkedList() {
        for (int i = 0; i < 1000; i++) {
            DummyDataHolder.dummyLinkedList().remove(i);
        }
    }

    public static void main(String... args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchmarkListImplementations.class.getSimpleName())
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .jvmArgs("-server")
                .build();
        new Runner(options).run();
    }
}
