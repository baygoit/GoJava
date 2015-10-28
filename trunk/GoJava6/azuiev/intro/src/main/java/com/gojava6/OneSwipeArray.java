package com.gojava6;

/**
 * Created by sergiigetman on 9/22/15.
 */
public class OneSwipeArray {
    public boolean solution(int[] trueArray) {
        if (trueArray == null) {
            throw new IllegalArgumentException();
        }
        if (trueArray.length < 2) {
            throw new IllegalArgumentException();
        }

        int bugIndex = getBugIndex(trueArray);
        if (bugIndex == -1) {
            return false;
        }

        swap(trueArray, bugIndex);
        if (getBugIndex(trueArray) == -1) {
            return true;
        } else {
            return false;
        }

    }

    private void swap(int[] trueArray, int bugIndex) {
        int swapIndex = trueArray.length-1;
        for (int i = 1; i < trueArray.length; i++) {
            if (trueArray[bugIndex] < trueArray[i]) {
                swapIndex = i-1;
                break;
            }
        }
        int temp = trueArray[bugIndex];
        trueArray[bugIndex] = trueArray[swapIndex];
        trueArray[swapIndex] = temp;
    }

    private int getBugIndex(int[] trueArray) {
        for (int i = 0; i < trueArray.length - 1; i++) {
            if (trueArray[i] > trueArray[i + 1]) {
                while (i > 0 && trueArray[i - 1] == trueArray[i])
                    i--;
                return i;
            }
        }
        return -1;
    }
}
