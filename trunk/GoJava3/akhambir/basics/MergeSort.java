/**
 * Created by root on 13.03.2015.
 */
public class MergeSort
{
    private  int[] unsorted, sorted;

    public MergeSort(int[] unsorted) {
        this.unsorted = unsorted;
    }

    public void sort() {
        int middle;
        int[] left, right;

        if (unsorted.length <= 1) {
            sorted = unsorted;
        } else {
            middle = unsorted.length / 2;

            left = new int[middle];
            right = new int[unsorted.length - middle];

            System.arraycopy(unsorted, 0, left, 0, middle);
            System.arraycopy(unsorted, middle, right, 0, unsorted.length - middle);

            MergeSort leftSort = new MergeSort(left);
            MergeSort rightSort = new MergeSort(right);

            leftSort.sort();
            rightSort.sort();

            sorted = merge(leftSort.getSorted(), rightSort.getSorted());
        }
    }

    public static int[] merge(int[] leftPart, int[] rightPart) {
        int cursorLeft = 0, cursorRight = 0, counter = 0;
        int[] merged = new int[leftPart.length + rightPart.length];

        while (cursorLeft < leftPart.length && cursorRight < rightPart.length) {
            if (leftPart[cursorLeft] <= rightPart[cursorRight]) {
                merged[counter] = leftPart[cursorLeft];
                cursorLeft++;
            } else {
                merged[counter] = rightPart[cursorRight];
                cursorRight++;
            }
            counter++;
        }

        if (cursorLeft < leftPart.length) {
            System.arraycopy(leftPart, cursorLeft, merged, counter, merged.length - counter);
        }
        if (cursorRight < rightPart.length) {
            System.arraycopy(rightPart, cursorRight, merged, counter, merged.length - counter);
        }

        return merged;
    }


    public int[] getSorted() {
        return sorted;
    }
}
