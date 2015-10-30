import java.util.Arrays;

/**
 * Created by Dmytro on 22.10.2015.
 */
public class MergeSorter {
    public static void main(String[] args) {
        MergeSorter sorter = new MergeSorter();
        System.out.println(Arrays.toString(sorter.mergeSort(new int[]{20, 10, 15, 30, 100, 15, 5, 20})));
    }

    public int[] mergeSort (int[] numbers) {
        if (numbers.length == 1) {
            return numbers;
        }

        int leftSize = numbers.length / 2;
        int rightSize = numbers.length - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        System.arraycopy(numbers, 0, left, 0, leftSize);
        System.arraycopy(numbers, leftSize, right, 0, rightSize);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int leftSize = left.length;
        int rightSize = right.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        int[] res = new int[leftSize + rightSize];
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (left[leftIndex] < right[rightIndex]) {
                res[index++] = left[leftIndex++];
            } else {
                res[index++] = right[rightIndex++];
            }
        }

        if (leftIndex < leftSize) {
            res[index++] = left[leftIndex++];
        } else {
            res[index++] = right[rightIndex++];
        }

        return res;
    }
}
