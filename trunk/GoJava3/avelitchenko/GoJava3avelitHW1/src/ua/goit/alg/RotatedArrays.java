package ua.goit.alg;

public class RotatedArrays {

    public static int binarySearch(int[] array, int target) {
        int resultIndex = noBinarySearch(array, target, 0 , array.length - 1);
        return resultIndex;
    }

    private static int noBinarySearch(int[] array, int target, int start, int finish) {
        if (start > finish) {return -1;}
        if (target == array[start]) {return start;}
        if (target == array[finish]) {return finish;}
        if (start == finish){
            if (target == array[start]){
                return start;
            } else {
                return -1;
            }
        }
        if (array[start] < array[finish]){
            // sorted part, lets start binary search 
            if ((array[start] < target) && (target < array[finish])){
                return binarySearch(array, target, start + 1 , target - 1);
            } else {
                return -1;
            }
        }
        //unsorted part, lets divide
        int middle = start + (finish - start) / 2;
        int leftPartResult = noBinarySearch(array, target, start + 1, middle);
        int rightPartResult = noBinarySearch(array, target, middle + 1, finish - 1);
        return Math.max(leftPartResult, rightPartResult);
    }
   
    private static int binarySearch(int[] array, int target, int start, int finish) {
        if (start < finish) {return -1;}
        if (target == array[start]) {return start;}
        if (target == array[finish]) {return finish;}
        if (start == finish) {
            if (target == array[start]) {
                return start;
            } else {
                return -1;
            }
        }
        int middle = start + (finish - start) / 2;
        if (target == array[middle]) {return middle;}
        if (array[middle] < target) {
            return binarySearch(array, target, middle + 1, target - 1);
        } else {
            return binarySearch(array, target, start + 1, middle - 1);
        }
    }

}
