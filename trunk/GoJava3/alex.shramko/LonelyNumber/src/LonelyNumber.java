import java.util.Scanner;

public class LonelyNumber {

  public static int lonelyNumber(int[] array) {
    int[] resultArray = new int[32];
    String result = "";
    for (int i : array) {
      int mask = 1;
      for (int j = 0; j < 32; j++) {
        if ((i & mask) == mask) {
          resultArray[j]++;
        }
        mask <<= 1;
      }
    }
    for (int i = 0; i < 32; i++) {
      if (resultArray[i] % 3 == 0) {
        result += 0;
      } else {
        result += 1;
      }
    }
    result = new StringBuffer(result).reverse().toString();
    return Integer.parseInt(result, 2);
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
