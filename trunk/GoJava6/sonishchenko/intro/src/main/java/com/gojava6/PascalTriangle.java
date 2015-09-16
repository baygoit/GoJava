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