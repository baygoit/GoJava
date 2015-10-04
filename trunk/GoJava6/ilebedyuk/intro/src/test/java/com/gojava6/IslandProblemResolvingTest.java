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
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1}
        };
        count = 5;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionNull() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionHeightWidthNull() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(new int[0][0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionMerge() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        islandProblemResolving.merge(islandMap, -1, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolutionMergeTest() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        islandProblemResolving.merge(islandMap, 0, 3);
    }
}