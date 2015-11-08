/**
 * Created by Dmytro on 29.10.2015.
 */
import java.util.Arrays;

public class MergeSorter1 {
    public static void main(String[] args) {
        MergeSorter1 sorter = new MergeSorter1();
        int[] numbers = {10,9,8,50,7,6,5,100,4,3,2,30,1,0};
        sorter.mergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public void mergeSort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length);
    }

    private void mergeSort (int[] numbers, int from, int to) {
        if (to <= from + 1) {
            return;
        }

        int mid = (from + to) / 2;
        mergeSort(numbers, from, mid);
        mergeSort(numbers, mid, to);
        merge(numbers, from, mid, to);
    }

    private void merge(int[] numbers, int from, int mid, int to) {
        int left = from;
        int right = mid;
        int index = 0;
        int[] res = new int[to - from];
        while (left < mid && right < to) {
            if (numbers[left] < numbers[right]) {
                res[index++] = numbers[left++];
            } else {
                res[index++] = numbers[right++];
            }
        }

        if (left < mid) {
            System.arraycopy(numbers, left, numbers, from + index, mid - left);
        } else {
            System.arraycopy(numbers, right, numbers, from + index, to - right);
        }

        System.arraycopy(res, 0, numbers, from, index);

    }
}
