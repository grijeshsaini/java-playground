package com.learn.java.dsa;

public class ValleyCounter {

    public static void main(String[] args) {
        System.out.println(countValleys("UDDDUDUU"));
    }

    public static int countValleys(String path) {

        int valleys = 0;
        int seaLevelCounter = 0;
        boolean valleyStarted = false;
        for (char c : path.toCharArray()) {

            if (c == 'U') {
                seaLevelCounter++;
            } else {
                seaLevelCounter--;
            }

            if (seaLevelCounter == -1) {
                valleyStarted = true;
            }

            if (valleyStarted && seaLevelCounter == 0) {
                valleys++;
                valleyStarted = false;
            }

        }

        return valleys;
    }

}
