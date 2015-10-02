package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, 1s set making one island
 */
public class IslandProblemResolving {
    int [][] islandMap;
    int islandCount = 0;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }


        public int countIslands() {
        for (int i = 0; i < islandMap.length; i++) {
            for (int j = 0; j < islandMap[0].length; j++) {
                if (islandMap[i][j] == 1) {
                    checkoutIsland(islandMap, i, j);
                    islandCount++;
                }
            }
        }
            for (int i = 0; i < islandMap.length; i++) {
                for (int j = 0; j < islandMap[0].length; j++) {
                    if (islandMap[i][j]==-1) {
                        islandMap[i][j] = 1;
                    }
                }
            }
                    return islandCount;
    }

    public void checkDown(int[][] box, int x, int y) {
        if (islandMap[x][y + 1] == 1) {
            box[x][y + 1] = -1;
            checkoutIsland(box, x, y + 1);
        }return;
    }
    public void checkRight(int[][] box, int x, int y) {
        if (islandMap[x + 1][y] == 1) {
            box[x + 1][y] = -1;
            checkoutIsland(box, x + 1, y);
        }return;
    }
    public void checkTop(int[][] box, int x, int y) {
        if (islandMap[x][y - 1] == 1) {
            box[x][y - 1] = -1;
            checkoutIsland(box, x, y - 1);
        }return;
    }
    private void checkoutIsland(int[][] map, int i, int j) {
        if (i != map.length-1) {checkRight(map,i,j);}
        if (j != map[0].length-1) {checkDown(map,i,j);}
        if (j != 0) {checkTop(map,i,j);}
    }
}
