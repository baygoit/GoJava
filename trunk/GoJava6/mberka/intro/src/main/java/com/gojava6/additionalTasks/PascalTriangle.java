package com.gojava6.additionalTasks;

public class PascalTriangle {

    private int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {

        int[][] example = new int[level][];
        example[0] = new int[1];
        example[0][0] = 1;
        example[1] = new int[2];
        example[1][0] = example[1][1] = 1;

        for (int i = 2; i < level; i++) {
            example[i] = new int[i + 1];
            example[i][0] = example[i][i] = 1;

            for (int j = 1; j < i; j++) {
                example[i][j] = example[i - 1][j - 1] + example[i - 1][j];
            }
        }
        return example;
    }
}
