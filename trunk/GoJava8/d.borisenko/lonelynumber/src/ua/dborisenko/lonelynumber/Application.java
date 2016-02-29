package ua.dborisenko.lonelynumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static int LONELY_COUNT_THRESHOLD = 2;
    private static int[] TEST_ARRAY = { 2, 3, 2, 4, 3, 7, 2, 3, 4, 4 };

    private int[] getNumbers() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();
        if (0 == inputString.length()) {
            return TEST_ARRAY;
        }
        String[] tempNumbers = inputString.split(" ");
        int[] inputNumbers = new int[tempNumbers.length];
        for (int i = 0; i < tempNumbers.length; i++) {
            inputNumbers[i] = Integer.valueOf(tempNumbers[i]);
        }
        return inputNumbers;
    }

    private int countNumberEntries(List<Integer> numbers, int number) {
        int entryCount = 0;
        for (int currentNumber : numbers) {
            if (number == currentNumber) {
                entryCount++;
            }
        }
        return entryCount;
    }

    private List<Integer> findLonelyNumbers(List<Integer> inputNumbers) {
        List<Integer> lonelyNumbers = new ArrayList<Integer>();
        for (int number : inputNumbers) {
            if (countNumberEntries(inputNumbers, number) <= LONELY_COUNT_THRESHOLD
                    && 0 == countNumberEntries(lonelyNumbers, number)) {
                lonelyNumbers.add(number);
            }
        }
        return (lonelyNumbers);
    }

    private List<Integer> convertIntArrayToList(int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int number : array) {
            list.add(number);
        }
        return list;
    }

    public void start() {
        System.out.println("Enter the numbers divided with a space or press Enter to use test array:");
        List<Integer> inputNumbers = convertIntArrayToList(getNumbers());
        System.out.println("Given array: ");
        System.out.println(inputNumbers.toString());
        List<Integer> lonelyNumbers = findLonelyNumbers(inputNumbers);
        System.out.println("Lonely numbers: ");
        System.out.println(lonelyNumbers.toString());
    }
}
