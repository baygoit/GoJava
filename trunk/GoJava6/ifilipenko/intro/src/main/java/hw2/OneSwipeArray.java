package hw2;

public class OneSwipeArray {

    public boolean solution(int[] inputArray) {

        if (inputArray == null || inputArray.length < 2) {
            throw new IllegalArgumentException();
        }

        int max = inputArray[0];
        int maxIndex = 0;

        if(isSorted(inputArray)){
            return false;
        }

        //find the maximum element in the array
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > max) {
                max = inputArray[i];
                maxIndex = i;
            }
        }
        //check what is next smallest element
        for (int j = maxIndex + 1; j < inputArray.length - 1; j++) {
            if (!(inputArray[j] < max && inputArray[j + 1] < inputArray[j]))
                return false;
        }
        return true;
    }

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean arraySwaping(int[] inputArray) {
        if (inputArray == null || inputArray.length < 2) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] > inputArray[j]) {
                    swap(inputArray, i, j);
                }
            }
        }
        return false;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
