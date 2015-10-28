package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {

    int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap1) {
        islandMap = islandMap1;
    }

    public void testIsland(int[][] Map, int i, int j) {
        if (i == 0) {
        } else {
            if (Map[i - 1][j] == 1) {
                Map[i - 1][j] = 0;
                testIsland(Map, i - 1, j);
            }
        }
        if (i == Map.length-1) {
        } else {
            if (Map[i + 1][j] == 1) {
                Map[i + 1][j] = 0;
                testIsland(Map, i + 1, j);
            }
        }
        if (j == Map[0].length-1) {
        } else {
            if (Map[i][j + 1] == 1) {
                Map[i][j + 1] = 0;
                testIsland(Map, i, j + 1);
            }
        }
        if (j == 0) {
        } else {
            if (Map[i][j - 1] == 1) {
                Map[i][j - 1] = 0;
                testIsland(Map, i, j - 1);
            }
        }
    }

    public int countIslands() {
        int IslandCount = 0;
        for (int i = 0; i < islandMap.length; i++) {
            for (int j = 0; j < islandMap[0].length; j++) {
                if (islandMap[i][j] == 1) {
                    testIsland(islandMap, i, j);
                    IslandCount++;
                }
            }
        }
        //TODO: write you code here
        return IslandCount;
    }

}
