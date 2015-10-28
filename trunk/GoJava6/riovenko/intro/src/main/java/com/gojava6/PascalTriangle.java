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
        //TODO: write you code here
        int[][] PascalTriangle =new int[level][level];

        for (int i = 0; i < level; i++) {
            int number  = 1;
            for (int j = 0; j <= i; j++) {
                PascalTriangle[i][j] = number;
                System.out.printf("    " + PascalTriangle[i][j]);
                number=number * (i - j) / (j + 1);
            }
            System.out.println("");
        }
        return PascalTriangle;
    }

}
