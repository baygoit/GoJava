package com.gojava6;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class IslandProblemResolvingTest {
    private int[][] islandMap;
    private int count;

    @Test
    public void testCountIslandsWithFiveIslands() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1}
        };
        count = 5;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
    @Test
    public void testCountIslandsWithOneIslands() {
        islandMap = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        };
        count = 1;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
    @Test
    public void testCountIslandsWithFifteenIslands() {
        islandMap = new int[][]{
                {0, 0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 1}
        };
        count = 15;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
    @Test
    public void testCountIslandsWithTenIslands() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}
        };
        count = 10;
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
}