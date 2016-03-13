package com.Homework3;

import static java.lang.Math.abs;

/**
 * Created by roman on 03.03.16.
 */
public class Modificator {
    public static int getMinEl(int min, int size, int[] sourceNumbers) {
        for (int i = 0; i < size; i++) {
            if (min > sourceNumbers[i]) {
                min = sourceNumbers[i];

            }
        }
        return min;
    }

    public static int getNumberOfFirstMinEl(int minEl, int numberOfMinEl, int numberOfInputEl, int[] sourceNumbers) {
        for (int i = 0; i < numberOfInputEl; i++) {
            if (minEl == sourceNumbers[i]) {
                numberOfMinEl++;
            }
        }
        return numberOfMinEl;
    }
    public static void changeMinToMaxEl(int indexFirstMinEl, int numberOfInputEl, int[] sourceNumbers) {
        int maxEl = sourceNumbers[0];// change minEl element on maxEl
        for (int i = 0; i < numberOfInputEl; i++) {
            if (maxEl < sourceNumbers[i]) {
                maxEl = sourceNumbers[i];
            }
        }
        sourceNumbers[indexFirstMinEl] = maxEl;
    }

    public static void outputLength(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int a = 0;
            a = abs(array[i] - array[i - 1]) - 1;
            System.out.println("lenght whis min element= " + a);
        }
    }

    public static int[] getArrayOfIndexMinEl(int minEl, int numberOfMinEl, int numberOfInputEl, int[] sourceNumbers) {
        int count1 = 0;
        int array[] = new int[numberOfMinEl];
        for (int i = 0; i < numberOfInputEl; i++) {
            if (minEl >= sourceNumbers[i]) {
                array[count1] = i;
                count1++;
            }
        }
        return array;
    }

    public static int getIndexFirstMinEl(int min, int indexFirstMinEl, int numberOfInputEl, int[] sourceNumbers) {
        for (int i = 0; i < numberOfInputEl; i++) {
            if (min == sourceNumbers[i]) {
                indexFirstMinEl = i;
            }
        }
        return indexFirstMinEl;
    }
}
