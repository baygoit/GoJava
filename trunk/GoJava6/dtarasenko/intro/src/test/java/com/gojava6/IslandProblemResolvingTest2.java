package com.gojava6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class IslandProblemResolvingTest2 {
    private int[][] islandMap;
    private int count;

    @Before
    public void setUp() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1}
        };
        count = 6;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving2 islandProblemResolving2 = new IslandProblemResolving2(islandMap);
        assertEquals(count, islandProblemResolving2.countIslands());
    }
}