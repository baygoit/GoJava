package com.gojava6;
import java.util.Random;

/**
 * Created by ярослав on 28.09.2015.
 */
public interface Island {
     boolean isIsland(int r, int c, int[][] islandMap);
     int countIslands();

   default void generate(int row, int col,int mass[][]){
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                Random rand = new Random();
                mass[i][k] = rand.nextInt(2);
            }
        }
    }
   default void showMass(int row, int col,int mass[][]){
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int k = 0; k < col; k++) {
                System.out.print(mass[i][k]);
            }
        }
    }
}

