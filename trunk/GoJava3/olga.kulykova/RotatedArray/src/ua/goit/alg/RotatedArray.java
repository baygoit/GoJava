package ua.goit.alg;

/**
 * Created by Ольга on 18.03.2015.
 */
public class RotatedArray {
    //Iterative way of Binary Search
    public static int binarySearch(int[] array, int target) {
        int minInd = 0;
        int maxInd = array.length - 1;

        //If the array is empty
        if (maxInd < minInd) {
            return -1;
        }
        //If the array has one element
        if (array.length == 1) {
            return array[0];
        }

        while (maxInd >= minInd) {
            //Find the middle point
            int midInd = minInd + ((maxInd - minInd) / 2);

            //Comparisons
            if (minInd == maxInd && minInd == target) {
                return minInd;
            } else if (array[midInd] == target) {
                return midInd;
            } else if ((array[minInd] <= target) && (array[midInd] > target)
                    || (array[minInd] <= target) && (array[minInd] > array[midInd])) {
                maxInd = midInd - 1;
            } else {
                minInd = midInd + 1;
            }
        }
        return  -1;
    }
}
