package ua.goit.alg;

/**
 * Created by Alex on 19.03.2015.
 */
public class RotatedArrays {

    public static int binarySearch(int[] array, int target) {
        if (array.length==0) {
            return -1;
        }
        return startBinarySearch(array, target, 0, array.length - 1);
    }

    private static int startBinarySearch(int[] array, int target, int startIndex, int endIndex) {
        if (startIndex==endIndex) {
            if (array[startIndex]==target) {
                return startIndex;
            } else {
                return -1;
            }
        }
        int partitionIndex = startIndex + (endIndex-startIndex)/2;
        if (array[partitionIndex]==target) {
            return partitionIndex;
        }
        if ((array[startIndex]<=target && array[partitionIndex]>target) || (array[startIndex]<=target && array[startIndex]>array[partitionIndex])) {
            return startBinarySearch(array, target, startIndex, partitionIndex-1);
        } else {
            return startBinarySearch(array, target, partitionIndex+1, endIndex);
        }
    }
}
