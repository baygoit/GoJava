package com.gojava6.homework;

import java.util.Random;

/**
 * Created by sergiigetman on 9/22/15.
 */
public class OneSwipeArray {

    public int[] createRandomArray() {
        Random random = new Random();
        int size = random.nextInt(8) + 2;
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    public boolean solution(int[] trueArray) throws IllegalArgumentException {

        boolean result = false;
        int count = 0;

        if (trueArray != null) {
            if (trueArray.length == 1 | trueArray.length == 0) {
                throw new IllegalArgumentException("Well, in any case its better than Error Exception.");
            }

            for (int i = 0; i < trueArray.length; i++) {
                for (int j = trueArray.length - 1; j > i; j--) {
                    if (trueArray[i] > trueArray[j]) {
                        int temp = trueArray[i];
                        trueArray[i] = trueArray[j];
                        trueArray[j] = temp;
                        count++;
                    }
                }
            }

            if (count == 0 || count == 1) {
                result = true;
            }
        } else {
            throw new IllegalArgumentException("Well, in any case its better than Error Exception.");
        }
        return result;
    }

    public void print(int[] array) {

        System.out.println("Created array is:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        OneSwipeArray oneSwipeArray = new OneSwipeArray();

        int[] array = oneSwipeArray.createRandomArray();

        oneSwipeArray.print(array);

        boolean result = oneSwipeArray.solution(array);

        System.out.println("Result after sorting: " + result);

        int[] arrayZero = new int[1];
        try {
            System.out.println(oneSwipeArray.solution(arrayZero));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(oneSwipeArray.solution(null));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
