package com.gojava6;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {
    private int level;
    private int triangle[][];

        public PascalTriangle(int level) {

            this.level = level;
            this.calculateTriangle();
        }

    public void show(){
        for (int n = 0; n < level; n++) {
            for (int k = 0; k <= n; k++) {
                System.out.print(triangle[n][k] + " ");
            }
            System.out.println();
        }
    }

    public int[][] calculateTriangle() {
        triangle = new int[level][level+1];
        for (int n = 0; n < level; n++) {
            triangle[n][0] = triangle[n][n] = 1;
            for (int k = 1; k <= n; k++) {
                triangle[n][k] = triangle[n-1][k-1] + triangle[n-1][k];
            }
        }
        return null;
    }

}
