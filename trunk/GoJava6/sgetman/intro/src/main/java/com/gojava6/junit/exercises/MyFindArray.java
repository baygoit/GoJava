/*
 * Copyright (c) 2015 WorldTicket A/S
 * All rights reserved.
 */
package com.gojava6.junit.exercises;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 11/6/15
 */
public class MyFindArray implements FindArray {
    public int findArray(int[] array, int[] subArray) {
        int index = -1;
        if (array == null || subArray == null) {
            throw new IllegalArgumentException();
        }
        search:
            for (int i = 0; i < array.length; i++) {
                if (array[i] == subArray[0]) {
                    for (int j = 1; j < subArray.length; j++) {
                        if (i + j >= array.length
                                || array[i + j] != subArray[j]) {
                            break search;
                        }
                    }
                    index = i;
                }
            }
        return index;
    }

    public static void main(String[] args) {

        FindArray findArray = new MyFindArray();
        int result = findArray.findArray(new int[] {4, 9, 3, 7, 8}, new int[] {3, 7});
        copmareAndPrintResult(2, result);

        result = findArray.findArray(new int[] {1, 3, 5}, new int[] {1});
        copmareAndPrintResult(0, result);

        result = findArray.findArray(new int[] {7, 8, 9}, new int[] {8, 9, 10});
        copmareAndPrintResult(-1, result);

        result = findArray.findArray(new int[] {4,9,3,7,8,3,7,1}, new int[] {3,7});
        copmareAndPrintResult(5, result);

        findArray.findArray(null, null);
    }

    private static void copmareAndPrintResult(int expected, int actual) {
        System.out.println((expected == actual) + " " + expected + " " + actual);
    }
}
