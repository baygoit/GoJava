package ua.dborisenko.arraysort;

import java.util.Arrays;
import java.util.Random;

public class Application {

    private static final int INPUT_ARRAY_LENGTH = 21;
    private static final int INPUT_ARRAY_MAX_VALUE = 50;

    protected int[] getRandomArray(int length) {
        Random random = new Random();
        int[] randomArray = new int[length];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt((INPUT_ARRAY_MAX_VALUE) * 2) - INPUT_ARRAY_MAX_VALUE;
        }
        return randomArray;
    }

    protected int[] mergeSortedArrays(int[] arrayA, int[] arrayB) {
        int[] mergedArray = new int[arrayA.length + arrayB.length];
        int indexA = 0;
        int indexB = 0;
        int indexMerged;
        for (indexMerged = 0; indexA < arrayA.length && indexB < arrayB.length; indexMerged++) {
            if (arrayA[indexA] <= arrayB[indexB]) {
                mergedArray[indexMerged] = arrayA[indexA];
                indexA++;
            } else {
                mergedArray[indexMerged] = arrayB[indexB];
                indexB++;
            }
        }
        System.arraycopy(arrayA, indexA, mergedArray, indexMerged, arrayA.length - indexA);
        System.arraycopy(arrayB, indexB, mergedArray, indexMerged, arrayB.length - indexB);
        return mergedArray;
    };

    protected int[] sortArrayByMerging(int[] inputArray) {
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

    protected void start() {
        int[] inputArray = getRandomArray(INPUT_ARRAY_LENGTH);
        System.out.println("Given array:");
        System.out.println(Arrays.toString(inputArray));
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(sortArrayByMerging(inputArray)));
    }

}
