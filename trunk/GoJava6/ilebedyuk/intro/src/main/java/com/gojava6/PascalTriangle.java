package com.gojava6;

/**
 * Created by ilebedyuk on 9/19/15.
 */
public class PascalTriangle {
    private int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {
        int[][] array = new int[level][];

        array[0] = new int[1];
        array[1] = new int[2];

        array[0][0] = 1;
        array[1][0] = 1;
        array[1][1] = 1;

        for (int i = 2; i < level; i++) {
            array[i] = new int[i+1];
            array[i][0] = 1;
            for (int j = 1; j < i; j++) {
                array[i][j] = array[i - 1][j] + array[i - 1][j - 1];
            }
            array[i][i] = 1;
        }
        return array;
    }
}
