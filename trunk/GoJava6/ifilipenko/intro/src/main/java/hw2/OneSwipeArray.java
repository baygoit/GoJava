package hw2;

public class OneSwipeArray {
    public boolean solution(int[] inputArray) {
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
