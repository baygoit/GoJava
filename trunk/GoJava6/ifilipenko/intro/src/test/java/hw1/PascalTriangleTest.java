package hw1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
     public void calculateTriangleWhenLevelIsPositiveNumber() {
        PascalTriangle pascalTriangle = new PascalTriangle(level);
        int[][] actual = pascalTriangle.calculateTriangle();
        Assert.assertArrayEquals(triangle, actual);
    }

    @Test
      public void calculateTriangleWhenLevelIsNegativeNumber() {
        PascalTriangle pascalTriangle = new PascalTriangle(-5);
        int[][] actual = pascalTriangle.calculateTriangle();
        Assert.assertArrayEquals(null, actual);
    }

    @Test
    public void calculateTriangleWhenLevelIsZero() {
        PascalTriangle pascalTriangle = new PascalTriangle(0);
        int[][] actual = pascalTriangle.calculateTriangle();
        int[][] expected = new int[0][0];
        Assert.assertArrayEquals(expected, actual);
    }

}
