import java.util.Arrays;

/**
 * Created by Dmytro on 29.10.2015.
 */
public class Sorter {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int[] numbers = {10,9,8,50,7,6,5,100,4,3,2,30,1,0};
        sorter.bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
        int[] numbers1 = {10,9,8,50,7,6,5,100,4,3,2,30,1,0};
        sorter.selectionSort(numbers1);
        System.out.println(Arrays.toString(numbers1));
        int[] numbers2 = {10,9,8,50,7,6,5,100,4,3,2,30,1,0};
        sorter.insertionSort(numbers2);
        System.out.println(Arrays.toString(numbers2));
        int[] numbers3 = {10,9,8,50,7,6,5,100,4,3,2,30,1,0};
        Arrays.sort(numbers3); //Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch
        System.out.println(Arrays.toString(numbers3));
    }

    public void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    swap(numbers, j, j + 1);
                }
            }
        }
    }

    public void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int min = numbers[i];
            int indexOfMin = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    indexOfMin = j;
                }
            }
            swap(numbers,i,indexOfMin);
        }
    }

    public void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int j = Arrays.binarySearch(numbers, 0, i, numbers[i]);
            if (j < 0) {
                j = - j - 1;
            }
            if (j < i) {
                int tmp = numbers[i];
                System.arraycopy(numbers, j, numbers, j + 1, i - j);
                numbers[j] = tmp;
            }
        }
    }



    private void swap(int[] numbers, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }
}
