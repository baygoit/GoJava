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
}
