package com.gojava6;

/**
 * Created by vshcherbak on 19/09/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {
    private int[][] islandMap;
    private int count;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }

    public boolean isIsland(int r, int c, int rowLength, int colLength, int[][] islandMap) {
        if (islandMap[r][c] == 1) {
            islandMap[r][c] = 0;

            if (r - 1 >= 0) isIsland(r - 1, c, rowLength, colLength, islandMap);
            if (r + 1 < rowLength) isIsland(r + 1, c, rowLength, colLength, islandMap);
            if (c - 1 >= 0) isIsland(r, c - 1, rowLength, colLength, islandMap);
            if (c + 1 < colLength) isIsland(r, c + 1, rowLength, colLength, islandMap);
            return true;
        }
        return false;
    }

    public int countIslands() {
        //TODO: write you code here
        int rowLength = islandMap.length;
        int colLength = islandMap[0].length;
        int total = 0;
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < colLength; c++) {
                if (isIsland(r, c, rowLength, colLength, islandMap)) {
                    total++;
                }
            }
        }
        return total;
    }
}
