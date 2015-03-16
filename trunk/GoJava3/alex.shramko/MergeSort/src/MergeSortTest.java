import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

    @Test
    public void test() {
        assertArrayEquals(new int[] { 2, 3, 4, 5, 6, 8, 8 },
                MergeSort.mergeSort(new int[] { 2, 5, 8, 4, 8, 6, 3 }));
        assertArrayEquals(new int[] { 1, 5, 10 },
                MergeSort.mergeSort(new int[] { 5, 10, 1 }));
        assertArrayEquals(new int[] { 1, 98, 99 },
                MergeSort.mergeSort(new int[] { 99, 98, 1 }));
    }

}
