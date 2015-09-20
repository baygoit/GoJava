package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {
    private int[][] islandMap;
    private int heightArray;
    private int widthArray;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
        this.heightArray = islandMap.length;
        //this.widthArray = islandMap[0].length;
    }

    public int countIslands() {
        int count = 0;

        if (heightArray == 0 || widthArray == 0) {return 0;}

        for (int i = 0; i < heightArray; i++) {
            for (int j = 0; j < widthArray; j++) {
                if (islandMap[i][j] == 1) {
                    count += 1;
                    merge(islandMap, i, j);
                }
            }
        }
        return count;
    }

    public void merge(int[][] islandMap, int i, int j) {
        if (i < 0 || j < 0 || i > heightArray - 1 || j > widthArray - 1) {return;}
        if (islandMap[i][j] != 1) {return;}

        islandMap[i][j] = 0;
        merge(islandMap, i - 1, j);
        merge(islandMap, i + 1, j);
        merge(islandMap, i, j - 1);
        merge(islandMap, i, j + 1);
    }
}
