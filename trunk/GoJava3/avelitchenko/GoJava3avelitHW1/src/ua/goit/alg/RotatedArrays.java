package ua.goit.alg;

public class RotatedArrays {

    public static int binarySearch(int[] array, int target) {
        int resultIndex = binarySearchInLoop(array, target, 0 , array.length - 1);
        return resultIndex;
    }

    private static int binarySearchInLoop(int[] array, int target, int start, int finish) {
        while (start <= finish) {
            if (target == array[start]) {
                return start;
            }
            if (target == array[finish]) {
                return finish;
            }
            if (start == finish) {
                return -1;
            }
            if (finish - start == 1) {
              return -1;
            }
            int middle = (start + finish) >>> 1;
            //sorted left part or right part, so if target in this sorted part lets find it 
            if (array[start] < array[middle]) {
                if ((array[start] < target) && (target < array[middle])) {
                    finish = middle;
                } else {
                    start = middle;
                }
            } else if ((array[middle] < target) && (target < array[finish])) {
                start = middle;
            } else {
                finish = middle;
            }
        }
        return -1;
    }

    
    
    //for history
    public static int binarySearch_recursively(int[] array, int target) {
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
        if (start > finish) {return -1;}
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
