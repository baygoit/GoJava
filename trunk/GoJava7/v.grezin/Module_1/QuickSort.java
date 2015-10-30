package com.gmail.grezin.v;

/*
 * Task 7: Implement any array sort.
 */
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int modeswitcher = -1;
		// TODO Auto-generated method stub
		int[] numbersArray = new int[8];
		String manualEnterData = "";
		System.out.println("Please choose how generate array 0- manual mode, 1-automatical");
		modeswitcher = sc.nextInt();
		sc.nextLine();
		if (modeswitcher == 1) {
			numbersArray = generateRandomArray(numbersArray);
		}
		if (modeswitcher == 0) {
			System.out.println("Enter array");
			manualEnterData = sc.nextLine();
			numbersArray = getArray(manualEnterData);
		}
		sortQuick(numbersArray, 0, numbersArray.length - 1);
		for (int a : numbersArray)
			System.out.print(a + " ");

		sc.close();

	}

	public static void sortQuick(int[] numbers, int first, int last) {
		int middle;
		if (first < last) {
			middle = partision(numbers, first, last);
			sortQuick(numbers, first, middle - 1);
			sortQuick(numbers, middle + 1, last);
		}

	}

	public static int partision(int[] numbers, int first, int last) {
		int middleElement = numbers[last];
		int middleIndex = first;
		for (int i = first; i < last; i++) {
			if (numbers[i] <= middleElement) {
				swap(numbers, middleIndex, i);
				middleIndex++;
			}
		}
		// if(middleIndexfirst){
		swap(numbers, middleIndex, last);
		// }
		return middleIndex;
	}

	public static void swap(int[] numbersArray, int i, int j) {
		int temp;
		temp = numbersArray[i];
		numbersArray[i] = numbersArray[j];
		numbersArray[j] = temp;
	}

	public static int[] generateRandomArray(int[] emptyArray) {
		Random rn = new Random();
		int[] fullArray = new int[emptyArray.length];
		for (int i = 0; i < emptyArray.length; i++) {
			fullArray[i] = rn.nextInt(10);
			System.out.print(fullArray[i] + " ");
		}
		System.out.println();
		return fullArray;
	}

	public static int[] getArray(String manualEnterData) {
		String[] linesArray = { "" };
		int[] generatedArray;
		int position;
		position = manualEnterData.indexOf(" ");
		if (position != -1) {
			linesArray = manualEnterData.split("[ ]");
		}
		position = manualEnterData.indexOf(",");
		if (position != -1) {
			linesArray = manualEnterData.split("[,]");
		}
		position = manualEnterData.indexOf(";");
		if (position != -1) {
			linesArray = manualEnterData.split("[;]");
		}
		generatedArray = new int[linesArray.length];
		for (int i = 0; i < linesArray.length; i++) {
			generatedArray[i] = Integer.parseInt(linesArray[i]);
			System.out.print(generatedArray[i] + " ");
		}
		System.out.println();
		return generatedArray;
	}
}
