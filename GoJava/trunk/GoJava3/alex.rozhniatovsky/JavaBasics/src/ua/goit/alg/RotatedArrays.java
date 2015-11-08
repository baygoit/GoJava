package ua.goit.alg;

public class RotatedArrays {
    public static int binarySearch(int[] array, int target) {
        return search(array, target, 0, array.length - 1);
    }

    private static int search(int[] array, int target, int start, int end) {
        int mid = (start + end) / 2;

        // number doesn`t exist
        if (start > end) {
            return -1;
        }
        
        //index has been found
        if (array[mid] == target) {
            return mid;
        }
        
        // left part of array is sorted
        if (array[start] <= array[mid]) {
            // target in left part
            if (array[start] <= target && array[mid] >= target) {
                return search(array, target, start, mid - 1);
            } else {
                return search(array, target, mid + 1, end);
            }
        } else {
            if (array[mid] <= target && array[end] >= target) {
                return search(array, target, mid + 1, end);
            } else {
                return search(array, target, start, mid - 1);
            }
        }
    }
}
