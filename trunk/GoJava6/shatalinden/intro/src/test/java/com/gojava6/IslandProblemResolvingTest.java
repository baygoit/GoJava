package com.gojava6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sergiigetman on 9/15/15.
 */
public class IslandProblemResolvingTest {
    private int[][] islandMap;
    private int count;

    @Before
    public void setUp() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        count = 3;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
}