package com.gojava6;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

/**
 * Created by sergiigetman on 9/15/15.
 */

@RunWith(Parameterized.class)
public class IslandProblemResolvingTest {
    private int[][] islandMap;
    private int count;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {4, new int[][] {{1, 1, 0, 0, 1},
                                {1, 0, 0, 0, 0},
                                {0, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1}}},
                {6, new int[][] {{0, 1, 0, 0, 1},
                                {1, 0, 0, 0, 0},
                                {0, 0, 1, 0, 1},
                                {1, 0, 0, 1, 1}}},
                {1, new int[][] {{1, 1, 1, 1, 1},
                                {1, 1, 1, 1, 1},
                                {0, 1, 0, 1, 0},
                                {1, 1, 0, 1, 1}}},
                {2, new int[][] {{1, 1, 0, 0, 1},
                                {1, 0, 0, 0, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 1, 1, 1}}},
        });
    }

    public IslandProblemResolvingTest(int count, int[][] islandMap) {
        this.count = count;
        this.islandMap = islandMap;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
}