package com.gojava6;

import java.util.Arrays;

public class OneSwipeArray {
    public boolean solution(int[] trueArray) {

        if (trueArray == null) {
            throw new IllegalArgumentException();
        }
        if (trueArray.length < 2) {
            throw new IllegalArgumentException();
        }

        int[] arrayToCheck = Arrays.copyOf(trueArray, trueArray.length);
        int[] sortedArray = Arrays.copyOf(trueArray, trueArray.length);
        Arrays.sort(sortedArray);

        for (int i = 0; i < arrayToCheck.length; i++) {
            int num = arrayToCheck[i];
            for (int k = 0; k < arrayToCheck.length; k++) {
                arrayToCheck[i] = arrayToCheck [k];
                arrayToCheck[k] = num;

                if (Arrays.equals(sortedArray, arrayToCheck)) {
                    return true;
                }
                else {
                    arrayToCheck[k] = arrayToCheck[i];
                    arrayToCheck[i] = num;
                }
            }
        }
        return false;
    }
}