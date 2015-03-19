package homework1;

import java.util.Arrays;

/**
 * Created by Alex on 16.03.2015.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] testArray = {1, 15, 2, 8, 3, 4, 19, 11, 6, 7, 4, 9, 3, 9, 2, 8};
        mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    private static void mergeSort(int[] array) {
        mergeSortStart(array, 0, array.length-1);
    }

    private static void mergeSortStart(int[] array, int firstElement, int lastElement) {
        if (firstElement<lastElement) {
            int partitionElement = (firstElement+lastElement)/2;
            mergeSortStart(array, firstElement, partitionElement);
            mergeSortStart(array, partitionElement + 1, lastElement);
            mergeArrays(array, firstElement, partitionElement, lastElement);
        }
    }

    private static void mergeArrays(int[] array, int firstElement, int partitionElement, int lastElement) {
        int elementsInLeftArray = partitionElement - firstElement + 1;
        int elementsInRightArray = lastElement - partitionElement;
        int[] leftArray = new int[elementsInLeftArray+1];
        int[] rightArray = new int[elementsInRightArray+1];
        for (int i=0;i<leftArray.length-1;i++) {
            leftArray[i] = array[firstElement + i]; //!!! -1
        }
        for (int i=0;i<rightArray.length-1;i++) {
            rightArray[i] = array[partitionElement + i + 1];
        }
        leftArray[leftArray.length-1] = Integer.MAX_VALUE;
        rightArray[rightArray.length-1] = Integer.MAX_VALUE;
        int leftPosition = 0;
        int rightPosition = 0;
        for (int i=firstElement;i<lastElement+1;i++) {
            if (leftArray[leftPosition]<=rightArray[rightPosition]) {
                array[i] = leftArray[leftPosition];
                leftPosition++;
            } else {
                array[i] = rightArray[rightPosition];
                rightPosition++;
            }
        }
    }
}
