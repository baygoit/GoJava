package com.gojava6;

import javax.sound.midi.SysexMessage;

/**
 * Created by root on 18.09.15.
 */
public class IslandProblemResolving {

    int array[][];

    public IslandProblemResolving(int [][] arr) {
        this.array = arr;
    }

    public int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    count++;
                    merge(grid, i, j);      // merge and count our 2dim array
                }
            }
        }
        return count;
    }

    public static void merge(int[][] grid, int i, int j){
        //validity checking
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1)
            return;

        if(grid[i][j] != 1) return;   //if current cell is water or visited

        grid[i][j] = 0;               //set visited cell to '0'

        merge(grid, i-1, j);            //merge all adjacent land
        merge(grid, i+1, j);
        merge(grid, i, j-1);
        merge(grid, i, j+1);
    }
}
