package com.gojava6;


public class PascalTriangle {
    int level;
    public PascalTriangle(int level) {
        this.level=level;
    }

    public int[][] calculateTriangle() {
        int[][] result = new int[level][];
        for (int i=0; i<level; i++){
            result[i]=new int[i+1];
            for (int j=0;j<=i;j++){
                if ((j==0)||(j==i)) {//first & last
                    result[i][j] = 1;
                } else {
                    result[i][j]=result[i-1][j-1]+result[i-1][j];
                }
                //System.out.print("  " +result[i][j]);
            }
            //System.out.println();
        }
        return result;
    }
}
