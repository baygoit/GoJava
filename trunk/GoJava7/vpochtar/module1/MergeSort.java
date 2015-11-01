//You need to implement Merge Sort algorithm.

import java.util.Arrays;

public class MergeSort{
	private int[] array;
    private int[] tempMergArr;
    private int length;
 
    public static void main(String[] args){
         
        int[] input = {23123, 12355, 1232, 112, 513, -1232, 122, 23, 66, 123, -123, -123};
        MergeSort mms = new MergeSort();
        mms.sort(input);
        for(int i : input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
     
    public void sort(int inputArr[]){
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
 
    private void doMergeSort(int lowerIndex, int higherIndex){
         
        if (lowerIndex < higherIndex){
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
 
    private void mergeParts(int lowerIndex, int middle, int higherIndex){
 
        for (int i = lowerIndex; i <= higherIndex; i++){
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex){
            if (tempMergArr[i] <= tempMergArr[j]){
                array[k] = tempMergArr[i];
                i++;
            }
            else{
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle){
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
