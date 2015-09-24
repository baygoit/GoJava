package com.gojava6;

public class OneSwipeArray {
//    public static void main(String[] args) {
//        int[] trueArray = {1, 3, 5, 3,2};
//        System.out.println(solution(trueArray));
//
//    }


    public boolean solution(int[] trueArray) {
        boolean result = false;
        int[] a = trueArray;
        int counter = 0;

        if (a == null) {
            System.out.println("null");
            throw new IllegalArgumentException();
        }
        if (a.length < 2) {
            System.out.println("array < 2");
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    counter++;
                    result = true;
                }
            }
        }

        if (counter > 2) {
            result = false;
        }

        return result;
    }
}