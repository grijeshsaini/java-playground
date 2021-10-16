package com.learn.java.dsa;

import java.util.HashMap;
import java.util.Map;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }

    public static long repeatedString(String s, long n) {

        Map<Integer, Integer> frequencyByIndexMap = new HashMap<>();

        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                frequencyByIndexMap.put(i+1, ++count);
            } else {
                frequencyByIndexMap.put(i+1, count);
            }
        }

        long sumOfACharacter = ((n / chars.length) * frequencyByIndexMap.get(chars.length));
        int remainder = (int) (n % chars.length);
        return sumOfACharacter + (remainder == 0 ? 0 : frequencyByIndexMap.get(remainder));
    }


}
