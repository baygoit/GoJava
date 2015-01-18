package ua.com.goit.gojava.alkot;

import java.util.Random;

public class Sorts {

    private static int countSwaps;


    public static void main(String[] args) {
        final int N = 10000;
        int[] unsortedArray = generateRandomIntArray(N, N);
        int[] sortedArray;
        long timeStart;

        System.out.println("Array renerated (number of items="+N +")");
        countSwaps=0;
        timeStart =System.currentTimeMillis();
        sortedArray = unsortedArray.clone();
        quickSort(sortedArray, 0, N - 1);
        // bubbleSort(sortedArray, 0, N - 1);
        System.out.println("QuickSort swaps =  " + countSwaps + " Time(ms):"+(System.currentTimeMillis()-timeStart));
        
        countSwaps=0;
        timeStart =System.currentTimeMillis();
        sortedArray = unsortedArray.clone();
        bubbleSort(sortedArray, 0, N - 1);
        System.out.println("Bubble swaps =  " + countSwaps+ " Time(ms):"+(System.currentTimeMillis()-timeStart));

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int x = array[(left + right) / 2+1];
            int i = left;
            int j = right;
            int tmp;

            do {
                while (array[i] < x)
                    i++;

                while (array[j] > x)
                    j--;
                
                if (i<=j) {
                    countSwaps++;
                    tmp =array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                    i++;
                    j--;
                }
                    
                
            } while (i < j);
            
            if (left<j)
                quickSort(array, left, j);
            if (i<right)
                quickSort(array, i, right);
        }
    }
    
    

    public static void bubbleSort(int[] array, int left, int right) {
        int tmp;

        for (int i = left; i < right; i++)
            for (int j = i + 1; j <= right; j++)
                if (array[i] > array[j]) {
                    countSwaps++;
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }

    }


    // generate new random array of int
    private static int[] generateRandomIntArray(int numberOfItems, int maxValue) {
        int[] array = new int[numberOfItems];
        Random rand = new Random();

        for (int i = 0; i < numberOfItems; i++)
            array[i] = rand.nextInt(maxValue);

        return array;
    }

}
