package gojava1.iavorskyi;

public class SortingAlgorithmsAnalyzer {

    public static void main(String[] args) {

        int arrSize = 100000;
        int[] arr = new int[arrSize];
        int[] backupCopy = new int[arrSize];
        long timeBefore = 0;
        long timeAfter = 0;
        String sortTipe = null;

        arr = generateArr(arr);
        backupCopy = arr;

        for (int i = 0; i < 4; i++) {
            arr = backupCopy;
            timeBefore = System.nanoTime();
            switch (i) {
            case 0:
                sortTipe = "shellSort";
                shellSort(arr);
                break;
            case 1:
                sortTipe = "quickSort";
                quickSort(arr);
                break;
            case 2:
                sortTipe = "heapSort";
                heapSort(arr);
                break;
            case 3:
                sortTipe = "bubbleSort";
                bubbleSort(arr);
                break;

            default:
                break;
            }
            timeAfter = System.nanoTime();
            print(timeBefore, timeAfter, sortTipe, arrSize);
        }
    }

    public static void print(long before, long after, String sortTipe,
            int arrSize) {
        System.out.println("Time to sort the same array of " + arrSize
                + " elements with " + sortTipe + " is: "
                + ((after - before) / 1000000) + " ms");
    }

    public static int[] generateArr(int[] arrToSort) {
        for (int i = 0; i < arrToSort.length; i++) {
            arrToSort[i] = (int) (Math.random() * arrToSort.length);
        }
        return arrToSort;
    }

    public static void bubbleSort(int[] arrToSort) {
        int tmp;

        for (int i = 0; i < arrToSort.length - 1; i++)
            for (int j = 0; j < arrToSort.length - i - 1; j++)
                if (arrToSort[j] > arrToSort[j + 1]) {
                    tmp = arrToSort[j];
                    arrToSort[j] = arrToSort[j + 1];
                    arrToSort[j + 1] = tmp;
                }
    }

    public static void shellSort(int[] arrToSort) {
        int increment = arrToSort.length / 2;
        int j = 0;
        int temp = 0;
        
        while (increment > 0) {
            for (int i = increment; i < arrToSort.length; i++) {
                j = i;
                temp = arrToSort[i];
                while (j >= increment && arrToSort[j - increment] > temp) {
                    arrToSort[j] = arrToSort[j - increment];
                    j = j - increment;
                }
                arrToSort[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }

    }

    public static void quickSort(int[] arrToSort) {
        Quicksort.sort(arrToSort);;
    }

    public static void heapSort(int[] arrToSort) {
        HeapSort.sort(arrToSort);
    }

}

// This class was stolen by me from web
class Quicksort {
    private static int[] numbers;
    private static int number;

    public static void sort(int[] arrToSort) {
        if (arrToSort == null || arrToSort.length == 0) {
            return;
        }
        numbers = arrToSort;
        number = arrToSort.length;
        quicksort(0, number - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high - low) / 2];

        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

// This class was stolen by me from web
class HeapSort {

    public static void sort(int[] arrToSort) {
        buildHeap(arrToSort);
        int length = arrToSort.length - 1;
        while (length > 0) {
            swap(arrToSort, 0, length);
            heapify(arrToSort, length, 0);
            length--;
        }
    }

    private static void buildHeap(int[] a) {
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, a.length, i);
        }
    }

    private static void heapify(int[] a, int length, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < length && a[i] < a[l]) {
            largest = l;
        }
        if (r < length && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, length, largest);
        }
    }

    private static int right(int i) {
        return 2 * i + 1;
    }

    private static int left(int i) {
        return 2 * i + 2;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}