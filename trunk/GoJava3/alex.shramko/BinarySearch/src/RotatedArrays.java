public class RotatedArrays {
    
    public static int binarySearch(int[] array, int elem) {
        int low = 0;
        int high = array.length - 1; 
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] == elem) {
                return middle;
            } else if (array[low] == elem) {
                return low;
            } else if (array[high] == elem) {
                return high;
            } 
            if (array[middle] > elem) {
                if (array[low] >= elem) {
                    low = middle + 1;
                    high--;
                } else {
                    high = middle - 1;
                    low++;
                }
            }
            if (array[middle] < elem) {
                if (array[high] <= elem) {
                    high = middle - 1;
                    low++;
                } else {
                    low = middle + 1;
                    high--;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
