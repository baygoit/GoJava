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

        //Find the middle point
        int midInd = minInd + ((maxInd - minInd) / 2);

        //Comparisons
        if (array[midInd] > key) {
            //Check the left half
            int result = findIndex(array, key, minInd, midInd - 1);
            //If the key is not found in the left half go to the right half
            if (result == -1) {
                 return findIndex(array, key, midInd + 1, maxInd);
            } else {
                return findIndex(array, key, minInd, midInd - 1);
            }
        } else if (array[midInd] < key) {
            //Check he right half
            int result = findIndex(array, key, midInd + 1, maxInd);
            //If the key is not found in the right half go to the left half
            if (result == -1) {
                return findIndex(array, key, minInd, midInd - 1);
            }
            return findIndex(array, key, midInd + 1, maxInd);
        } else {
            return midInd;
        }
    }
}
