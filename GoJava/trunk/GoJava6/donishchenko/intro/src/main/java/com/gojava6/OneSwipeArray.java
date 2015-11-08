package com.gojava6;

public class OneSwipeArray {
    public boolean solution(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (array.length < 2) {
            throw new IllegalArgumentException();
        }

        boolean alreadySorted = true;
        for (int i = 0, j = 1; j < array.length && alreadySorted; i++, j++) {
            if (array[i] > array[j]) {
                alreadySorted = false;
                findSecondValue(array, i);
            }
        }

        return alreadySorted || isSorted(array);
    }

    private void findSecondValue(int[] array, int from) {
        for (int i = from, j = i + 1; j < array.length; j++) {
            if (array[i] < array[j]) {
                swap(array, i, j - 1);
                return;
            }
        }

        /* Try to swap with the last element. it's last chance */
        swap(array, from, array.length - 1);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isSorted(int[] array) {
        for (int i = 0, j = 1; j < array.length; i++, j++) {
            if (array[i] > array[j]) {
                return false;
            }
        }
        return true;
    }
}
