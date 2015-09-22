package com.gojava6;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {

    private int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {
        int[][] triangleArray = new int[this.level][];
        for (int i = 0; i < triangleArray.length; i++) {
            triangleArray[i] = new int[i + 1];
        }
        for (int i = 0; i < triangleArray.length; i++) {
            for (int k = 0; k < triangleArray[i].length; k++) {
                triangleArray[i][k] = 1;
                if ((i > 1) && (k > 0) && (k < triangleArray[i].length - 1)) {
                    triangleArray[i][k] = triangleArray[i - 1][k - 1] + triangleArray[i - 1][k];
                }
            }
        }
        return triangleArray;
    }
}
