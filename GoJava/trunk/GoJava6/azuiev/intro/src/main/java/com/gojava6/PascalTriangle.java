package com.gojava6;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {
    int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {
        if (level < 1) {
            return null;
        }
        int result[][] = new int[level][];
        for (int i = 0; i <level; i++) {
            result[i]=new int[i+1];
            for (int j = 0; j < i+1; j++) {
                if ((j==0)||(i==j)) {
                    result[i][j]=1;
                } else {
                    result[i][j]=result[i-1][j-1]+result[i-1][j];
                }
            }
        }
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        return result;
    }

}
