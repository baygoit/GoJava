package Practice;

/**
 * Created by sergiigetman on 8/26/15.
 */
public class PascalTriangle {
    int level;

    public PascalTriangle(int level) {
        this.level=level;
    }

    public int[][] calculateTriangle() {
        //TODO: write you code here
        int[][] PascalTriangle = new int[level][];
        PascalTriangle[0] = new int [1];
        PascalTriangle[1] = new int [2];
        PascalTriangle[1][0] = PascalTriangle[0][0] =  PascalTriangle[1][1] = 1;

        for (int i = 2; i < level; i++)
        {
            PascalTriangle[i] = new int [i+1];
            PascalTriangle[i][0] = 1;
            for (int j = 1; j < i; j++)
            {
                PascalTriangle[i][j] = PascalTriangle[i-1][j-1] + PascalTriangle[i-1][j];
            }
            PascalTriangle[i][i]=1;
        }

        for (int i = 0; i < level; i++) {
            int[] array = PascalTriangle[i];
            System.out.println();
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j]);
            }
        }

        return PascalTriangle;
    }
}