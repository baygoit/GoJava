package com.gojava6;

public class PascalTriangle {
    private int level;
    public int[][] triangle;

    public PascalTriangle(int level) {
        this.level = level;
        triangle = new int[level][];
        for (int i = 0; i < level; i++ ) {
            triangle[i] = new int[i+1];
        }
        triangle[0][0] = 1;
    }

    private int pascal(int i, int j) {
        return (j == 0 || j == i) ? 1 : pascal(i - 1, j - 1) + pascal(i - 1, j);
    }

    public int[][] calculateTriangle() {
        for (int i = 1; i < level; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = pascal(i, j);
            }
        }
        return triangle;
    }
}
