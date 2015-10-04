package com.gojava6;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {

    int level;
    int[][] Pas = new int[level][];


    public PascalTriangle(int Level) {
        level = Level;
    }

    public int[][] calculateTriangle() {
        int[][] Pas = new int[level][];
        for (int i = 0; i < level; i++) {
            Pas[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                if (j==0||j==i) {
                    Pas[i][j] = 1;
                } else {
                    Pas[i][j] = Pas[i - 1][j] + Pas[i - 1][j-1];
                }
            }
        }
        return Pas;
    }

}
