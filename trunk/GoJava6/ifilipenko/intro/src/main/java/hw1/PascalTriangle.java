package hw1;

public class PascalTriangle {

    private int level;

    public PascalTriangle(int level) {
        this.level = level;
    }

    public int[][] calculateTriangle() {

        int[][] triangle = new int[level][level];

        //triangle[1] = new int[1 + 2];
        triangle[0][0] = 1;
        triangle[1][0] = 1;
        triangle[1][1] = 1;

        for (int i = 2; i < triangle.length; i++) {
            triangle[i][0] = 1;
            for (int j = 1; j < triangle[i].length-2; j++) {
                triangle[i][j] = triangle[i-1][j] + triangle[i-1][j+1];
                triangle[i][triangle[i].length-1] = 1;
            }
        }

        return triangle;
    }

}
