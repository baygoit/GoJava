package hw1;

public class PascalTriangle {

    private int level;

    public PascalTriangle(int level) {
        if (level < 0) {
            throw new IllegalArgumentException("Level is less than 0!");
        } else if (level == Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        } else {
            this.level = level;
        }
    }

    public int[][] calculateTriangle() {
        int[][] triangle = new int[level][];
        for (int row = 0; row < triangle.length; row++) {
            triangle[row] = new int[row + 1];
            triangle[row][0] = 1; // first number in a row
            triangle[row][row] = 1; // last number in a row
            for (int col = 1; col < row; col++) {
                triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col];
            }
        }
        return triangle;
    }

    public void print(int[][] triangle) {
        for (int row = 0; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                System.out.print(" " + triangle[row][col]);
            }
            System.out.println("");
        }
    }

}
