package com.learn.java.collection.set.benchmarking;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by grijesh.
 */
@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "UnusedDeclaration"})
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkingSetImplementations {

    @State(Scope.Benchmark)
    public static class DummyDataHolder {
        public static Set<Integer> dummyHashSet() {
            Set<Integer> hashset = new HashSet<>();
            for (int i = 1000; i > 1; i--) {
                hashset.add(i);
            }
            return hashset;
        }

        public static Set<Integer> dummyTreeSet() {
            Set<Integer> treeSet = new TreeSet<>();
            for (int i = 1000; i > 1; i--) {
                treeSet.add(i);
            }
            return treeSet;
        }
    }

    @Benchmark
    public void addOperationOnHashSet() {
        Set<Integer> hashset = new HashSet<>();
        for (int i = 1000; i > 1; i--) {
            hashset.add(i);
        }
    }

    @Benchmark
    public void addOperationOnTreeSet() {
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 1000; i > 1; i--) {
            treeSet.add(i);
        }
    }

    /*@Benchmark
    public void getOperationOnHashSet() {
        DummyDataHolder.dummyHashSet().forEach(System.out::println);
    }

    @Benchmark
    public void getOperationOnTreeSet() {
        DummyDataHolder.dummyTreeSet().forEach(System.out::println);
    }*/

    @Benchmark
    public void removeOperationOnHashSet() {
        for (int i = 1000; i > 1; i--) {
            DummyDataHolder.dummyHashSet().remove(i);
        }
    }

    @Benchmark
    public void removeOperationOnTreeSet() {
        for (int i = 1000; i > 1; i--) {
            DummyDataHolder.dummyTreeSet().remove(i);
        }
    }

    public static void main(String... args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchmarkingSetImplementations.class.getSimpleName())
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .jvmArgs("-server")
                .build();
        new Runner(options).run();
    }
}
