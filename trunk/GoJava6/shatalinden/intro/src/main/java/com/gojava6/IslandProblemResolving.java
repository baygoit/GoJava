package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {

    int[][] islandMap;
    int count = 0;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }


    public int countIslands() {
        //TODO: write you code here
        if(islandMap == null) return 0;

        else {
            for (int i = 0; i < islandMap.length; i++) {
                for (int j = 0; j < islandMap[0].length; j++) {
                    if (islandMap[i][j] == 1) {
                        count++;
                        deleteIsland(islandMap, i, j);
                    }
                }
            }
        }
        return count;
    }

    private void goForward(int[][] islandMap, int i, int j) {
        if(i<islandMap.length-1&&islandMap[i+1][j]==1) deleteIsland(islandMap, i + 1, j);
        if(j<islandMap[0].length-1&&islandMap[i][j+1]==1) deleteIsland(islandMap, i, j + 1);
    }

    private void goBack(int[][] islandMap, int i, int j) {
        if(i>0&&islandMap[i-1][j]==1) deleteIsland(islandMap, i - 1, j);
        if(j>0&&islandMap[i][j-1]==1) deleteIsland(islandMap, i, j - 1);
    }

    private void deleteIsland(int[][] islandMap, int i, int j) {
        islandMap[i][j] = 0;
        System.out.println("i: " + i + ", j: " + j + ", count: " + count);
        goBack(islandMap, i, j);
        goForward(islandMap, i, j);
    }
}
