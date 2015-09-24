package com.gojava6;

import java.util.Arrays;

/**
 * Created by user on 24.09.2015.
 */
public class OneSwipeArray {
    public boolean solution (int[] array){
        //validation
        if (array==null||array.length==1){
            throw new IllegalArgumentException();
        }
        int[] sortedArray = Arrays.copyOf(array,array.length);
        Arrays.sort(sortedArray);
        //counting not sorted elements
        int count=0;
        for (int i=0; i<array.length; i++) {
            if (array[i]!=sortedArray[i]) {
                count++;
            }
        }
        if (count>2) {
            return false;
        } else {
            return true;
        }
    }
}
