package com.gojava6;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {
    private int level;
    private long C[][];

        public PascalTriangle(int level) {
            if(level > 66){
                throw new RuntimeException("Data overflow");
            }

            this.level = level;

        }

    public void show(){
        for (int n = 0; n <= level; n++) {
            for (int k = 0; k <= n; k++) {
                System.out.print(C[n][k] + " ");
            }
            System.out.println();
        }
    }

    public int[][] calculateTriangle() {
        C = new long[level+1][level+1];
        for (int n = 0; n <= level; n++) {
            C[n][0] = C[n][n] = 1;
            for (int k = 1; k < n; k++) {
                C[n][k] = C[n-1][k-1] + C[n-1][k];
            }
        }
        return null;
    }

}
