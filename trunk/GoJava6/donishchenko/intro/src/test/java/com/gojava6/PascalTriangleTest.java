package com.gojava6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class PascalTriangleTest {
    @Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                {new int[][]{
                        {1},
                        {1, 1},
                        {1, 2, 1},
                        {1, 3, 3, 1},
                        {1, 4, 6, 4, 1}},
                        5
                },
                {new int[][]{
                        {1},
                        {1, 1},
                        {1, 2, 1},
                        {1, 3, 3, 1},
                        {1, 4, 6, 4, 1},
                        {1, 5, 10, 10, 5, 1}},
                        6
                }
        });
    }

    private int[][] triangle;
    private int level;

    public PascalTriangleTest(int[][] triangle, int level) {
        this.triangle = triangle;
        this.level = level;
    }

    @Test
    public void testCalculateTriangle() {
        PascalTriangle pascalTriangle = new PascalTriangle(level);
        assertArrayEquals(triangle, pascalTriangle.calculateTriangle());
    }
}