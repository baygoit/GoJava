import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Test cases
Input: 5 12 3 1 88 2 5 6 7 11 (through Enter)
Output: 1 2 3 5 5 6 7 11 12 88

 */
public class MergeSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        while (true) {
            String s = reader.readLine();
            if ("".equals(s)) {
                break;
            }
            list.add(Integer.parseInt(s));
        }
        reader.close();

        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] array) {
        int[] subArray = new int[array.length];
        sort(array, subArray, 0, array.length - 1);

    }

    public static void sort(int[] array, int[] subArray, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            sort(array, subArray, first, middle);
            sort(array, subArray, middle + 1, last);
            merge(array, subArray, first, middle + 1, last);
        }
    }

    public static void merge (int[] array, int[] subArray, int first, int middle, int last) {
        int j = middle - 1;
        int k = first;
        int len = last - first + 1;

        while (first <= j && middle <= last) {
            if (array[first] <= array[middle]) {
                subArray[k++] = array[first++];
            } else {
                subArray[k++] = array[middle++];
            }
        }

        while (first <= j) {
            subArray[k++] = array[first++];
        }

        while (middle <= last) {
            subArray[k++] = array[middle++];
        }

        for (int i = 0; i < len; i++, last--) {
            array[last] = subArray[last];
        }
    }
}
