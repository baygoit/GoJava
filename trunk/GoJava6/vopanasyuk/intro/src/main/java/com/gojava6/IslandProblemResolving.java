package com.gojava6;


public class IslandProblemResolving {

    int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }


    public int countIslands() {
        int quantity = 0;
        int height = islandMap.length;
        int width = islandMap[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (islandMap[i][j] == 1) {
                    quantity++;
                }
                if (j > 0 && i > 0 && islandMap[i - 1][j - 1] == 1) {
                    quantity--;
                }
            }
        }


        return quantity;
    }

}

