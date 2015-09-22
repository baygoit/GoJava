package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {

    private int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }

    public int countIslands() {
        return horizontalIslandsCount() + verticalIslandsCount() + diagonalIslandsCount();
    }

    private int horizontalIslandsCount() {
        int[][] map = this.islandMap;
        int count = 0;

        for (int i = 0; i < islandMap.length; i++) {
            for (int k = 0; k < islandMap[i].length - 1; k++) {
                if (k == 0) {
                    if ((islandMap[i][k] == 1) && (islandMap[i][k + 1] == 1)) {
                        count++;
                    }
                }
                else {
                    if ((islandMap[i][k] == 1) && (islandMap[i][k + 1] == 1) && (islandMap[i][k - 1] != 1)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int verticalIslandsCount() {
        int[][] map = this.islandMap;
        int count = 0;

        for (int k = 0; k < islandMap[0].length; k++) {
            for (int i = 0; i < islandMap.length - 1; i++) {
                if (i == 0) {
                    if ((islandMap[i][k] == 1) && (islandMap[i + 1][k] == 1)) {
                        count++;
                    }
                }
                else {
                    if ((islandMap[i][k] == 1) && (islandMap[i + 1][k] == 1) && (islandMap[i - 1][k] != 1)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int diagonalIslandsCount() {
        int[][] map = this.islandMap;
        int count = 0;

        for (int i = 0; i < islandMap.length - 1; i++) {
            for (int k = 0; k < islandMap[i].length - 1; k++) {
                if ((i == 0) || (k == 0)) {
                    if ((islandMap[i][k] == 1) && (islandMap[i + 1][k + 1] == 1)) {
                        count++;
                    }
                }
                else {
                    if ((islandMap[i][k] == 1) && (islandMap[i + 1][k + 1] == 1) && (islandMap[i - 1][k - 1] != 1)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
