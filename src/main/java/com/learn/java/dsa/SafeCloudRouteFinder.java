package com.learn.java.dsa;

import java.util.List;

public class SafeCloudRouteFinder {

    public static void main(String[] args) {
        System.out.println(numberOfJumpsForSafeRoute(List.of(0, 0, 0, 1, 0, 0)));
    }

    public static int numberOfJumpsForSafeRoute(List<Integer> clouds) {
        int jump = 0;
        for (int i = 0; i < clouds.size() - 1; ) {

            if ((i + 2) > clouds.size() - 1) {
                i++;
            } else if (clouds.get(i + 1) == 0 && clouds.get(i + 2) != 0) {
                i++;
            } else if (clouds.get(i + 1) == 0 && clouds.get(i + 2) == 0) {
                i = i + 2;
            } else if (clouds.get(i + 1) != 0) {
                i = i + 2;
            }

            jump++;
        }

        return jump;

    }
}
