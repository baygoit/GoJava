import static org.junit.Assert.*;

import org.junit.Test;

public class LonelyNumberTest {

    @Test
    public void test() {
        assertEquals(1,
                LonelyNumber.lonelyNumber(new int[] { 1, 2, 3, 3, 2, 2, 3 }));
        assertEquals(
                7,
                LonelyNumber.lonelyNumber(new int[] { 2, 3, 2, 4, 3, 7, 2, 3,
                        4, 4 }));
        assertEquals(98,
                LonelyNumber.lonelyNumber(new int[] { 99, 99, 99, 98 }));
        assertEquals(1000000, LonelyNumber.lonelyNumber(new int[] { 1199, 1199,
                1199, 1000000 }));
    }

}
