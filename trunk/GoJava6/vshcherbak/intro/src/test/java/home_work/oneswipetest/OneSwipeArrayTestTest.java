package home_work.oneswipetest;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class OneSwipeArrayTestTest {
    private int[] array;

    @Before
    public void setUp() {
        array = new int[] {2, 3, 4, 6, 7, 5, 8, 9};
    }

    @Test
    public void testMyList() {
        OneSwipeArrayTest test = new OneSwipeArrayTest(array);
        assertFalse(test.test());
    }
    @Test
    public void testMyList1() {
        array = new int[] {2, 3, 4, 6, 7, 6, 8, 9};
        OneSwipeArrayTest test = new OneSwipeArrayTest(array);
        assertTrue(test.test());
    }
    @Test
    public void testMyList3() {
        array = new int[] {1, 2, 4, 3, 2};
        OneSwipeArrayTest test = new OneSwipeArrayTest(array);
        assertTrue(test.test());
    }@Test
    public void testMyList4() {
        array = new int[] {1, 2, 5, 7, 2};
        OneSwipeArrayTest test = new OneSwipeArrayTest(array);
        assertFalse(test.test());
    }
}
