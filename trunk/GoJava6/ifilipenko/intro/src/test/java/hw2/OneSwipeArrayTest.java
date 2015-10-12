package hw2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class OneSwipeArrayTest {

    private OneSwipeArray oneSwipeArray;
    private int[] falseArray;
    private int[] trueArray;

    @Before
    public void setUp(){
        oneSwipeArray = new OneSwipeArray();
        trueArray = new int[]{1, 5, 3, 3, 7};
        falseArray = new int[]{1, 3, 5, 3, 4};
    }

    @Test
    public void testSolution() {
        Assert.assertTrue(oneSwipeArray.solution(trueArray));
    }

    @Test
    public void testSolutionTwo() {
        Assert.assertFalse(oneSwipeArray.solution(falseArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionNull() {
        oneSwipeArray.solution(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionLessThanTwo() {
        oneSwipeArray.solution(new int[1]);
    }

    @Test
    public void testInna() {
        Arrays.sort(trueArray);
        int[] expected = new int[]{1, 3, 3, 5, 7};
        Assert.assertEquals(Arrays.toString(trueArray), Arrays.toString(expected));

    }


}
