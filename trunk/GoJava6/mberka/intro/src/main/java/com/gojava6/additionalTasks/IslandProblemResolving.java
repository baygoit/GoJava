package com.gojava6.additionalTasks;

/**
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */

public class IslandProblemResolving {

    private int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }

    public int countIslands() {
        int count = 0;

        if (islandMap == null || islandMap.length == 0 || islandMap[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < islandMap.length; i++) {
            for (int j = 0; j < islandMap[0].length; j++) {
                if (islandMap[i][j] == 1) {
                    joinIslands(islandMap, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void joinIslands(int[][] islandMap, int i, int j) {
        if (i < 0 || j < 0 || i > islandMap.length - 1 || j > islandMap[0].length - 1) {
            return;
        }
        if (islandMap[i][j] != 1) {
            return;
        }
        islandMap[i][j] = 0;
        joinIslands(islandMap, i - 1, j);
        joinIslands(islandMap, i + 1, j);
        joinIslands(islandMap, i, j - 1);
        joinIslands(islandMap, i, j + 1);
    }
}
