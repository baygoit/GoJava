<<<<<<< HEAD
public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();

        int triangleHeight = 9;
        pascalTriangle.createPascalTriangle(triangleHeight);
    }

    void createPascalTriangle(int triangleHeight) {
        int elementOfTriangle = 1;

        if (triangleHeight < 1) {
            System.out.println("cant build pascal triangle");
        } else {
            for (int i = 0; i < triangleHeight; i++) {
                System.out.print(elementOfTriangle);
                for (int j = 1; j <= i; j++) {
                    elementOfTriangle *= (i - j + 1);
                    elementOfTriangle /= j;
                    System.out.print(" " + elementOfTriangle);
                }
                System.out.println();
            }
        }
    }
}
=======
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
        }return triangle;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle(10);
        pascalTriangle.calculateTriangle();

    }

}



>>>>>>> d08f3677b031d65e6e49153e7af65334bd80fa65
