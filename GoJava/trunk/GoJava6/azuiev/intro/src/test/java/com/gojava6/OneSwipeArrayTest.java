package com.gojava6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by sergiigetman on 9/22/15.
 */
@RunWith(Parameterized.class)
public class OneSwipeArrayTest {

    private OneSwipeArray oneSwipeArray;
    private boolean result;
    public int[] array;

    @Before
    public void setUp(){
        oneSwipeArray = new OneSwipeArray();

    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, new int[]{1, 5, 3, 3, 7}},
                {true, new int[]{1, 1, 1, 0, 7}},
                {true, new int[]{1, 5, 5, 3, 7}},
                {false, new int[]{1, 5, 3, 3, 0}},
                {true, new int[]{5, 1, 3, 3, 0}},
                {true, new int[]{1, 5, 3, 1, 7}},
                {false, new int[]{7, 5, 3, 3, 7}},
        });
    }



    public OneSwipeArrayTest(boolean input, int[] expected) {
        result = input;
        array = expected;
    }

    @Test
    public void test() {
        assertTrue(result==oneSwipeArray.solution(array));
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