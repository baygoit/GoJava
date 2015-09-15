package com.gojava6;

/**
 * Created by Dmitry Onishchenko on 9/15/15.
 */
public class PascalTriangle {
	private int level;
	
    public PascalTriangle(int level) {
    	this.level = level;
    }

    public int[][] calculateTriangle() {
        int[][] result = new int[level][];

        for (int i = 0, count = 1; i < level; i++, count++) {
        	result[i] = new int[count];
        }
        
        for (int row = 0; row < level; row++) {
        	result[row][0] = 1;
        	result[row][row] = 1;
        	
        	for (int col = 1; col < row; col++) {
        		result[row][col] = result[row-1][col-1] + result[row-1][col];
        	}
        }
    	
        return result;
    }
    
    /**
     * Test main
     * @param args
     */
    public static void main(String[] args) {
    	PascalTriangle pascalTriangle = new PascalTriangle(10);
    	pascalTriangle.calculateTriangle();
    }
}