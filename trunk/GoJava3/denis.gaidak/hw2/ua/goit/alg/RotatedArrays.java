package ua.goit.alg;

public class RotatedArrays {

    public static int binarySearch(int[] array, int target) {
        return startBinarySearch(array, target, 0, array.length - 1);
    }

    private static int startBinarySearch(int[] array, int target, int left, int right) {
        if (array.length == 0) return -1;
        if (target == array[left]) return left;
        if (target == array[right]) return right;
        if (left >= right) return -1;

        int middle = (right+left)>>1;
        if (array[middle] > array[right] && array[right] >= target) {
            return startBinarySearch(array, target, middle, right);
        }

        if (array[middle] == target) {
            return middle;
        } else if (array[middle] > target) {
            return startBinarySearch(array, target, left+1, middle-1);
        } else {
            return startBinarySearch(array, target, middle+1, right-1);
        }

    }

}
