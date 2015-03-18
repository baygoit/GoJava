public class RotatedArrays {
    static int low;
    static int high;
    static int middle;

    static void moveUp() {
        low = middle + 1;
        high--;
    }

    static void moveDown() {
        high = middle - 1;
        low++;
    }

    public static int binarySearch(int[] array, int elem) {
        low = 0;
        high = array.length - 1;
        while (low <= high) {
            middle = (low + high) / 2;
            if (array[middle] == elem) {
                return middle;
            } else if (array[low] == elem) {
                return low;
            } else if (array[high] == elem) {
                return high;
            }
            if (array[middle] > elem) {
                if (array[low] > elem) {
                    if (array[middle] < array[low]) {
                        moveDown();
                    } else {
                        moveUp();
                    }
                } else {
                    moveDown();
                }
            } else if (array[middle] < elem) {
                if (array[middle] > array[low]) {
                    moveUp();
                } else {
                    moveDown();
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
