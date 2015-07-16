package sort;

import java.util.Arrays;

public class Sort {

    private static int[] array  = {40, 10, 50, 30, 20};

    public static void main(String[] args){

        sortQuick();
        sortShell();
        sortBubble();
    }

    public static void  sortQuick(){

        int low = 0;
        int high = array.length - 1;
        sortQuickLogic(array, low, high);
        System.out.println(Arrays.toString(array));
    }


    public static void sortQuickLogic(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            sortQuickLogic(arr, low, j);
        }
        if (high > i) {
            sortQuickLogic(arr, i, high);
        }
    }

    public static void  sortShell(){

        int increment = array.length / 2;

        while (increment > 0) {
            for (int i = increment; i < array.length; i++) {
                int j = i;
                int temp = array[i];
                while (j >= increment && array[j - increment] > temp) {
                    array[j] = array[j - increment];
                    j = j - increment;
                }
                array[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void sortBubble(){

        for(int k = array.length-1; k >= 0; k--){
            for(int j = 0; j < k; j++){
                if(array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
