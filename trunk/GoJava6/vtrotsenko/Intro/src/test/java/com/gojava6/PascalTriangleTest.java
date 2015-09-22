package com.gojava6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by root on 18.09.15.
 */
public class PascalTriangleTest {

    private int level;
    private int[][] triangle;

    @Before
    public void setUp() {
        level = 7;
        triangle = new int[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1},
                {1, 5, 10, 10, 5, 1},
                {1, 6, 15, 20, 15, 6, 1}};
    }

    @Test
    public void testCalculateTriangle() {
        PascalTriangle pTriangle = new PascalTriangle(level);
        assertArrayEquals(triangle, pTriangle.calculateTriangle());
    }

}