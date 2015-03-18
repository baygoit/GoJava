package ua.goit.alg;

/**
 * Created by roznalex on 18.03.2015.
 * with help
 */
public class RotatedArrays {
    public static int binarySearch(int[] array, int target, int start, int end) {
        int mid = (start + end) / 2;

        //number doesn`t exist
        if (start > end) {
            return -1;
        }

        //index has been found
        if (array[mid] == target) {
            return mid;
        }

        //left part of array is sorted
        if (array[start] <= array[mid]) {
            //target in left part
            if (array[start] <= target && array[mid] >= target) {
                return binarySearch(array, target, start, mid - 1);
            }
            //target in right part
            else {
                return binarySearch(array, target, mid + 1, end);
            }
        }
        else {
            if (array[mid] <= target && array[end] >= target) {
                return binarySearch(array, target, mid + 1, end);
            }
            else {
                return binarySearch(array, target, start, mid - 1);
            }
        }
    }

}
