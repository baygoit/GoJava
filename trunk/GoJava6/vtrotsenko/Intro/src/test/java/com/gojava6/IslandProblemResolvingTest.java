package com.gojava6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 18.09.15.
 */
public class IslandProblemResolvingTest {

    private int[][] islandMap;
    private int count;

    @Before
    public void setUp() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1},
        };
        count = 5;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving isP = new IslandProblemResolving(islandMap);
        assertEquals(count, isP.numIslands(islandMap));
    }
}