import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ольга on 16.03.2015.
 */

/*
Test cases
Input: 5 12 3 1 88 2 5 6 7 11 (through Enter)
Output: 1 2 3 5 5 6 7 11 12 88

 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        //Input numbers to list
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

        //Fill in the array
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        // Sort and output
        array = mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSort(int[] array) {
        //Check length of array. Finally array must contain 1 element.
        if (array.length < 2) {
            return array;
        }
        //Divide array on 2 halves.
        int[] half1 = new int[array.length / 2];
        int[] half2 = new int[array.length - half1.length];
        System.arraycopy(array, 0, half1, 0, half1.length);
        System.arraycopy(array, half1.length, half2, 0, half2.length);
        //Recursion
        mergeSort(half1);
        mergeSort(half2);
        //Merge two halves to original array
        merge(half1, half2, array);

        return array;
    }

    public static void merge(int[] half1, int[] half2, int[] array) {
        int pos1 = 0;     //position into half1
        int pos2 = 0;     //position into half2
        int posArray = 0; //position into origin array

        //Find less element and put it into original array
        while (pos1 < half1.length && pos2 < half2.length) {
            if (half1[pos1] < half2[pos2]) {
                array[posArray] = half1[pos1];
                pos1++;
            } else {
                array[posArray] = half2[pos2];
                pos2++;
            }
            posArray++;
        }
        //Copy left elements
        System.arraycopy(half1, pos1, array, posArray, half1.length - pos1);
        System.arraycopy(half2, pos2, array, posArray, half2.length - pos2);
    }
}
