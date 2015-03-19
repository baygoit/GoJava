package ua.goit.alg;

public class RotatedArrays {

    public static int binarySearch_old(int[] array, int target) {

        if (array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length;

        while (left <= right) {
            int middle = left + (right-left)/2;

            if (array[middle] == target) return middle;

            if (array[middle] > target) {
                right = middle--;
            } else {
                left = middle++;
            }
        }

        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) return -1;
        return starBinarySearh(array, target, 0, array.length-1);
    }

    private static int starBinarySearh(int[] array, int target, int left, int right) {
        if (target == array[left]) return left;
        if (target == array[right]) return right;
        if (left >= right) return -1;

        int middle = left + (right-left)/2;

//        if (array[left] > array[right]) {
//            return -10;
//        }

        if (array[middle] == target) {
            return middle;
        } else if (array[middle] > target) {
            return starBinarySearh(array, target, left, middle--);
        } else {
            return starBinarySearh(array, target, middle++, right);
        }

//        return -1;
    }

}
