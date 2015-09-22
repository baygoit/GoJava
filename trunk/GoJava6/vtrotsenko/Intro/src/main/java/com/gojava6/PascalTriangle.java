package com.gojava6;

import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by root on 18.09.15.
 */
public class PascalTriangle {

    int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {
        if (level < 1) {
            return null;
        }
        int triangle[][] = new int[level][];    // create result triangle array with number of rows = level
        for (int i = 0; i < level; i++) {

            triangle[i] = new int[i+1];         // increase dimension of array in next row
            for (int j = 0; j < i+1; j++) {

                if ((j == 0) || (i == j)) {
                    triangle[i][j] = 1;         // initialize every first number with 1
                } else {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];   // val = uperLeft + uperRight
                }
            }
        }
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j]);
            }
            System.out.println();
        }
        return triangle;
    }

}