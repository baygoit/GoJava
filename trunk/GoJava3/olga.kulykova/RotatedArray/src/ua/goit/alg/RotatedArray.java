package ua.goit.alg;

public class RotatedArray {
    public static int binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int middle = min + ((max - min) / 2);
            boolean moreMin = target > array[min];
            boolean lessMiddle = target < array[middle];
            boolean moreMiddle = target > array[middle];
            boolean lessMax = target < array[max];

            if (array[middle] == target) {
                return middle;
            } else if (array[min] == target) {
                return min;
            } else if (array[max] == target) {
                return max;
            } else if (array[middle] > array[min]) {
                if (moreMin && lessMiddle) {
                    max = middle;
                } else {
                    min = middle + 1;
                }
            } else {
                if (moreMiddle && lessMax) {
                    min = middle + 1;
                } else {
                    max = middle - 1;
                }
            }
        }
        return  -1;
    }
}
