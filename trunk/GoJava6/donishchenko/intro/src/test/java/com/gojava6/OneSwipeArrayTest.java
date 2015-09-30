package com.gojava6;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OneSwipeArrayTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 5, 3, 3, 7}, new int[]{1, 7, 3, 6, 4}},
                {new int[]{1, 5, 3, 3, 3}, new int[]{1, 6, 2, 5, 12}},
                {new int[]{1, 7, 3, 6, 3}, new int[]{1, 6, 2, 5, 12}}
        });
    }

    private static OneSwipeArray oneSwipeArray;
    private int[] trueArray;
    private int[] falseArray;

    public OneSwipeArrayTest(int[] trueArray, int[] falseArray) {
        this.trueArray = trueArray;
        this.falseArray = falseArray;
    }

    @BeforeClass
    public static void setUp() {
        oneSwipeArray = new OneSwipeArray();
    }

    @Test
    public void testSolutionTrue() {
        assertTrue(oneSwipeArray.solution(trueArray));
    }

    @Test
    public void testSolutionFalse() {
        assertFalse(oneSwipeArray.solution(falseArray));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionNull() {
        oneSwipeArray.solution(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionLessThanTwo() {
        oneSwipeArray.solution(new int[1]);
    }
}