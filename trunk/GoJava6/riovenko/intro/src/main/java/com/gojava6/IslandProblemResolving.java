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
        //TODO: write you code here
        if (islandMap==null || islandMap.length==0 || islandMap[0].length==0) return 0;
        int count = 0;

        for (int i=0; i<islandMap.length; i++) {
            for (int j=0; j<islandMap[0].length; j++) {
                if(islandMap[i][j] == 1){
                    count++;
                    merge(islandMap, i, j);
                }
            }
        }
        System.out.print (count);
        return count;
    }
    public void merge(int[][] islandMap, int i, int j){
        if(i<0 || j<0 || i>islandMap.length-1 || j>islandMap[0].length-1)
            return;

        if(islandMap[i][j] != 1) return;

        islandMap[i][j] = 0;
        merge(islandMap, i-1, j);
        merge(islandMap, i+1, j);
        merge(islandMap, i, j-1);
        merge(islandMap, i, j+1);
    }

}
