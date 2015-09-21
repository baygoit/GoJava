package com.gojava6;

public class IslandProblemResolving2 {

    private int[][] islandMap;

    public IslandProblemResolving2(int[][] islandMap) {
        this.islandMap = islandMap;
    }

    public int countIslands() {
        int count = 0;
        int[][] map = islandMap;

        for (int i = 0; i < map.length; i++) {
            for (int k = 0; k < map[i].length; k++) {
                if (map[i][k] == 1) {
                    count++;
                    map = updatedMap(map, i, k);
                }
            }
        }
        return count;
    }

    private int[][] updatedMap(int[][] map, int i, int k) {
        map[i][k] = 0;

        if (k != map[i].length - 1) {
            if (map[i][k + 1] == 1) {
                updatedMap(map, i, k + 1);
            }
        }
        if (i != map.length - 1) {
            if (map[i + 1][k] == 1) {
                updatedMap(map, i + 1, k);
            }
        }
        if (k != 0) {
            if (map[i][k - 1] == 1) {
                updatedMap(map, i, k - 1);
            }
        }
        if (i != 0) {
            if (map[i - 1][k] == 1) {
                updatedMap(map, i - 1, k);
            }
        }
        return map;
    }
}
