/**
 * Created by Aleksey Kurkov on 18.03.15.
 */

public class RotatedArrays {

    public static int binarySearch(int[] array, int target, int start, int end) {
        int middle;

        // array contains 0 items
        if (array.length == 0) {
            return -1;
        }

        // continue searching while [start,end] is not empty
        while (end >= start) {
            // calculate the midpoint for roughly equal partition
            if (end == start) {
                middle = start;
            } else {
                middle = midpoint(end, start);
            }

            // target found at index middle
            if (array[middle] == target) {
                return middle;
            }
            // determine which subarray to search
            else if (array[middle] < target) {
                // change start to search upper subarray
                start++;

            } else {
                // change end to search lower subarray
                end--;
            }
        }
        // target was not found
        return -1;
    }

    private static int midpoint(int start, int end) {
        return (start / 2 + end / 2);
    }

    public static int binaryModifiedSearch(int[] array, int target) {
        //check if array is empty
        if (array.length == 0) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int middle;

        // get pivot where rotated array starts
        while (array[start] > array[end]) {
            middle = midpoint(start, end);
            if (array[middle] > array[end]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        int pivot = start;
        if (array[pivot] == target){
            return pivot;
        }

        // search target before pivot
        int result1 = binarySearch(array, target, pivot, array.length - 1);
        // search target after pivot
        int result2 = binarySearch(array, target, 0, pivot);

        // return search result
        if (result1 != -1) {
            return result1;
        } else if (result2 != -1) {
            return result2;
        } else {
            return -1; // target was not found
        }
    }
}