package ua.com.goit.gojava.lslayer.module1.project5;

import java.util.Random;

public class Sorter {
    int [] dataArray;
    
    public Sorter(int arraySize) {
        this.dataArray = randomizeArray(arraySize);
    }
    
    private int [] randomizeArray(int size) {
        int [] internalArray = new int[size];
        for (int i = 0; i < size; i++) {
            internalArray[i] = new Random().nextInt();
        }
        return internalArray;
    }
    
    public int bubleSortCounter(int [] sourceData) {
        int counter = 0;
        boolean swapOccured = true;
        while (swapOccured) {
            swapOccured = false;
            for (int i = 0; i < sourceData.length - 1; i++) {
                if (sourceData[i] > sourceData[i + 1]) {
                    sourceData[i] += sourceData[i + 1];
                    sourceData[i + 1] = sourceData[i] - sourceData[i + 1];
                    sourceData[i] -= sourceData[i + 1];
                    swapOccured = true;
                    counter++;
                }
            }
        }
        return counter;
    }
    
    public int quickSortcounter (int [] sourceData) {
        return quickSort(sourceData, 0, sourceData.length - 1);
    }
    
    private int quickSort(int[] array, int start, int end){
        if (start>=end) return 0;
        int pivot = array[(start + end) / 2];
        int bottomIterator = start;
        int topIterator = end;
        int counter = 0;
     
        while (bottomIterator <= topIterator){
            while (array[bottomIterator] < pivot){
                bottomIterator++;
            }
            while (array[topIterator] > pivot){
                topIterator--;
            }
            if (bottomIterator <= topIterator){
                array[bottomIterator] += array[topIterator];
                array[topIterator] = array[bottomIterator] - array[topIterator];
                array[bottomIterator] -= array[topIterator];
                bottomIterator++;
                topIterator--;
                counter ++;
            }
        }
        // Recursion
        if (start < topIterator) {
            counter += quickSort(array, start, topIterator);
        }
        if (bottomIterator < end) {
            counter += quickSort(array, bottomIterator, end);
        }
        return counter;
    }
}
