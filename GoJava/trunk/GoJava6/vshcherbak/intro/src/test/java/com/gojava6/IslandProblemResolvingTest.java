package com.gojava6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by slavik now.
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
    @Test
    public void testCountIslands1() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1},
                {1, 0, 1, 0, 1}
        };
        count = 6;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
    @Test
    public void testCountIslands2() {
        islandMap = new int[][]{
                {1}
        };
        count = 1;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
    @Test
    public void testCountIslands4() {
        islandMap = new int[][]{
                {0, 0},
                {0, 0}
        };
        count = 0;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
}
