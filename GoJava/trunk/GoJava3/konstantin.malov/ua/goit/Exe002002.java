package konstantin.malov;

/**
 * Created by kossovec on 16.03.2015.
 */
public class Exe002002 {
    private static int[] numberArray = {2, 4, 5, 3, 2, 4 ,5 ,6, 7, 8, 9, 4, 3 ,2, 1 ,4, -3, -1, -1, 0};
    public static void main(String[] args) {
        mergeSort(numberArray);
        for(int number: numberArray) {
            System.out.print(number + ", ");
        }
    }

    public static void mergeSort(int[] array){
        mergeSort(array, new int[array.length], 0, array.length);
    }

    private static void mergeSort(int[] array, int[] buffer, int start, int end) {
        if ( start + 1 < end) {
            int mid = (start + end) / 2;
            mergeSort(array, buffer, start, mid);
            mergeSort(array, buffer, mid, end);
            merge(array, buffer, start, mid, end);
        }
    }

    private static void merge(int[] array, int[] buffer, int start, int mid, int end) {
        int right = start;
        int left = mid;
        int count = start;
        System.arraycopy(array, start, buffer, start, end - start);
        while (right < mid && left < end) {
            if (buffer[right] < buffer[left]) {
                array[count] = buffer[right];
                right++;
            }else {
                array[count] = buffer[left];
                left++;
            }
            count++;
        }
        if (right < mid) {
            System.arraycopy(buffer, right, array, count, mid - right);
        }
        if (left < end) {
            System.arraycopy(buffer, left, array, count, end - left);
        }

    }
}
