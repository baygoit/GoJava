package ua.goit.alg;

/**
 * Created by kossovec on 18.03.2015.
 */
public class RotatedArrays  {

        public static int binarySearch(int[] array, int target) {
            return search(array, 0, array.length - 1, target);
        }

        private static int search(int[] array, int start, int end, int targetInt) {
            if (end < start) {
                return -1;
            }

            int mid = start + (end - start) / 2;
            if (array[mid] == targetInt) {
                return mid;
            }
            //The main different between common binary search is:
            // algorithm comparison not only the middle element,
            // but it comparison the middle and last element or first
            if (array[mid] >= array[start]) {
                return (array[start] <= targetInt && targetInt <= array[mid] ) ?
                        search(array, start, mid - 1 , targetInt) :
                        search(array , mid + 1, end, targetInt);
            } else {
                return (array[mid] <= targetInt && targetInt <= array[end]) ?
                        search(array , mid + 1, end, targetInt) :
                        search(array, start, mid -1 , targetInt);
            }

        }

    }
