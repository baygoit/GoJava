package hw2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OneSwipeArrayTest {

    private OneSwipeArray oneSwipeArray;
    private int[] falseArray;
    private int[] trueArray;
    private int[] sortedArray;

    @Before
    public void setUp(){
        oneSwipeArray = new OneSwipeArray();
        trueArray = new int[]{1, 5, 3, 3, 7};
        falseArray = new int[]{1, 3, 5, 3, 4};
        sortedArray = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void verifyResultIsTrueIfOneSwapNeededToSortArray() {
        Assert.assertTrue(oneSwipeArray.solution(trueArray));
    }

    @Test
    public void verifyResultIsFalseIfAlreadySortedArray() {
        Assert.assertFalse(oneSwipeArray.solution(sortedArray));
    }

    @Test
    public void verifyResultIsFalseIfMoreThanOneSwapNeededToSortArray() {
        Assert.assertFalse(oneSwipeArray.solution(falseArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyResultIsErrorIfInputIsNull() {
        oneSwipeArray.solution(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void verifyResultIsErrorIfInputArrayLengthIsLessThan2() {
        oneSwipeArray.solution(new int[1]);
    }
}
