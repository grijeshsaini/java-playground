package com.learn.java.collection.loop;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by grijesh on 5/4/16.
 */
@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "UnusedDeclaration"})
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkingForVsForEach {

    @State(Scope.Benchmark)
    public static class DummyDataHolder {

        public static List<Integer> dummyArrayList() {
            List<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < 1000000; i++) {
                arrayList.add(i);
            }
            return arrayList;
        }
    }

    @Benchmark
    public void forLoop() {
        List<Integer> arrayList = DummyDataHolder.dummyArrayList();
        int numberOfIteration = arrayList.size();
        for (int i = 0; i < numberOfIteration; i++) {
            arrayList.get(i);
        }
    }

    @Benchmark
    public void forEachLoop() {
        List<Integer> arrayList = DummyDataHolder.dummyArrayList();
        arrayList.forEach(arrayList::get);
    }


    public static void main(String... args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(BenchmarkingForVsForEach.class.getSimpleName())
                .threads(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .jvmArgs("-server")
                .build();
        new Runner(options).run();
    }
}
