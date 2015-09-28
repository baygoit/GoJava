package com.gojava6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by slavik now
 */
public class PascalTriangleTest {
    private int level;
    private int[][] triangle;

    @Before
    public void setUp() {
        level = 5;
        triangle = new int[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1}};
    }

    @Test
    public void testCalculateTriangle() {
        PascalTriangle pascalTriangle = new PascalTriangle(level);
        assertArrayEquals(triangle, pascalTriangle.calculateTriangle());
    }
    @Test
    public void testCalculateTriangle1() {
        level = 1;
        triangle = new int[][]{ {1} };

        PascalTriangle pascalTriangle = new PascalTriangle(level);
        assertArrayEquals(triangle, pascalTriangle.calculateTriangle());
    }
}
