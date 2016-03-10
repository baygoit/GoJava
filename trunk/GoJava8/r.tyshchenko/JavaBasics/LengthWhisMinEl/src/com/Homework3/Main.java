package com.Homework3;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        int min;
        int numberOfMinEl = 0;
        int indexFirstMinEl = -1;
        int indexOfSecondMinEl = -1;

        System.out.print("How many integers will you inputed? ");
        Scanner in = new Scanner(System.in);
        int numberOfInputEl = in.nextInt();
        if (numberOfInputEl <= 2) {
            System.out.println("input more elements");

        } else {

            int[] sourceNumbers = new int[numberOfInputEl];
            System.out.print("Input integers through the space, and  push <Enter>: ");
            for (int i = 0; i < numberOfInputEl; i++) {
                sourceNumbers[i] = in.nextInt();
            }
            System.out.println(Arrays.toString(sourceNumbers));

            min = sourceNumbers[0];
            min = Modificator.getMinEl(min, numberOfInputEl, sourceNumbers);

            numberOfMinEl = Modificator.getNumberOfFirstMinEl(min, numberOfMinEl, numberOfInputEl, sourceNumbers);
            indexFirstMinEl = Modificator.getIndexFirstMinEl(min, indexFirstMinEl, numberOfInputEl, sourceNumbers);

            if (numberOfMinEl >= 2) {
                int[] array = Modificator.getArrayOfIndexMinEl(min, numberOfMinEl, numberOfInputEl, sourceNumbers);

                Modificator.outputLength(array);

            } else {
                Modificator.changeMinToMaxEl(indexFirstMinEl, numberOfInputEl, sourceNumbers);

                numberOfMinEl = 0;
                min = sourceNumbers[0];
                min = Modificator.getMinEl(min, numberOfInputEl, sourceNumbers);
                numberOfMinEl = Modificator.getNumberOfFirstMinEl(min, numberOfMinEl, numberOfInputEl, sourceNumbers);
                indexOfSecondMinEl = Modificator.getIndexFirstMinEl(min, indexFirstMinEl, numberOfInputEl, sourceNumbers);

                if (numberOfMinEl == 1) {
                    System.out.println("length whis min element = " + (abs(indexFirstMinEl - indexOfSecondMinEl) - 1));

                } else {
                    int array1[] = new int[numberOfMinEl + 1];
                    array1[0] = indexFirstMinEl;
                    int count1 = 1;

                    for (int i = 0; i < numberOfInputEl; i++) {
                        if (min == sourceNumbers[i]) {
                            array1[count1] = i;
                            count1++;
                        }
                    }
                    Modificator.outputLength(array1);
                }

            }
        }
    }




}
