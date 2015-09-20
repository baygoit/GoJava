package ua.goit.alg.lonelynum;

import org.junit.Assert;
import org.junit.Test;

public class TestLonelyNum {

    @Test
    public void testSearch() {
	int[] testArray = {3, 5, 7, 3, 5, 7, 8, 8, 8, 9, 9, 9, 3, 5, 7, 0};
	Assert.assertEquals(LonelyNumber.search(testArray), 0);
    }
}
