package com.learn.java.dsa;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PairFinder {

    public static void main(String[] args) {
        System.out.println(getPairs(List.of(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }

    public static int getPairs(List<Integer> values) {
        return values
                .stream()
                // Find frequency of every element
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .values()
                .stream()
                // Divide by 2 , it will ignore decimal
                .map(val -> val / 2).reduce(Integer::sum).orElse(0);
    }

}
