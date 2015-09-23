package hw1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

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
        pascalTriangle.calculateTriangle();
       /* System.out.println(triangle[0].length);
        System.out.println(pascalTriangle.calculateTriangle()[0].length);*/
        Assert.assertArrayEquals(triangle, pascalTriangle.calculateTriangle());
    }

    @Ignore
    @Test
    public void innaTest(){
        System.out.println(triangle.length);
        System.out.println(triangle[level-1].length);

    }
}
