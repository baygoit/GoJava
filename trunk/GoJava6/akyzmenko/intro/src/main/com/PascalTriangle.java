package com;


public class PascalTriangle {
    private int level;



    public PascalTriangle(int level) {
        this.level = level;

    }

    public int[][] calculateTriangle() {
        if (level >= 33) {
            throw new RuntimeException("Data overflow");
        }
        if(level<1){
            return null;
        }
        int [][] pascalTriangle = new int[level][];

        for (int i=0; i<pascalTriangle.length; i++) {
            pascalTriangle[i] = new int[i+1];
            pascalTriangle[i][0] = 1;
            pascalTriangle[i][i] = 1;
            for (int j=1; j<i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i-1][j]+pascalTriangle[i-1][j-1];
            }
        }
        return pascalTriangle;
    }
}
