package com.gojava6;

import Practice.PascalTriangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sergiigetman on 9/15/15.
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
}