package com.gojava6;

import java.util.Arrays;

/**
 * Created by sergiigetman on 9/22/15.
 */
public class OneSwipeArray {
    public boolean solution(int[] trueArray) {
        if (trueArray == null) {
            throw  new IllegalArgumentException();
        }

        if ( trueArray.length < 2){
            throw  new IllegalArgumentException();
        }

        int[] sortArray = Arrays.copyOf(trueArray, trueArray.length);
        Arrays.sort(sortArray);

        int count = 0;
        for (int i = 0; i < trueArray.length; i++) {
            if (trueArray[i] != sortArray[i]){
                count += 1;
            }
        }

        if (count == 2) {
            return true;
        }
        return false;
    }
}