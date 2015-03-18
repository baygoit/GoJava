/**
 * Created by Ольга on 18.03.2015.
 */
public class BinarySearch {
    //Recursive way of BinarySearch
    public int findIndex(int[] array, int key, int minInd, int maxInd) {
        //If the array is empty
        if (maxInd < minInd) {
            return -1;
        }

        //find middle point
        int midInd = minInd + ((maxInd - minInd) / 2);

        //Comparisons
        if (array[midInd] > key) {
            //Check left half
            int result = findIndex(array, key, minInd, midInd - 1);
            //If key is not found in left half go to right half
            if (result == -1) {
                 return findIndex(array, key, midInd + 1, maxInd);
            } else {
                return findIndex(array, key, minInd, midInd - 1);
            }
        } else if (array[midInd] < key) {
            //Check right half
            int result = findIndex(array, key, midInd + 1, maxInd);
            //If key is not found in right half go to left half
            if (result == -1) {
                return findIndex(array, key, minInd, midInd - 1);
            }
            return findIndex(array, key, midInd + 1, maxInd);
        } else {
            return midInd;
        }
    }
}
