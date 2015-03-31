import java.util.Scanner;

public class LonelyNumber {

    public static int lonelyNumber(int[] array) {
        int[][] binaryArray = new int[array.length][32];
        for (int i = 0; i < array.length; i++) {
            String binaryValue = Integer.toBinaryString(array[i]);
            for (int j = 0; j < binaryArray[i].length; j++) {
                int shift = binaryArray[i].length - binaryValue.length();
                if (j > shift)
                    binaryArray[i][j] = Integer.parseInt(binaryValue.substring(
                            j - shift, j - shift + 1));
            }
        }
        int[] binaryResult = new int[32];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < binaryArray[i].length; j++) {
                binaryResult[j] += binaryArray[i][j];
            }
        }
        for (int i = 0; i < binaryResult.length; i++) {
            binaryResult[i] = binaryResult[i] % 3;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < binaryResult.length; i++) {
            str.append(binaryResult[i]);
        }
        int result = Integer.parseInt(str.toString(), 2);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Insert your string of numbers separated by space:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        String[] arrIn = input.split(" ");
        int[] values = new int[arrIn.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(arrIn[i]);
        }
        System.out.println(lonelyNumber(values));

    }

}
