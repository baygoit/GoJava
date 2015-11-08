package com.gojava6;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {

    public int[][] calculateTriangle(int level) {
        if (level < 1) {
            return null;
        }
        int triangle[][] = new int[level][];
        for (int i = 0; i < level; i++) {

            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {

                if ((j == 0) || (i == j)) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }

        }
        return triangle;
    }

    void showMass(int mass[][]) {

        for (int i = 0; i < mass.length; i++) {
            System.out.println();
            for (int k = 0; k < mass[i].length; k++) {
                System.out.print(mass[i][k]);
            }
        }
    }


}
