package com;


public class IslandProblemResolving {

    public IslandProblemResolving(int[][] islandMap) {
    }


    public int countIslands(int islandMap[][]) {
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
        return count;   //TODO: write you code here

    }

    public void merge(int [][] islandMap, int i, int j){

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
