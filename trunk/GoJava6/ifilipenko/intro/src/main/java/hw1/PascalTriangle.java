package hw1;

public class PascalTriangle {

    private int level;

    public PascalTriangle(int level) {
    this.level = level;
    }

    public int[][] calculateTriangle() {

        int[][] triangle = new int[level][level];

        for (int row = 0; row < level; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || row == col) {
                    triangle[row][col] = 1;
                } else{
                    triangle[row][col] = triangle[row-1][col-1] + triangle[row-1][col];
                }
            }
        }

/*        for (int i = 0; i < level; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }*/

        return triangle;

    }
}
