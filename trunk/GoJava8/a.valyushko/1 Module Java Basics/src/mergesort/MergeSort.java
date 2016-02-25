package mergesort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public static void main(String[] args) throws IOException{
        System.out.println("Enter 10 integer numbers:");
        int[] checkArray = userInput();
        System.out.println("Your entered numbers:");
        printToConsole(checkArray);
        
        checkArray = mergeSort(checkArray);//sorting array using merge sort

        System.out.println();
        System.out.println("Numbers after merge sorting:");

        printToConsole(checkArray);
    }

    private static int[] userInput() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] resultArray = new int[10];
        for(int i = 0; i < 10; i++){
            String inputString = reader.readLine();
            try{
                int number = Integer.parseInt(inputString);
                resultArray[i] = number;
            }
            catch(NumberFormatException e){
                System.out.println(e);
            }
        }
        return resultArray;
    }

    private static int[] mergeSort(int[] unsortedArray){
        if(unsortedArray.length <= 1){
            return unsortedArray;
        }
        int halfArray = unsortedArray.length / 2;
        int[] leftArray = new int[halfArray];
        int[] rightArray;
        if(unsortedArray.length % 2 == 0){
            rightArray = new int[halfArray];
        }
        else{
            rightArray = new int[halfArray + 1];
        }
        int[] result = new int[unsortedArray.length];
        for(int i = 0; i < halfArray; i++){
            leftArray[i] = unsortedArray[i];
        }

        int position = 0;
        for(int j = halfArray; j < unsortedArray.length; j++){
            if(position < rightArray.length){
                rightArray[position] = unsortedArray[j];
                position++;
            }
        }

        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);
        result = merge(leftArray, rightArray);
        return result;
    }

    private static int[] merge (int[] left, int[] right){
        int lengthResult = left.length + right.length;
        int[] result = new int[lengthResult];
        int indexL = 0;
        int indexR = 0;
        int indexRes = 0;

        while(indexL < left.length || indexR < right.length){
            if(indexL < left.length && indexR < right.length){
                if(left[indexL] <= right[indexR]){
                    result[indexRes] = left[indexL];
                    indexL++;
                    indexRes++;
                }
                else{
                    result[indexRes] = right[indexR];
                    indexR++;
                    indexRes++;
                }
            }
            else if(indexL < left.length){
                result[indexRes] = left[indexL];
                indexL++;
                indexRes++;
                }
            else if(indexR < right.length){
                result[indexRes] = right[indexR];
                indexR++;
                indexRes++;
            }
        }
        return result;
    }
    
    private static void printToConsole(int[] list){
        for(int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}
