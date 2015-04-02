import java.util.Scanner;

public class LonelyNumber {

  public static int lonelyNumber(int[] array) {
    final int decimalCapasity = 32;
    int[] resultArray = new int[decimalCapasity];
    for (int i : array) {
      int mask = 1;
      for (int j = 0; j < decimalCapasity; j++) {
        if ((i & mask) == mask) {
          resultArray[j]++;
        }
        mask <<= 1;
      }
    }
    int result = 0;
    for (int i = 0; i < decimalCapasity; i++) {
      if (resultArray[i] % 3 != 0) {
        result += Math.pow(2, i);
      } else {
        //do nothing
      }
    }
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
