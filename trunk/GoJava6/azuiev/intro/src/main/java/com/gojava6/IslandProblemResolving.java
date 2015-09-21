package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {
    int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }


    public int countIslands() {
        if (islandMap == null)
            return 0;
        int height = islandMap.length;
        if (height == 0)
            return 0;
        int width = islandMap[0].length;
        if (width == 0)
            return 0;

        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (islandMap[i][j]==1){
                    count++;
                    removeIsland(islandMap,i,j);
                }
            }

        }
        return count;
    }

    private void removeIsland(int[][] islandMap, int i, int j) {
        System.out.println(i+ " " + j);
        islandMap[i][j]=0;
        if ((j>0) && islandMap[i][j-1]==1){
            removeIsland(islandMap,i,j-1);
        }
        if ((j<islandMap[0].length-1) && islandMap[i][j+1]==1){
            removeIsland(islandMap,i,j+1);
        }
        if ((i<islandMap.length-1) && islandMap[i+1][j]==1){
            removeIsland(islandMap,i+1,j);
        }
<<<<<<< HEAD

        if ((i>0) && islandMap[i-1][j]==1){
            removeIsland(islandMap,i-1,j);
        }


=======
        if ((i>0) && islandMap[i-1][j]==1){
            removeIsland(islandMap,i-1,j);
        }
>>>>>>> b406adcc396a7505479ad772bb83478ed6740c5d
    }


}
