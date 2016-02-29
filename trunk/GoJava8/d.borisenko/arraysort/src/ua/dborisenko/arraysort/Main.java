package ua.dborisenko.arraysort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static int INPUT_ARRAY_LENGTH = 21;
    private static int INPUT_ARRAY_MAX_VALUE = 50;

    private static void fillArrayRandomValues(int[] inputArray) {
        Random random = new Random();
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = random.nextInt((INPUT_ARRAY_MAX_VALUE) * 2) - INPUT_ARRAY_MAX_VALUE;
        }
    }

    private static int[] mergeSortedArrays(int[] arrayA, int[] arrayB) {
        int[] mergedArray = new int[arrayA.length + arrayB.length];
        int indexA = 0;
        int indexB = 0;
        int indexMerged;
        for (indexMerged = 0; indexA < arrayA.length && indexB < arrayB.length; indexMerged++) {
            if (arrayA[indexA] <= arrayB[indexB]) {
                mergedArray[indexA + indexB] = arrayA[indexA];
                indexA++;
            } else {
                mergedArray[indexA + indexB] = arrayB[indexB];
                indexB++;
            }
        }
        System.arraycopy(arrayA, indexA, mergedArray, indexMerged, arrayA.length - indexA);
        System.arraycopy(arrayB, indexB, mergedArray, indexMerged, arrayB.length - indexB);
        return mergedArray;
    };

    private static int[] sortArrayByMerging(int[] inputArray) {
        if (inputArray.length > 1) {
            int splitIndex = inputArray.length / 2;
            int[] arrayA = new int[splitIndex];
            int[] arrayB = new int[inputArray.length - splitIndex];
            System.arraycopy(inputArray, 0, arrayA, 0, splitIndex);
            System.arraycopy(inputArray, splitIndex, arrayB, 0, inputArray.length - splitIndex);
            arrayA = sortArrayByMerging(arrayA);
            arrayB = sortArrayByMerging(arrayB);
            inputArray = mergeSortedArrays(arrayA, arrayB);
        }
        return inputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[INPUT_ARRAY_LENGTH];
        fillArrayRandomValues(inputArray);
        System.out.println("Given array:");
        System.out.println(Arrays.toString(inputArray));
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(sortArrayByMerging(inputArray)));
    }
}
