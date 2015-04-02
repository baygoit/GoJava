package binary;

public class LonelyNumber {
  static int[] intArray = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4};
  static int lonelyNumber;

  public static void main(String[] args) {
    System.out.println("Array of integers:");
    printArray(intArray);
    lonelyNumber = findLonelyNumber(intArray);
    System.out.println("Lonely number: " + lonelyNumber);
  }

  private static int findLonelyNumber(int[] intArray) {
    int[] sum = new int[Integer.SIZE];
    int mask;
    int rez;

    for (int i = 0; i < intArray.length; i++) {
      mask = 1;
      for (int j = Integer.SIZE - 1; j >= 0; j--) {
        int bit = intArray[i] & mask;
        if (bit != 0) {
          sum[j] = sum[j] + 1;
        }
        mask = mask << 1;
      }
    }

    rez = 0;
    for (int i = 0; i < Integer.SIZE; i++) {
      rez = rez << 1;
      rez = rez + (sum[i] % 3);
    }
    return rez;
  }

  public static void printArray(int[] intArray) {
    System.out.print("[");
    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i]);
      if (i != intArray.length - 1) {
        System.out.print(", ");
      } else {
        System.out.println("]");
      }
    }
  }
}
