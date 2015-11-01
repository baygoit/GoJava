import java.util.Arrays;

/**
 * Created by Dmytro on 22.10.2015.
 */
public class QuickSorter {
    public static void main(String[] args) {
        QuickSorter sorter = new QuickSorter();
        int[] numbers = {10,9,8,50,7,6,5,100,4,3,2,30,1,0};
        System.out.println(Arrays.toString(sorter.quickSort1(numbers)));
        sorter.quickSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }

    public int[] quickSort1(int[] numbers) {
        return quickSort1(numbers, numbers.length);
    }

    public int[] quickSort1(int[] numbers, int length) {
        if (length <= 1) {
            return numbers;
        }

        int pivot = numbers[0];
        int[] low = new int[length];
        int[] high = new int[length];
        int lowIndex = 0;
        int highIndex = 0;
        for (int i = 1; i < length; i++) {
            if (numbers[i] < pivot) {
                low[lowIndex++] = numbers[i];
            } else {
                high[highIndex++] = numbers[i];
            }
        }
        int[] sortedLow = quickSort1(low, lowIndex);
        int[] sortedHigh = quickSort1(high, highIndex);
        int[] res = new int[length];
        System.arraycopy(sortedLow, 0, res, 0, lowIndex);
        res[lowIndex] = pivot;
        System.arraycopy(sortedHigh, 0, res, lowIndex + 1, highIndex);
        return res;
    }

    public void quickSort(int[] numbers) {
        quickSort(numbers, 0, numbers.length);
    }

    private void quickSort(int[] numbers, int from, int to) {
        if (to <= from + 1) {
            return;
        }

        int mid = (from + to) / 2;
        int pivot = numbers[mid];

        int high = to - 1;
        while (numbers[high] > pivot) {
            high--;
        }

        int low = from;
        while (numbers[low] < pivot) {
            low++;
        }

        if (low < high) {
            swap(numbers, low, high);
            quickSort(numbers, from, to);
        } else {
            quickSort(numbers, from, low);
            quickSort(numbers, low, to);
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
