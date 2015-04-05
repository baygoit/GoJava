package ua.goit.alg;

/**
 * Created by Alex on 19.03.2015.
 */
public class RotatedArrays {

    public static int binarySearch(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }
        return startBinarySearch(array, target, 0, array.length - 1);
    }

    private static int startBinarySearch(int[] array, int target, int startIndex, int endIndex) {
        int partitionIndex = startIndex + (endIndex - startIndex) / 2;
        while (startIndex != endIndex && array[partitionIndex] != target) {
            boolean inLeftArray1 = array[startIndex] <= target && target < array[partitionIndex];
            boolean inLeftArray2 = array[startIndex] <= target && array[partitionIndex] < array[startIndex];
            boolean inLeftArray3 =
                    target < array[partitionIndex] &&
                            array[partitionIndex] < array[startIndex] &&
                            array[partitionIndex] < array[endIndex];
            if (inLeftArray1 || inLeftArray2 || inLeftArray3) {
                endIndex = partitionIndex - 1;
            } else {
                startIndex = partitionIndex + 1;
            }
            partitionIndex = startIndex + (endIndex - startIndex) / 2;
        }
        if (array[partitionIndex] == target) {
            return partitionIndex;
        } else {
            return -1;
        }
    }
}
