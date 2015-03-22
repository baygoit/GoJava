package ua.goit.alg;

/**
 * Created by Ольга on 18.03.2015.
 */
public class RotatedArray {
    //Iterative way of Binary Search
    public static int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;

        //If the array is empty
        if (max < min) {
            return -1;
        }
        //If the array has one element
        if (array.length == 1) {
            return array[0];
        }

        while (max >= min) {
            //Find the middle point
            int middle = min + ((max - min) / 2);

            //Comparisons
            if (array[middle] == target) {
                return middle;
            } else if (array[min] == target) {
                return min;
            } else if (array[max] == target) {
                return max;
            } else if (array[middle] > array[min]) {
                if (target > array[min] && target < array[middle]) {
                    max = middle - 1;
                } else {
                    min = middle + 1;
                }
            } else {
                if (target > array[middle] && target < array[max]) {
                    min = middle + 1;
                } else {
                    max = middle - 1;
                }
            }
        }
        return  -1;
    }
}
