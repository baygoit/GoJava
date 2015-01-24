package gojava1.iavorskyi;

import java.util.Scanner;

public class DistanceCalculator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("¬ведите р€д целых чисел, разделенных пробелом:");
        String input = in.nextLine();
        int[] numbers = makeIntArr(input);
        System.out.println(calculateDistance(numbers));
        in.close();

    }

    // Parse out input to double array
    static int[] makeIntArr(String input) {
        String[] separatedInput = input.split(" ");
        int[] numbers = new int[separatedInput.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(separatedInput[i]);
        }
        return numbers;
    }

    // Calculating distance between two smallest numbers
    static int calculateDistance(int[] arr) {

        int min1 = arr[0];
        int index1 = 0;
        int min2 = arr[1];
        int index2 = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min1) {
                min1 = arr[i];
                index1 = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min2 && i != index1) {
                min2 = arr[i];
                index2 = i;
            }
        }
        
        return Math.abs(index1 - index2);

    }

}