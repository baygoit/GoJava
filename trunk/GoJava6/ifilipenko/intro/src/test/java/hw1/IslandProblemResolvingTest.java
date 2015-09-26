package hw1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IslandProblemResolvingTest {
    private int[][] islandMap;
    private int count;

    @Before
    public void setUp() {
        islandMap = new int[][]{
                {1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1}
        };
        count = 5;
    }

    @Test
    public void testCountIslands() {
        IslandProblemResolving islandProblemResolving = new IslandProblemResolving();
        Assert.assertEquals(count, islandProblemResolving.countIslands(islandMap));
    }

}
