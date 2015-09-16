package com.gojava6;


public class PascalTriangle {
    private int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {
        int[][] triangle = new int[level + 1][(level + 1) *2];
        int leftOne, rightOne;

        triangle[0][level - 1] = 1;
        leftOne = rightOne = level - 1;

        for (int i = 1; i < level; i++) {
            leftOne--;
            rightOne++;
            triangle[i][leftOne] = 1;
            triangle[i][rightOne] = 1;

            for (int j = 1; j <= i; j++) {
                int left = triangle[i - 1][leftOne + (2 * j) - 1];
                int right = triangle[i - 1][leftOne + (2 * j) + 1];
                triangle[i][leftOne + (2 * j)] = left + right;
            }
        }return null;
    }


    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle(10);
        pascalTriangle.calculateTriangle();

    }
}



