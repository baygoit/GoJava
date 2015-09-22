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
        int swapIndex = trueArray.length - 1;
        for (int i = trueArray.length - 1; i > bugIndex; i--) {
            if (trueArray[bugIndex] > trueArray[i]) {
                swapIndex = i;
                break;
            }
        }
        int temp = trueArray[bugIndex];
        trueArray[bugIndex] = trueArray[swapIndex];
        trueArray[swapIndex] = temp;
    }

    private int getBugIndex(int[] trueArray) {
        for (int i = 0; i < trueArray.length - 1; i++) {
            if (trueArray[i] > trueArray[i + 1])
                return i;
        }
        return -1;
    }
}
