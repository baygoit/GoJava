package string;

import java.util.ArrayList;

/*
    You have an array of integers where each number appears 3 times except one.
    Like [2, 3, 2, 4, 3, 7, 2, 3, 4, 4].
    Please find this ‘lonely’ integer number in array.
*/

/*  Test cases

    Array of integers:
    [2, 3, 2, 4, 3, 7, 2, 3, 4, 4]

    Binary array:
    [010, 011, 010, 100, 011, 111, 010, 011, 100, 100]

    Sum: [4, 7, 4]

    LonelyNumber: 7
*/

public class LonelyNumber {

  public static int[] intArray = {2, 3, 2, 4, 3, 7, 2, 3, 4, 4};
  public static final byte REPEAT_COUNT = 3;
  public static ArrayList<String> binaryArray = new ArrayList<String>();
  public static StringBuilder temp = new StringBuilder();
  public static int countDigits;
  public static ArrayList<Integer> sum = new ArrayList<Integer>();

  public static void main(String[] args) {
    System.out.println("Array of integers:");
    printArray(intArray);
    getBinaryArray();
    appendZeros();
    System.out.println("\nBinary array:");
    printArray(binaryArray);
    calculateSum();
    System.out.println("\nSum: " + sum + "\n");
    getLonelyNumber();
  }

  private static void getBinaryArray() {
    for (int i = 0; i < intArray.length; i++) {
      binaryArray.add(Integer.toBinaryString(intArray[i]));
    }
  }

  private static void appendZeros() {
    countDigits();
    for (int i = 0; i < binaryArray.size(); i++) {
      if (binaryArray.get(i).length() <= countDigits) {
        for (int j = 0; j < countDigits - binaryArray.get(i).length(); j++) {
          temp.append("0");
        }
        temp.append(binaryArray.get(i));
        binaryArray.set(i, temp.toString());
        temp.delete(0, temp.length());
      }
    }
  }

  private static int countDigits() {
    countDigits = 0;
    for (int i = 0; i < binaryArray.size(); i++) {
      if (countDigits <= binaryArray.get(i).length()) {
        countDigits = binaryArray.get(i).length();
      }
    }
    return countDigits;
  }

  private static void calculateSum() {
    int sum1 = 0;
    for (int i = 0; i < binaryArray.get(i).length(); i++) {
      for (int j = 0; j < binaryArray.size(); j++) {
        sum1 += Integer.parseInt(String.valueOf(binaryArray.get(j).charAt(i)));
      }
      sum.add(i, sum1);
      sum1 = 0;
    }
  }

  private static void getLonelyNumber() {
    System.out.print("LonelyNumber: ");
    for (int i = 0; i < sum.size(); i++) {
      if (sum.get(i) % REPEAT_COUNT != 0) {
        temp.append(1);
      } else {
        temp.append(0);
      }
    }
    System.out.println(Integer.parseInt(String.valueOf(temp), 2));
  }

  public static void printArray(ArrayList binaryArray) {
    System.out.println(binaryArray);
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