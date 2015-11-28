package go.it.salivon;

import go.it.main.Sort;
import java.util.Arrays;
import java.util.List;

public class MergeSort extends Sort {

    private List<Integer> array;
    private int[] tempMergArr;
    private int length;

    public static void main(String a[]) {

        List<Integer> inputArr = Arrays.asList(1, 45, 23, 11, 3, 89, 24, 5, 77, 28, 98, 4, 28, 65, 5, 2, 43);
        MergeSort mms = new MergeSort();
        mms.sort(inputArr);
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public List<Integer> sort(List<Integer> inputArr) {
        this.array = inputArr;
        this.length = inputArr.size();
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
        return array;
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;

            doMergeSort(lowerIndex, middle);

            doMergeSort(middle + 1, higherIndex);

            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array.get(i);
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array.set(k, tempMergArr[i]);
                i++;
            } else {
                array.set(k, tempMergArr[j]);
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array.set(k, tempMergArr[i]);
            k++;
            i++;
        }

    }
}
