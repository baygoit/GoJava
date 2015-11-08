package home_work.oneswipetest;

/**
 * Created by slavik on 23.09.2015.
 */
public class OneSwipeArrayTest {
    public int[] array;

    public OneSwipeArrayTest(int[] array) {
        this.array = array;
    }

    public boolean test() {
        int  i = 0, j;

        while (array[i] < array[i+1]) {
            i++;
        }

        j = i + 1;
        while (array[i-1] < array[j]) {
            j++;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        for (i = 0, j = 1; j < array.length; i++, j++) {
            if (array[i] > array[j]) return false;
        }
        return true;
    }
}
