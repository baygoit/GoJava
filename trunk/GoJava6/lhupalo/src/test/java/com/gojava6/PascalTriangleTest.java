package com.gojava6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by L.Hupalo
 */
public class PascalTriangleTest {
    private int level;
    private int[][] triangle;

    @Before
    public void setUp() {
       int level ;

    }




    @Test
    public void testCalculateTriangle() {
        int level =5;

        int[][] triangle = {
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1}};
        PascalTriangle pascalTriangle = new PascalTriangle(level);
        assertArrayEquals(triangle, pascalTriangle.calculateTriangle());
    }


    @Test
    public void testCalculateTriangle2() {
        int level =4;

        int[][] triangle = {
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1} };


        PascalTriangle pascalTriangle = new PascalTriangle(level);
        assertArrayEquals(triangle, pascalTriangle.calculateTriangle());
    }
}