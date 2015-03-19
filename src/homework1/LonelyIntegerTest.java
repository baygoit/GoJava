package homework1;

import junit.framework.TestCase;

public class LonelyIntegerTest extends TestCase{

    public void test1() {
        assertEquals(4, LonelyInteger.findLonelyInteger(new int[]{1, 1, 1, 3, 3, 3, 4}));
    }

    public void test2() {
        assertEquals(13, LonelyInteger.findLonelyInteger(new int[] {1, 1, 1, 13, 3, 3, 3, 100, 100, 100}));
    }

    public void test3() {
        assertEquals(1256, LonelyInteger.findLonelyInteger(new int[] {1, 1, 1, 1256, 3, 3, 3, 100, 100, 100}));
    }
}