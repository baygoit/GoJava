package com.tyomsky;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by artem.degtyarev on 23.06.2015.
 */
public class MergeSort {

    public static void main(String a[]){

        int [] inputArray = getArrayOfIntegersFromConsole();

        sort(inputArray);

        for(int i : inputArray){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static void sort(int[] array) {
        doMergeSort(array, 0, array.length - 1);
    }

    public static void doMergeSort(int[] array, int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            doMergeSort(array, lowerIndex, middle);
            doMergeSort(array, middle + 1, higherIndex);

            merge(array, lowerIndex, middle, higherIndex);
        }
    }

    public static void merge(int[] array, int lowerIndex, int middle, int higherIndex) {
        System.out.println(lowerIndex);
        System.out.println(higherIndex);
        int[] tempArray = new int[array.length];
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempArray[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempArray[i];
            k++;
            i++;
        }

    }
    public static int[] getArrayOfIntegersFromConsole(){
        System.out.println("Enter numbers: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] result;
        try {
            String[] inputArray = reader.readLine().split(" ");
            result = new int[inputArray.length];
            for (int i = 0; i < inputArray.length; i++) {
                result[i] = Integer.parseInt(inputArray[i]);
            }
        }catch (Exception e){
            System.err.println("Invalid input");
            return null;
        }
        return result;

    }

}