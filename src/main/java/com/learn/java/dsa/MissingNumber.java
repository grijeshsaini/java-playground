package com.learn.java.dsa;

import java.util.Arrays;

public class MissingNumber {
    //Input:
    //N = 10
    //A[] = {6,1,2,8,3,4,7,10,5}
    //Output: 9

    static int missingNumber(int[] array, int n) {
        int sumTotal = n * (n + 1) / 2; // Sum of natural numbers
        int sum = Arrays.stream(array).sum(); // Sum of array
        return sumTotal - sum; // Missing Number
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{6,1,2,8,3,4,7,10,5}, 10));
    }
}
