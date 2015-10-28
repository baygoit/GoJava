package com.gojava6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IslandProblemResolvingTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[][]{
                        {1, 1, 0, 0, 1},
                        {1, 0, 0, 0, 0},
                        {0, 0, 1, 0, 1},
                        {1, 0, 0, 1, 1}},
                        5
                },
                {new int[][]{
                        {1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1}},
                        1
                },
                {new int[][]{
                        {1, 1, 1, 1, 1},
                        {1, 1, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {1, 0, 1, 1, 1}},
                        2
                }
        });
    }

    private int[][] islandMap;
    private int count;

    public IslandProblemResolvingTest(int[][] islandMap, int count) {
        this.islandMap = islandMap;
        this.count = count;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
        assertEquals(count, islandProblemResolving.countIslands());
    }
}