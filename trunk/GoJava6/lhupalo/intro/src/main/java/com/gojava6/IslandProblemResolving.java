package com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {
    int[][] islandMap;




    public IslandProblemResolving(int[][] islandMap) {

        this.islandMap =islandMap;
    }

    private void checkAnotherPartsOfIslandFromPoint(int i, int j, boolean[][] checkMap){
        checkMap[i][j]=true;
        if ((i!=0)&&(islandMap[i-1][j]==1)&&(checkMap[i-1][j]!=true)) {
            checkAnotherPartsOfIslandFromPoint(i-1,j,checkMap);
        }
        if ((j!=0)&&(islandMap[i][j-1]==1)&&(checkMap[i][j-1]!=true)) {
            checkAnotherPartsOfIslandFromPoint(i,j-1,checkMap);
        }
        if ((i!= islandMap.length-1)&&(islandMap[i+1][j]==1)&&(checkMap[i+1][j]!=true)) {
            checkAnotherPartsOfIslandFromPoint(i+1,j,checkMap);
        }
        if ((j!= islandMap[0].length-1)&&(islandMap[i][j+1]==1)&&(checkMap[i][j+1]!=true)) {
            checkAnotherPartsOfIslandFromPoint(i,j+1,checkMap);
        }
    }

    public int countIslands() {
        boolean[][] checkedMap= new boolean[islandMap.length][islandMap[0].length];
        int count=0;
        //Search for island
        for (int i = 0; i< islandMap.length; i++){
            for (int j = 0; j< islandMap[i].length;j++) {
                if ((checkedMap[i][j] != true) && (islandMap[i][j] == 1)) {
                    //found new island
                    count++;


                    checkAnotherPartsOfIslandFromPoint(i, j, checkedMap);
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
