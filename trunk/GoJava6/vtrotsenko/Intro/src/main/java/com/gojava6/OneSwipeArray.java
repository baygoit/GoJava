package com.gojava6;

/**
 * Created by root on 24.09.15.
 */
public class OneSwipeArray {

    public boolean solution(int[] array) {

        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (array.length < 2) {
            throw new IllegalArgumentException();
        }

        if (getPosition(array) == -1) {
            return false;
        }

        swipeArray(array, getPosition(array));
        if (getPosition(array) == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void swipeArray(int[] array, int pos) {
        int p = array.length - 1;
        for(int i = array.length - 1; i > pos; i--) {
            if(array[pos] > array[i]) {
                p = i;
                break;
            }
        }
        int temp = array[pos];
        array[pos] = array[p];
        array[p] = temp;
    }

    public int getPosition(int[] array) {
        for(int i = 0; i < array.length; i++)
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j])
                    return i;
            }
        return -1;
    }

}

